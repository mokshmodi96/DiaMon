package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diabites.R;
import com.diabites.client.CliendashMainActivity;
import com.diabites.client.ClientMainActivity;
import com.diabites.android.activity.MainActivity;
import com.diabites.client.UserPrefManager;
import com.diabites.doctor.DoctorDashMainActivity;
import com.diabites.doctor.DoctorMainActivity;
import com.diabites.doctor.DoctorPrefManager;


public class ChoiceActivity extends AppCompatActivity {
Button bt_user,bt_docotor,bt_dib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.left_enter,R.anim.right_out);

        if(new UserPrefManager(this).isUserLogedOut()==false)
        {
            Intent i=new Intent(ChoiceActivity.this, CliendashMainActivity.class);
            startActivity(i);
            finish();
        }
        if(new DoctorPrefManager(this).isDoctorLogedOut()==false)
        {
            Intent i=new Intent(ChoiceActivity.this, DoctorDashMainActivity.class);
            startActivity(i);
            finish();
        }
        setContentView(R.layout.activity_choice);
        bt_user=findViewById(R.id.bt_user);
        bt_docotor=findViewById(R.id.bt_doc);
        bt_dib=findViewById(R.id.bt_diab);


        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChoiceActivity.this, ClientMainActivity.class);
                startActivity(i);
            }
        });
        bt_docotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChoiceActivity.this, DoctorMainActivity.class);
                startActivity(i);
            }
        });
        bt_dib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChoiceActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
