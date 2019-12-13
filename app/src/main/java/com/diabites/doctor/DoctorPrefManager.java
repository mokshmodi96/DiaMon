package com.diabites.doctor;

import android.content.Context;
import android.content.SharedPreferences;

public class DoctorPrefManager {

    Context context;

    public DoctorPrefManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails( String d_id, String d_email, String d_status, String d_firstname, String d_lastname,
                                  String d_gender, String d_contact_info,
                                  String d_address ,String d_city,String d_reg,String d_degree,String d_pic) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DoctorDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("d_id", d_id);
        editor.putString("d_email", d_email);
        editor.putString("d_status", d_status);
        editor.putString("d_firstname", d_firstname);
        editor.putString("d_lastname", d_lastname);
        editor.putString("d_gender", d_gender);
        editor.putString("d_contact_info", d_contact_info);
        editor.putString("d_address", d_address);
        editor.putString("d_city", d_city);
        editor.putString("d_reg", d_reg);
        editor.putString("d_degree", d_degree);
        editor.putString("d_pic", d_pic);
        editor.commit();



    }

    public String getDOcEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DoctorDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("d_email", "");
    }

    public boolean isDoctorLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DoctorDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("d_email", "").isEmpty();
        return isEmailEmpty ;
    }
}