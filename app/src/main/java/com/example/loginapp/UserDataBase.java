package com.example.loginapp;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    public static List<PojoUsers> userDB;

    public static void init(){
        userDB = new ArrayList<>();
    }
}
