package com.diabites.client;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.GetSet.commondata;
import com.GetSet.prescdata;
import com.Network.ApiInterface;
import com.Network.ImageUtils;
import com.Network.getClient;
import com.diabites.DividerItemDecoration;
import com.diabites.R;
import com.diabites.doctor.DpreListAdapter;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.diabites.doctor.DoctorDashMainActivity.doc_id;


public class DocprecpActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

String user_id;
    RecyclerView rv_subcrip;
    ImageView iv_medcine;
    private static final int PICK_IMAGE = 1994;
    ApiInterface apiService;
    UpreListAdapter dapater;
    String imagebase64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdocpre_detail);
        sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        user_id=sharedPreferences.getString("u_id", "");

        rv_subcrip=findViewById(R.id.rc_subcription);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DocprecpActivity.this);
        rv_subcrip.setLayoutManager(linearLayoutManager);
        rv_subcrip.setHasFixedSize(true);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(DocprecpActivity.this);
        rv_subcrip.addItemDecoration(dividerItemDecoration);

        doc_user_medicine_list(user_id);


    }

    private void subscriptiondialog(final String cid) {
        final Dialog dialog = new Dialog(DocprecpActivity.this);
        Button bt_chooseimage,bt_addmedicine;
        final EditText ed_desc;
        TextView tv_title;

        dialog.setContentView(R.layout.add_subc_dialog);
        bt_chooseimage=dialog.findViewById(R.id.ButtonChooseImage);
        bt_addmedicine=dialog.findViewById(R.id.ButtonUploadImage);
        ed_desc=dialog.findViewById(R.id.ImageNameEditText);
        iv_medcine=dialog.findViewById(R.id.ShowImageView);

        bt_addmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m_desc=  ed_desc.getText().toString();
                if(!TextUtils.isEmpty(m_desc))
                {
                   add_subc(doc_id,cid,imagebase64,m_desc)    ;
                    dialog.dismiss();
                }
                else{

                    Toast.makeText(DocprecpActivity.this,"Please Enter Medicine Desc",Toast.LENGTH_SHORT).show();
                }

            }
        });
        bt_chooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating intent.
                Intent intent = new Intent();

                // Setting intent type as image to select image from phone storage.
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Please Select Image"), PICK_IMAGE);

            }
        });


        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    }

    private void add_subc(String doc_id, String cid, String imagebase64, String m_desc) {

        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> user_profile_pic = apiService.add_report("add_sucription",doc_id,cid,imagebase64,m_desc,"0");
        user_profile_pic.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                Log.e("Demo",""+response.body());


                if (response.body() != null) {

                    ArrayList<commondata> login = response.body();
                    Log.e("Demo",""+login.get(0).getMsg());
                    if (login.size() > 0) {
                        if (login.get(0).getStatus().equals("1")) {
                            Toast.makeText(DocprecpActivity.this, "User Preci Added Successfully", Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(DocprecpActivity.this, " Error in adding Report!!", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(DocprecpActivity.this, "Something went wrong,Please try again later!!", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<commondata>> call, Throwable t) {
                Log.e("Error",""+t.getMessage());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                Toast.makeText(DocprecpActivity.this, "No Image Selected", Toast.LENGTH_LONG).show();
                return;
            }
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());

                Bitmap imgBitmap = BitmapFactory.decodeStream(inputStream);
                imgBitmap = ImageUtils.cropToSquare(imgBitmap);
                InputStream is = ImageUtils.convertBitmapToInputStream(imgBitmap);
                final Bitmap liteImage = ImageUtils.makeImageLite(is,
                        imgBitmap.getWidth(), imgBitmap.getHeight(),
                        ImageUtils.AVATAR_WIDTH, ImageUtils.AVATAR_HEIGHT);
                imagebase64 = ImageUtils.encodeBase64(liteImage);

                iv_medcine.setImageBitmap(imgBitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void doc_user_medicine_list( String c_id) {

        apiService = getClient.getC().create(ApiInterface.class);

        Call<ArrayList<prescdata>> add_complaint_user = apiService.medicine_bydoc1("user_subcir",c_id);

        add_complaint_user.enqueue(new Callback<ArrayList<prescdata>>() {
            @Override
            public void onResponse(Call<ArrayList<prescdata>> call, Response<ArrayList<prescdata>> response) {
                Log.e("SIze of",""+response.body() );

                if (response.body() != null) {
                    ArrayList<prescdata> login = response.body();
                    List<prescdata> postList = response.body();
                    Log.e("SIze of",""+postList.size() );
                    if(postList.get(0).getStatus().equals("1"))
                    {
                        dapater=new UpreListAdapter(DocprecpActivity.this,postList);
                        rv_subcrip.setAdapter(dapater);
                    }
                    else
                    {
                        Toast.makeText(DocprecpActivity.this,"No Medcine List Found",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<prescdata>> call, Throwable t) {
                Log.e("Hiiii",""+t);


            }
        });
    }
}
