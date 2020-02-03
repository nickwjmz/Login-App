package com.example.loginapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private static final String TAG = "UserAdapter";

    private List<PojoUsers> dataSet;

    public void setDataSet(List<PojoUsers> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout,
                                    parent, false);
        UserViewHolder holder = new UserViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        /*
        holder.tvName.setText(dataSet.get(position).getName());
        holder.tvUsername.setText(dataSet.get(position).getUsername());
        holder.tvBirthday.setText(dataSet.get(position).getBirthday());
        holder.tvCountry.setText(dataSet.get(position).getCountry());
        holder.tvGender.setText(dataSet.get(position).getGender());
        holder.tvPostalAddress.setText(dataSet.get(position).getPostalAddress());
        */
        holder.onBind(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
