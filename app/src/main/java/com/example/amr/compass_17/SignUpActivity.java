package com.example.amr.compass_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, confirmEditText;
    private Button signUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        emailEditText = (EditText) findViewById(R.id.Email_SignUp_EditText);
        passwordEditText = (EditText) findViewById(R.id.Password_SingUp_EditText);
        confirmEditText = (EditText) findViewById(R.id.confirmPassword_SingUp_EditText);
        signUp = (Button) findViewById(R.id.SignUP_btn);

        auth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmEditText.getText().toString().trim();


                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter Email address!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter Password!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Confirm Password!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short. Please, Enter minimum 6 characters!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password doesn't match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if(!task.isSuccessful())
                                {
                                    Toast.makeText(SignUpActivity.this, "Registration failed." + task.getException().toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
