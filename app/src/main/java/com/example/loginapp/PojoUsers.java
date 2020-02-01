package com.example.loginapp;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;


public class PojoUsers implements Parcelable {

    private String name;
    private String username;
    private String country;
    private String birthday;
    private String gender;
    private String postalAddress;
    private Image profilePicture;

    // Empty Constructor
    PojoUsers(){}

    // Constructor loaded with Parcel.
    protected PojoUsers(Parcel in) {
        name = in.readString();
        username = in.readString();
        country = in.readString();
        birthday = in.readString();
        gender = in.readString();
        postalAddress = in.readString();
        // todo read image
    }

    public static final Creator<PojoUsers> CREATOR = new Creator<PojoUsers>() {
        @Override
        public PojoUsers createFromParcel(Parcel in) {
            return new PojoUsers(in);
        }

        @Override
        public PojoUsers[] newArray(int size) {
            return new PojoUsers[size];
        }
    };

    @Override
    public String toString() {

        return "PojoUsers{" +
                "name=" + name + '\'' +
                ", username=" + username + '\'' +
                ", country=" + country + '\'' +
                ", birthday=" + birthday + '\'' +
                ", gender=" + gender + '\'' +
                ", postalAddress=" + postalAddress +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(country);
        dest.writeString(birthday);
        dest.writeString(gender);
        dest.writeString(postalAddress);
    }
}
