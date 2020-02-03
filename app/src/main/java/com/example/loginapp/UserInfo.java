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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.time.Year;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class UserInfo extends AppCompatActivity {

    private static final String TAG = "UserInfo";

    EditText etName;
    EditText etUsername;
    Button btnChangePhoto;
    EditText etAge;
    RadioGroup rgChooseGender;
    Spinner spUserCountry;
    EditText etPostalAddress;
    Button btnSaveUserInfo;
    Button btnDatePicker;

    String userBday;
    String gender;

    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.activity_user_info);
        etName = findViewById(R.id.et_name);
        etUsername = findViewById(R.id.et_username);
        etPostalAddress = findViewById(R.id.et_postal_address);
        spUserCountry = findViewById(R.id.sp_user_country);
        btnChangePhoto = findViewById(R.id.btn_change_photo);
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
                                userBday = month+"/"+dayOfMonth+"/"+year;
                                etAge.setText(String.valueOf(getAge(year, month, dayOfMonth)));
                            }
                        }, year, monthOfYear, dayOfMonth);
                picker.show();
            }
        });
   }

    public void onRadioButtonClicked(View view) {
        Log.d(TAG, "onRadioButtonClicked: ");
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_female:
                if (checked)
                    gender = "female";
                    // Pirates are the best
                    break;
            case R.id.rb_male:
                if (checked)
                    gender = "male";
                    // Ninjas rule
                    break;
            case R.id.rb_not_specified:
                if (checked)
                    gender = "Not specified";
                    // not specified
                    break;
        }
    }
    public int getAge( int year, int month, int day){
        Log.d(TAG, "getAge: ");
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
        Log.d(TAG, "ListOfUsers: ");
        PojoUsers userInfo = new PojoUsers();

        userInfo.setName(etName.getText().toString());
        userInfo.setUsername(etUsername.getText().toString());
        userInfo.setBirthday(userBday);
        userInfo.setCountry(spUserCountry.getSelectedItem().toString());
        userInfo.setGender(gender);
        userInfo.setPostalAddress(etPostalAddress.getText().toString());

        Intent intent = new Intent();
        intent.setClass(UserInfo.this, ListOfUsers.class);
        intent.putExtra("data", userInfo);
        startActivity(intent);

    }
}

