package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class CreateAccount extends AppCompatActivity {

    private EditText textInputEmail;
    private EditText textInputPassword;
    private EditText textInputConfirm;
    Button btnNext;

    private boolean validateEmail() {
        String emailInput = textInputEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field cannot be empty");
            textInputEmail.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    0, 0);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            textInputEmail.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    0, 0);
            return false;
        } else {
            textInputEmail.setError(null);
            textInputEmail.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    R.drawable.tick, 0);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field cannot be empty");
            textInputPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    0, 0);
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password too weak");
            textInputPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    0, 0);
            return false;
        } else {
            textInputPassword.setError(null);
            textInputPassword.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    R.drawable.tick, 0);
            return true;
        }
    }

    private boolean validateConfirm() {
        String confirmInput = textInputConfirm.getText().toString().trim();
        String passwordInput = textInputPassword.getText().toString().trim();

        if (!confirmInput.equals(passwordInput)) {
            textInputConfirm.setError("Your passwords do not match");
            textInputConfirm.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    0,0);
            return false;
        } else if (passwordInput.isEmpty()) {
            textInputConfirm.setError("Field cannot be empty");
            textInputConfirm.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    0,0);
            return false;
        }
        else {
            textInputConfirm.setError(null);
            textInputConfirm.setCompoundDrawablesWithIntrinsicBounds(0,0,
                    R.drawable.tick, 0);
            return true;
        }
    }

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[@#$()%^&!+=])" +    //at least 1 special character
                    ".{8,}" +               //at least 8 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        textInputEmail = findViewById(R.id.etEmail);
        textInputPassword = findViewById(R.id.etCreatePw);
        textInputConfirm = findViewById(R.id.etRepeatPw);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setEnabled(false);

        final TextView emailError = findViewById(R.id.error_email);
        emailError.setVisibility(View.GONE);

        final TextView passwordError = findViewById(R.id.error_pw);
        passwordError.setVisibility(View.GONE);

        textInputEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (validateEmail()) {
                        emailError.setVisibility(View.GONE);
                    } else {
                        emailError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        textInputPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (validatePassword()) {
                        passwordError.setVisibility(View.GONE);
                    } else {
                        passwordError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        textInputConfirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (validateConfirm()) {
                        passwordError.setVisibility(View.GONE);
                        if (validateEmail()) {
                            btnNext.setEnabled(true);
                        }
                    } else {
                        passwordError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    public void UserInfo(View view) {
        String password = textInputPassword.getText().toString();

        Intent intent = new Intent(CreateAccount.this, UserInfo.class);
        intent.putExtra("Password", password);
        startActivity(intent);
    }

}