package com.example.loginapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvUsername;
    TextView tvGender;
    TextView tvCountry;
    TextView tvPostalAddress;
    TextView tvBirthday;
    ImageView ivProfilePic;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_user_name);
        tvUsername = itemView.findViewById(R.id.tv_user_username);
        tvGender = itemView.findViewById(R.id.tv_user_gender);
        tvCountry = itemView.findViewById(R.id.tv_user_country);
        tvPostalAddress = itemView.findViewById(R.id.tv_user_postal_address);
        tvBirthday = itemView.findViewById(R.id.tv_user_birthday);
        ivProfilePic = itemView.findViewById(R.id.iv_user_profile_pic);
    }

    public void onBind(final PojoUsers user) {
        tvName.setText(user.getName());
        tvUsername.setText(user.getUsername());
        tvGender.setText(user.getGender());
        tvCountry.setText(user.getCountry());
        tvPostalAddress.setText(user.getPostalAddress());
        tvBirthday.setText(user.getBirthday());
        ivProfilePic.setImageResource(R.drawable.ic_android_green_24dp);
    }
}