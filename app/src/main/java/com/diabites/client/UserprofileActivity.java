package com.diabites.client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ChoiceActivity;
import com.diabites.R;

import static com.Network.getClient.Imageurl;


public class UserprofileActivity extends AppCompatActivity {

    TextView tv_email,tv_address,tv_fname,tv_lname,tv_gender,tv_conatc;
    ImageView iv_image;
    Button bt_logout;
    SharedPreferences sharedPreferences;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinet_profile);
        sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String user_email= sharedPreferences.getString("u_email", "");
        String u_fname= sharedPreferences.getString("u_fname", "");
        user_id=sharedPreferences.getString("u_id", "");
//        String c_i_add= sharedPreferences.getString("c_i_add", "");
        String c_i_con_num= sharedPreferences.getString("u_phone_no", "");
        String c_gender= sharedPreferences.getString("u_gender", "");
        String status= sharedPreferences.getString("u_status", "");

        String u_lname= sharedPreferences.getString("u_lname", "");

        String c_pic= sharedPreferences.getString("u_pic", "");
        String url=Imageurl+c_pic;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_email=findViewById(R.id.tv_email);
        tv_fname=findViewById(R.id.tv_name);
        tv_lname=findViewById(R.id.tv_lname);
        tv_address=findViewById(R.id.tv_address);
        tv_gender=findViewById(R.id.tv_gender);
        tv_conatc=findViewById(R.id.tv_contact);
        bt_logout=findViewById(R.id.bt_ulogout);
        tv_email.setText(user_email);
        tv_fname.setText(u_fname);
        tv_lname.setText(u_lname);
        tv_gender.setText(c_gender);
        tv_conatc.setText(c_i_con_num);

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent i=new Intent(UserprofileActivity.this, ChoiceActivity.class);
                startActivity(i);
                finish();
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
}
