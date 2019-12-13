package com.Network;


import com.GetSet.appionmentdata;
import com.GetSet.commondata;
import com.GetSet.doclogin;
import com.GetSet.medical;
import com.GetSet.medicine;
import com.GetSet.prescdata;
import com.GetSet.userlogin;
import com.GetSet.usermedicine;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<doclogin>> DocLogin(@Field("diamon") String ppc_fun, @Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<userlogin>> UserLogin(@Field("diamon") String admin_fun, @Field("email") String email, @Field("password") String password);
    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<doclogin>> DocList(@Field("diamon") String admin_fun,@Field("c_id") String c_id);
    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<appionmentdata>> getappionmentuser(@Field("diamon") String admin_fun, @Field("u_id") String u_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<appionmentdata>> getappionmentdoc(@Field("diamon") String admin_fun, @Field("d_id") String d_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<medical>> Medicalstore(@Field("diamon") String admin_fun);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<medicine>> Medicinestore(@Field("diamon") String admin_fun);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<usermedicine>> medicine_byuser(@Field("diamon") String ppc_fun, @Field("c_id") String c_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<prescdata>> medicine_bydoc(@Field("diamon") String ppc_fun, @Field("d_id") String d_id, @Field("c_id") String c_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<prescdata>> medicine_bydoc1(@Field("diamon") String ppc_fun, @Field("c_id") String c_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<userlogin>> UserListDoc(@Field("diamon") String ppc_fun, @Field("d_id") String d_id);
    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<userlogin>> AUserListDoc(@Field("diamon") String ppc_fun, @Field("d_id") String d_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> UsreuestDoc(@Field("diamon") String ppc_fun, @Field("u_id") String u_id, @Field("d_id") String d_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> Sendatodoc(@Field("diamon") String ppc_fun, @Field("u_id") String u_id, @Field("d_id") String d_id,@Field("adate") String adate,@Field("atime") String atime);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> Doctouser(@Field("diamon") String ppc_fun, @Field("d_id") String d_id, @Field("u_id") String u_id);

       @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> docapaprove(@Field("diamon") String ppc_fun, @Field("a_d_id") String a_d_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> doccanapaprove(@Field("diamon") String ppc_fun, @Field("a_d_id") String a_d_id);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> DoctorRegister(
            @Field("diamon") String admin_fun,
            @Field("email") String email,
            @Field("password") String password,
            @Field("d_firstname") String d_firstname,
            @Field("d_lastname") String d_lastname,
            @Field("d_contact_info") String d_contact_info,
            @Field("d_address") String d_address,
            @Field("d_city") String d_city,
            @Field("d_pincode") String d_pincode,
            @Field("d_reg") String d_reg,
            @Field("d_degree") String d_degree,
            @Field("d_gender") String d_gender);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> UserRegister(
            @Field("diamon") String admin_fun,
            @Field("email") String email,
            @Field("password") String password,
            @Field("u_fname") String u_fname,
            @Field("u_lname") String u_lname,
            @Field("u_phone_no") String u_phone_no,
            @Field("u_gender") String u_gender);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> UserProfile(
            @Field("diamon") String admin_fun,
            @Field("c_id") String c_id,
            @Field("c_pic") String c_pic);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> DocProfile(
            @Field("ppc_fun") String admin_fun,
            @Field("d_id") String d_id,
            @Field("d_pic") String d_pic);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> add_medicne(
            @Field("diamon") String admin_fun,
            @Field("d_id") String d_id,
            @Field("c_id") String c_id,
            @Field("medicine_list") String medicine_list,
            @Field("m_desc") String m_desc,
            @Field("month") String month);


    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> add_report(
            @Field("diamon") String admin_fun,
            @Field("d_id") String d_id,
            @Field("c_id") String c_id,
            @Field("pre_pic") String m_desc,
            @Field("pre_detail") String r_document,
            @Field("r_id") String r_id);
    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> add_report1(
            @Field("diamon") String admin_fun,
            @Field("d_id") String d_id,
            @Field("c_id") String c_id,
            @Field("pre_pic") String m_desc,
            @Field("pre_detail") String r_document);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> UserChangepassword(@Field("diamon") String admin_fun, @Field("c_id") String u_id, @Field("c_password") String u_password);

    @FormUrlEncoded
    @POST("mb_function.php")
    Call<ArrayList<commondata>> docChangepassword(@Field("diamon") String admin_fun, @Field("d_id") String d_id, @Field("d_password") String d_password);



}
