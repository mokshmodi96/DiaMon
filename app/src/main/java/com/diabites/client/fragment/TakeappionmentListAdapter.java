package com.diabites.client.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.GetSet.commondata;
import com.GetSet.doclogin;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.bumptech.glide.Glide;
import com.diabites.R;
import com.diabites.client.DocDetailActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.Network.getClient.Imageurl;
import static com.diabites.client.CliendashMainActivity.user_id;


public class TakeappionmentListAdapter extends RecyclerView.Adapter<TakeappionmentListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<doclogin> docdata;
    FragmentActivity ac;

    ApiInterface apiService;
    private int mYear, mMonth, mDay, mHour, mMinute;



    public TakeappionmentListAdapter(FragmentActivity activity, List<doclogin> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata=postList;
        this.ac=activity;


    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        View view = inflater.inflate(R.layout.doctor_custome_list_row,parent,false);
        myViewHolder holder = new myViewHolder(view);
 
        return holder;
    }
 
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
 
        holder._title.setText(docdata.get(position).getD_firstname());
        holder._desc.setText(docdata.get(position).getD_address());
String url=Imageurl+docdata.get(position).getD_pic();
        Glide.with(ac)
                .load(url)
                .error(R.mipmap.ic_launcher_foreground)
                .into(holder._imgview);
        holder.bt_report.setVisibility(View.GONE);

       if(docdata.get(position).getP_r_status().equals("1"))
        {
            holder.bt_request.setText("Take Appionment");
holder.bt_report.setVisibility(View.VISIBLE);

            //then we will inflate the custom alert dialog xml that we created


        }
        holder.bt_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ac, DocDetailActivity.class);
                i.putExtra("d_id",docdata.get(position).getD_id());
                i.putExtra("d_name",docdata.get(position).getD_firstname());
                i.putExtra("d_email",docdata.get(position).getD_email());
                i.putExtra("d_pic",docdata.get(position).getD_pic());
                i.putExtra("d_mobile",docdata.get(position).getD_contact_info());
                ac.startActivity(i);

            }
        });

        holder.bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String doc_id=docdata.get(position).getD_id();
                final View dialogView = LayoutInflater.from(ac).inflate(R.layout.doc_appi_dialog, null);
                LinearLayout ln_date,ln_time;
                Button bt_bookappoinmnet,bt_date,bt_time;
                final TextView tv_date,tv_time;

                ln_date=dialogView.findViewById(R.id.ln_date);
                ln_time=dialogView.findViewById(R.id.ln_time);
                bt_date=dialogView.findViewById(R.id.bt_date);
                bt_time=dialogView.findViewById(R.id.bt_time);
                tv_date=dialogView.findViewById(R.id.tv_date);
                tv_time=dialogView.findViewById(R.id.tv_time);
                bt_bookappoinmnet=dialogView.findViewById(R.id.bt_bookappioment);

                bt_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);


                        DatePickerDialog datePickerDialog = new DatePickerDialog(ac,
                                new DatePickerDialog.OnDateSetListener() {

                                    @Override
                                    public void onDateSet(DatePicker view, int year,
                                                          int monthOfYear, int dayOfMonth) {

                                        tv_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//                              txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                    }
                                }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });
                bt_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        mHour = c.get(Calendar.HOUR_OF_DAY);
                        mMinute = c.get(Calendar.MINUTE);

                        // Launch Time Picker Dialog
                        TimePickerDialog timePickerDialog = new TimePickerDialog(ac,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {
                                        tv_time.setText(hourOfDay + ":" + minute);
                                        //txtTime.setText(hourOfDay + ":" + minute);
                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();
                    }
                });
                ln_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);


                        DatePickerDialog datePickerDialog = new DatePickerDialog(ac,
                                new DatePickerDialog.OnDateSetListener() {

                                    @Override
                                    public void onDateSet(DatePicker view, int year,
                                                          int monthOfYear, int dayOfMonth) {
                                        tv_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

//                                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                    }
                                }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });
                ln_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        mHour = c.get(Calendar.HOUR_OF_DAY);
                        mMinute = c.get(Calendar.MINUTE);

                        // Launch Time Picker Dialog
                        TimePickerDialog timePickerDialog = new TimePickerDialog(ac,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {
                                        tv_time.setText(hourOfDay + ":" + minute);

                                        //txtTime.setText(hourOfDay + ":" + minute);
                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();
                    }
                });

                //Now we need an AlertDialog.Builder object
                AlertDialog.Builder builder = new AlertDialog.Builder(ac);

                //setting the view of the builder to our custom view that we already inflated
                builder.setView(dialogView);

                //finally creating the alert dialog and displaying it
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                bt_bookappoinmnet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String t_date=tv_date.getText().toString();
                        String t_time=tv_time.getText().toString();
                        send_request(doc_id,user_id,t_date,t_time);
                        alertDialog.dismiss();

                    }
                });

            }
        });


    }

    private void send_request(String doc_id, String user_id, String t_date, String t_time) {


        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> add_complaint_user = apiService.Sendatodoc("sendappionment",user_id,doc_id,t_date,t_time);

        add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                if (response.body() != null) {
                    ArrayList<commondata> login = response.body();
                    Log.e("SIze of",""+login.get(0).getStatus() );
                    if(login.get(0).getStatus().equals("1"))
                    {
                        Toast.makeText(ac,"Appionment Request Send to doctor",Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();

                    }
                    else{
                        Toast.makeText(ac,"Error Request Send to doctor",Toast.LENGTH_SHORT).show();

                    }

//                    WorkerViewAdapter adapter = new WorkerViewAdapter(getActivity(), postList);
//                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<commondata>> call, Throwable t) {
                Log.e("Hiiii",""+t);


            }
        });


    }



    @Override
    public int getItemCount() {
        return  docdata.size();
    }
 
   public class myViewHolder extends RecyclerView.ViewHolder {
 
       ImageView _imgview;
       TextView _title;
       TextView _desc;
       Button bt_request,bt_report;
       RelativeLayout rl_dlist;
 
        public myViewHolder(View itemView) {
 
            super(itemView);
            _imgview = (ImageView) itemView.findViewById(R.id.img);
            _title = (TextView) itemView.findViewById(R.id.txttitle);
            _desc = (TextView) itemView.findViewById(R.id.txtdesc);
            bt_request=itemView.findViewById(R.id.bt_sendrequest);
            bt_report=itemView.findViewById(R.id.bt_ddetail);
            rl_dlist=itemView.findViewById(R.id.rl_dlist);
        }
    }


}