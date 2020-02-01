package com.example.loginapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.content.Context;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

public class UserInfo extends AppCompatActivity {

    private static final String TAG = "UserInfo";

    EditText etAge;
    Button btnDatePicker;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.activity_user_info);
        etAge = findViewById(R.id.et_age);
        btnDatePicker = findViewById(R.id.btn_choose_birthday);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int monthOfYear = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                picker = new DatePickerDialog(UserInfo.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                etAge.setText(String.valueOf(getAge(year, month, dayOfMonth)));
                            }
                        }, year, monthOfYear, dayOfMonth);
                picker.show();
            }
        });

   }

    public int getAge( int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - (dob.get(Calendar.YEAR));

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public void ListOfUsers(View view) {
        Intent intent = new Intent();
        intent.setClass(UserInfo.this, ListOfUsers.class);
        startActivity(intent);
    }
}

