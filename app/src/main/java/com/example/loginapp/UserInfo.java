package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.R.*;

public class UserInfo extends AppCompatActivity {
/*
    Spinner spinner = (Spinner) findViewById(R.id.sp_user_country);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.spinner_choose_country, layout.simple_spinner_item);

    adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);   // Specify the layout to use when the list of choices appears
    spinner.setAdapter(adapter);    // Apply the adapter to the spinner

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }
}
