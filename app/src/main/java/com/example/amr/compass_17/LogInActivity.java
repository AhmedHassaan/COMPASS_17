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

    private EditText emailEditText,passwordEditText;
    private Button logIn,forgetPassword,signUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
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
                String password = passwordEditText.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passwordEditText.length() < 6)
                {
                    Toast.makeText(LogInActivity.this, "Password too short. Please, Enter minimum 6 characters!", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(LogInActivity.this, "Login Failed ", Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(LogInActivity.this,ForgotPasswordActivity.class));
                finish();
            }
        });






        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
                finish();
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
