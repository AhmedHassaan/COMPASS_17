package com.example.amr.compass_17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.amr.compass_17.data.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    Button logIn,forgetPassword,signUp;
    ProgressBar progressBar;
    FirebaseAuth auth;
    Users data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        data = new Users(getApplicationContext());
        emailEditText = (EditText)findViewById(R.id.Email_logIn_EditText);
        passwordEditText = (EditText)findViewById(R.id.Password_logIn_EditText);
        logIn = (Button)findViewById(R.id.logIn_btn);
        forgetPassword = (Button)findViewById(R.id.forget_password_btn);
        signUp = (Button)findViewById(R.id.signUp_activity_launcher);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        if(auth == null)
        {
            Toast.makeText(this,"Login is unable now, we are very sorry",Toast.LENGTH_LONG).show();
        }

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(!task.isSuccessful())
                        {
                            if(passwordEditText.length() < 6)
                            {
                                Toast.makeText(LogInActivity.this, "Password is less than 6 chars", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(LogInActivity.this, "Login Failed ", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            data.setLogin(email);
                            Toast.makeText(LogInActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LogInActivity.this,MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch forget password
            }
        });






        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch signUp activity
            }
        });
    }

    @Override
    public void onBackPressed() {
//        data.setOut(true);
//        finish();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Exit me", true);
        startActivity(intent);
        finish();

    }
}
