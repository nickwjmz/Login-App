package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
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

    private boolean validateEmail() {
        String emailInput = textInputEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
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
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password too weak");
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
            return false;
        } else if (passwordInput.isEmpty()) {
            textInputConfirm.setError("Field cannot be empty");
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
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    ".{8,}" +               //at least 8 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        textInputEmail = findViewById(R.id.etEmail);
        textInputPassword = findViewById(R.id.etCreatePw);
        textInputConfirm = findViewById(R.id.etRepeatPw);

        final TextView emailError = findViewById(R.id.error_email);
        emailError.setVisibility(View.GONE);

        final TextView passwordError = findViewById(R.id.error_pw);
        passwordError.setVisibility(View.GONE);

        textInputEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (validateEmail()) {
                        textInputEmail.setCompoundDrawablesWithIntrinsicBounds(0,
                                0, R.drawable.tick, 0);
                        emailError.setVisibility(View.GONE);
                    } else {
                        emailError.setVisibility(View.VISIBLE);
                        textInputEmail.setCompoundDrawablesWithIntrinsicBounds(0,
                                0, 0, 0);
                    }
                }
            }
        });

        textInputPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (validatePassword()) {
                        textInputPassword.setCompoundDrawablesWithIntrinsicBounds(0,
                                0, R.drawable.tick, 0);
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
                        textInputConfirm.setCompoundDrawablesWithIntrinsicBounds(0,0,
                                R.drawable.tick, 0);
                    } else {
                        passwordError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        if (validateConfirm() && validateEmail() && validatePassword()) {
            Button b = findViewById(R.id.btnNext);
            b.setEnabled(true);
        }
    }

}