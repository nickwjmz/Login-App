package com.example.loginapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<PojoUsers> dataSet;

    public void setDataSet(List<PojoUsers> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout,
                                    parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.onBind(dataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
