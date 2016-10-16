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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private  Button resetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = (EditText)findViewById(R.id.Email_Reset_EditText);
        resetPassword = (Button)findViewById(R.id.reset_btn);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter your registered Email", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(ForgotPasswordActivity.this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(Task<Void> task) {

                                progressBar.setVisibility(View.GONE);

                                if(!task.isSuccessful())
                                {
                                    Toast.makeText(ForgotPasswordActivity.this, "Failed to send reset Email!", Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(ForgotPasswordActivity.this, "We have sent you instructions to reset your password on mail!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(ForgotPasswordActivity.this,LogInActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
