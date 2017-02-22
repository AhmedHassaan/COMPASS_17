package com.example.amr.compass_17;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.Users;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity {

    Users data;
    ControlRealm realm;
    DatabaseReference db;
    private EditText login_emailEditText;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        data = new Users(getApplicationContext());
        realm = new ControlRealm(this);
        //Buttons-----------------
        logIn = (Button) findViewById(R.id.logIn_btn);

        //Text-----------

        login_emailEditText = (EditText) findViewById(R.id.Email_logIn_EditText);


        //ToolBar--------------------------
        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Welcome");
        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.black));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(context, R.color.white));

        if(data.getFirstTime()) {
            db = FirebaseDatabase.getInstance().getReference();
            DatabaseReference db1 = db.child("Accepted");
            db1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String workshop = dataSnapshot.getValue(String.class);
                    String email = dataSnapshot.getKey();
                    realm.putEmail(email, workshop);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            data.setFirstTime();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
        //login Button ----------------------------

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = login_emailEditText.getText().toString();
                String s = email;
                s = s.replace(".", "");
                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    boolean exist = realm.emailExist(s);
                    if (exist) {
                        String workshop = realm.getWorkshop(s);
                        data.setLogin(workshop);
                        Toast.makeText(getApplicationContext(),workshop,Toast.LENGTH_SHORT).show();
                        Toast.makeText(LogInActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                        finish();
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(LogInActivity.this);
                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                data.setGuest();
                                Toast.makeText(LogInActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LogInActivity.this, MainActivity.class));
                                finish();
                            }
                        });
                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog dialog = alert.create();
                        dialog.setTitle("You are not in a Workshop do you want to continue ?!");
                        dialog.show();
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogInActivity.this, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}
