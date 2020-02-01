package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsers extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter adapter = new UserAdapter();
    PojoUsers user;

    List<PojoUsers> dataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_users);

        user = getIntent().getParcelableExtra("data");

        // RecyclerView set as a LinearLayout
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Adapter
        adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setDataSet(dataSet);
    }
}
