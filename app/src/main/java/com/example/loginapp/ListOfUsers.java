package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsers extends AppCompatActivity {
    private static final String TAG = "ListOfUsers";

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_users);

        PojoUsers user;

        user = getIntent().getExtras().getParcelable("data");
        UserDataBase.userDB.add(user);


        // RecyclerView set as a LinearLayout
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Adapter
        UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setDataSet(UserDataBase.userDB);
    }
}
