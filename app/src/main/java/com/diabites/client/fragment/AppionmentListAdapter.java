package com.diabites.client.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.GetSet.appionmentdata;
import com.diabites.R;

import java.util.List;


public class AppionmentListAdapter extends RecyclerView.Adapter<AppionmentListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<appionmentdata> docdata;
    FragmentActivity ac;


    public AppionmentListAdapter(FragmentActivity activity, List<appionmentdata> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata = postList;
        this.ac = activity;

    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.appoinment_custome_list_row, parent, false);
        myViewHolder holder = new myViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {

        holder.tv_appionmentby.setText("Dr."+docdata.get(position).getD_firstname());
        holder.tv_appiodate.setText("Date:- " + docdata.get(position).getA_date());
        holder.tv_appiotime.setText("Time:- " + docdata.get(position).getA_time());
        if (docdata.get(position).getA_status().equals("0")) {
            holder.tv_appionstatus.setText("Appointment Status :- Pending");

        }
        if (docdata.get(position).getA_status().equals("1")) {
            holder.tv_appionstatus.setText("Appointment Status :- Approved");

        }
        if (docdata.get(position).getA_status().equals("-1")) {
            holder.tv_appionstatus.setText("Appointment Status :- Cancel");

        }

    }


    @Override
    public int getItemCount() {
        return docdata.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView tv_appionmentby, tv_appiodate, tv_appiotime, tv_appionstatus;


        public myViewHolder(View itemView) {

            super(itemView);
            tv_appionmentby = itemView.findViewById(R.id.tv_appionmentby);
            tv_appiodate = itemView.findViewById(R.id.tv_apdate);
            tv_appiotime = itemView.findViewById(R.id.tv_aptime);
            tv_appionstatus = itemView.findViewById(R.id.tv_apstatus);

        }
    }
}