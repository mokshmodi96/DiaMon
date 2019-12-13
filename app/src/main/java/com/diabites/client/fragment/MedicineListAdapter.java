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

import com.GetSet.medical;
import com.GetSet.medicine;
import com.GetSet.usermedicine;
import com.Network.ApiInterface;
import com.diabites.R;

import java.util.List;


public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<medicine> docdata;
    FragmentActivity ac;

    ApiInterface apiService;



    public MedicineListAdapter(FragmentActivity activity, List<medicine> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata=postList;
        this.ac=activity;


    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        View view = inflater.inflate(R.layout.medicine_custome_list_row,parent,false);
        myViewHolder holder = new myViewHolder(view);
 
        return holder;
    }
 
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
 
        holder.tv_mname.setText(docdata.get(position).getM_name());
        holder.tv_price.setText("Rs."+docdata.get(position).getM_price());
        holder.tv_companyname.setText("Company Name:"+docdata.get(position).getM_company());
        holder.tv_drug.setText(docdata.get(position).getM_drug());
        holder.tv_drugtype.setText(docdata.get(position).getM_drug_type());



//        holder._imgview.setImageResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return  docdata.size();
    }
 
   public class myViewHolder extends RecyclerView.ViewHolder {
 
       TextView tv_mname,tv_price,tv_companyname,tv_drug,tv_drugtype;

 
        public myViewHolder(View itemView) {
 
            super(itemView);
            tv_mname=itemView.findViewById(R.id.tv_medicinename);
            tv_price=itemView.findViewById(R.id.tv_price);
            tv_companyname=itemView.findViewById(R.id.tv_company);
            tv_drug=itemView.findViewById(R.id.tv_drug);
            tv_drugtype=itemView.findViewById(R.id.tv_drugtype);

        }
    }
}