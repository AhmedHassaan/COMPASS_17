package com.example.amr.compass_17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.amr.compass_17.data.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private EditText signup_emailEditText, signup_passwordEditText, signup_confirmEditText;
    private EditText forgot_emailEditText;
    private  Button resetPassword;
    private EditText login_emailEditText,login_passwordEditText;
    private Button logIn,forgetPassword,signUp;
    private ProgressBar progressBar_login,progressBar_forgot,progressBar_signup;
    private FirebaseAuth auth;
    Users data;
    RelativeLayout Layout_login,Layout_signup,Layout_forgot;
    Button signup_login,forgot_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        data = new Users(getApplicationContext());


        //Buttons-----------------
        signup_login = (Button)findViewById(R.id.signUpToLog);
        forgot_login = (Button)findViewById(R.id.forgotToLog);
        resetPassword = (Button)findViewById(R.id.reset_btn);
        logIn = (Button)findViewById(R.id.logIn_btn);
        forgetPassword = (Button)findViewById(R.id.forget_password_btn);
        signUp = (Button)findViewById(R.id.signUp_activity_launcher);

        //Text-----------

        forgot_emailEditText = (EditText)findViewById(R.id.Email_Reset_EditText);
        login_emailEditText = (EditText)findViewById(R.id.Email_logIn_EditText);
        login_passwordEditText = (EditText)findViewById(R.id.Password_logIn_EditText);
        signup_emailEditText = (EditText) findViewById(R.id.Email_SignUp_EditText);
        signup_passwordEditText = (EditText) findViewById(R.id.Password_SingUp_EditText);
        signup_confirmEditText = (EditText) findViewById(R.id.confirmPassword_SingUp_EditText);

        //progressBar-------------

        progressBar_login = (ProgressBar)findViewById(R.id.progressBar_login);
        progressBar_forgot = (ProgressBar)findViewById(R.id.progressBar_forgot);
        progressBar_signup = (ProgressBar)findViewById(R.id.progressBar_signup);

        //Layouts---------------

        Layout_forgot = (RelativeLayout)findViewById(R.id.layout_forgot);
        Layout_login = (RelativeLayout)findViewById(R.id.layout_login);
        Layout_signup = (RelativeLayout)findViewById(R.id.layout_signup);

        Layout_forgot.setY(2000);
        Layout_signup.setY(2000);


        //ToolBar--------------------------


        final Toolbar toolbar = (Toolbar)findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Welcome");
        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context,R.color.black));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(context,R.color.white));


        //----------------------
        auth = FirebaseAuth.getInstance();
        if(auth == null)
        {
            Toast.makeText(this,"Login is unable now, we are very sorry",Toast.LENGTH_LONG).show();
        }


        //login Button ----------------------------

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = login_emailEditText.getText().toString();
                String password = login_passwordEditText.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(login_passwordEditText.length() < 6)
                {
                    Toast.makeText(LogInActivity.this, "Password too short. Please, Enter minimum 6 characters!", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar_login.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        progressBar_login.setVisibility(View.GONE);
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


        //password change button ---------------------------

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = forgot_emailEditText.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, Enter your registered Email", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar_forgot.setVisibility(View.VISIBLE);

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(Task<Void> task) {

                                progressBar_forgot.setVisibility(View.GONE);

                                if(!task.isSuccessful())
                                {
                                    Toast.makeText(LogInActivity.this, "Failed to send reset Email!", Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(LogInActivity.this, "We have sent you instructions to reset your password on mail!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(LogInActivity.this,LogInActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });


        //sign up button --------------------

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signup_emailEditText.getText().toString().trim();
                String password = signup_passwordEditText.getText().toString().trim();
                String confirmPassword = signup_confirmEditText.getText().toString().trim();


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

                progressBar_signup.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                progressBar_signup.setVisibility(View.GONE);

                                if(!task.isSuccessful())
                                {
                                    Toast.makeText(LogInActivity.this, "Registration failed." + task.getException().toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_LONG).show();
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
                Layout_login.animate().yBy(2000).setDuration(700).start();
                Layout_forgot.animate().yBy(-2000).setDuration(700).start();
            }
        });


        signup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Layout_signup.animate().yBy(2000).setDuration(700).start();
                Layout_login.animate().yBy(-2000).setDuration(700).start();
            }
        });

        forgot_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Layout_forgot.animate().yBy(2000).setDuration(700).start();
                Layout_login.animate().yBy(-2000).setDuration(700).start();

            }
        });



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Layout_signup.animate().yBy(-2000).setDuration(700).start();
                Layout_login.animate().yBy(2000).setDuration(700).start();


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
