package com.diabites.doctor.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.GetSet.appionmentdata;
import com.GetSet.commondata;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.diabites.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.diabites.doctor.DoctorDashMainActivity.doc_id;


public class AppionmentListAdapter extends RecyclerView.Adapter<AppionmentListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<appionmentdata> docdata;
    FragmentActivity ac;
    ApiInterface apiService;


    public AppionmentListAdapter(FragmentActivity activity, List<appionmentdata> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata = postList;
        this.ac = activity;

    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.dappoinment_custome_list_row, parent, false);
        myViewHolder holder = new myViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {

        holder.tv_appionmentby.setText(docdata.get(position).getU_fname());
        holder.tv_appiodate.setText("Date:- " + docdata.get(position).getA_date());
        holder.tv_appiotime.setText("Time:- " + docdata.get(position).getA_time());
        if (docdata.get(position).getA_status().equals("0")) {
            holder.tv_appionstatus.setText("Appointment:- Pending");

        }
        if (docdata.get(position).getA_status().equals("1")) {
            holder.tv_appionstatus.setText("Appointment:- Approved");
            holder.bt_yes.setVisibility(View.GONE);
            holder.bt_cancel.setVisibility(View.GONE);

        }
        if (docdata.get(position).getA_status().equals("-1")) {
            holder.tv_appionstatus.setText("Appointment:- Cancel");
            holder.bt_yes.setVisibility(View.GONE);
            holder.bt_cancel.setVisibility(View.GONE);
        }
        holder.bt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                asend_request(docdata.get(position).getD_a_id(),position);
            }
        });
        holder.bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csend_request(docdata.get(position).getD_a_id(),position);


            }
        });

    }


    @Override
    public int getItemCount() {
        return docdata.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView tv_appionmentby, tv_appiodate, tv_appiotime, tv_appionstatus;
Button bt_yes,bt_cancel;

        public myViewHolder(View itemView) {

            super(itemView);
            tv_appionmentby = itemView.findViewById(R.id.tv_appionmentby);
            tv_appiodate = itemView.findViewById(R.id.tv_apdate);
            tv_appiotime = itemView.findViewById(R.id.tv_aptime);
            tv_appionstatus = itemView.findViewById(R.id.tv_apstatus);
            bt_yes=itemView.findViewById(R.id.bt_approve);
            bt_cancel=itemView.findViewById(R.id.bt_canel);

        }
    }

    private void asend_request(String a_d_id, final int position) {

        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> add_complaint_user = apiService.docapaprove("upappionmentdoc",a_d_id);

        add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                if (response.body() != null) {
                    ArrayList<commondata> login = response.body();
                    Log.e("SIze of",""+login.get(0).getStatus() );
                    if(login.get(0).getStatus().equals("1"))
                    {
                        Toast.makeText(ac,"Doctor Approve Status",Toast.LENGTH_SHORT).show();
                        docdata.get(position).setA_status("1");
                        notifyDataSetChanged();

                    }
                    else{
                        Toast.makeText(ac,"Error In Approve Status",Toast.LENGTH_SHORT).show();

                    }


                }
            }

            @Override
            public void onFailure(Call<ArrayList<commondata>> call, Throwable t) {
                Log.e("Hiiii",""+t);


            }
        });


    }
    private void csend_request(String a_d_id, final int position) {

        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> add_complaint_user = apiService.doccanapaprove("caappionmentdoc",a_d_id);

        add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                if (response.body() != null) {
                    ArrayList<commondata> login = response.body();
                    Log.e("SIze of",""+login.get(0).getStatus() );
                    if(login.get(0).getStatus().equals("1"))
                    {
                        Toast.makeText(ac,"Doctor Approve Status",Toast.LENGTH_SHORT).show();
                        docdata.get(position).setA_status("-1");
                        notifyDataSetChanged();

                    }
                    else{
                        Toast.makeText(ac,"Error In Approve Status",Toast.LENGTH_SHORT).show();

                    }


                }
            }

            @Override
            public void onFailure(Call<ArrayList<commondata>> call, Throwable t) {
                Log.e("Hiiii",""+t);


            }
        });


    }
}