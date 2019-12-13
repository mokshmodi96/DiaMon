package com.diabites.client;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPrefManager {

    Context context;

    public UserPrefManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String u_id, String u_fname, String u_lname, String u_email, String u_phone_no,
                                 String u_gender,String u_pic,String u_status) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("u_id", u_id);
        editor.putString("u_fname", u_fname);
        editor.putString("u_lname", u_lname);
        editor.putString("u_email", u_email);
        editor.putString("u_phone_no", u_phone_no);
        editor.putString("u_gender", u_gender);
        editor.putString("u_pic", u_pic);
        editor.putString("u_status", u_status);
        editor.commit();



    }

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("u_email", "");
    }

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("u_email", "").isEmpty();
        return isEmailEmpty ;
    }
}