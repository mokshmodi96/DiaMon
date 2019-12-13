package com.diabites.client.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.GetSet.doclogin;
import com.GetSet.medical;
import com.Network.ApiInterface;
import com.bumptech.glide.Glide;
import com.diabites.R;

import java.util.List;

import static com.Network.getClient.Imageurl;


public class MedicalListAdapter extends RecyclerView.Adapter<MedicalListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<medical> docdata;
    FragmentActivity ac;

    ApiInterface apiService;



    public MedicalListAdapter(FragmentActivity activity, List<medical> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata=postList;
        this.ac=activity;


    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        View view = inflater.inflate(R.layout.medical_custome_list_row,parent,false);
        myViewHolder holder = new myViewHolder(view);
 
        return holder;
    }
 
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
 
        holder.tv_medicalname.setText(docdata.get(position).getM_s_name());
        holder.tv_address.setText(docdata.get(position).getM_s_address());

        holder.tv_starttime.setText("Open Time:-"+docdata.get(position).getM_s_starttime());
        holder.tv_endtime.setText("Close Time:-"+docdata.get(position).getM_s_endtime());
        holder.tv_email.setText("Email:-"+docdata.get(position).getM_s_email());
        holder.tv_conatct.setText("Contact:-"+docdata.get(position).getM_s_phone_no());

//        holder._imgview.setImageResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return  docdata.size();
    }
 
   public class myViewHolder extends RecyclerView.ViewHolder {
 
       TextView tv_medicalname,tv_address,tv_starttime,tv_endtime,tv_conatct,tv_email;
 
        public myViewHolder(View itemView) {
 
            super(itemView);
            tv_medicalname=itemView.findViewById(R.id.tv_medicalname);
            tv_address=itemView.findViewById(R.id.tv_medaddreess);
            tv_starttime=itemView.findViewById(R.id.tv_opentime);
            tv_endtime=itemView.findViewById(R.id.tv_closetime);
            tv_email=itemView.findViewById(R.id.tv_email);
            tv_conatct=itemView.findViewById(R.id.tv_mobile);


        }
    }
}