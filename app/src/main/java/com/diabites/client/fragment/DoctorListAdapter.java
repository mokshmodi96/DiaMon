package com.diabites.client.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.GetSet.commondata;
import com.GetSet.doclogin;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.bumptech.glide.Glide;
import com.diabites.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.Network.getClient.Imageurl;
import static com.diabites.client.CliendashMainActivity.user_id;


public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.myViewHolder> {
 
    private final LayoutInflater inflater;
    List<doclogin> docdata;
    FragmentActivity ac;

    ApiInterface apiService;



    public DoctorListAdapter(FragmentActivity activity, List<doclogin> postList) {
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

        if(docdata.get(position).getP_r_status().equals("0"))
        {
            holder.bt_request.setText("Pending");
        }
        else if(docdata.get(position).getP_r_status().equals("1"))
        {
            holder.bt_request.setText("Approve");

        }
        else{
            holder.bt_request.setText("Send Request");
        }
        Log.e("Stats",docdata.get(position).getP_r_status());
        holder.bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(docdata.get(position).getP_r_status().equals("-1"))
                {
                    send_request(docdata.get(position).getD_id(),position);

                }
            }
        });


    }

    private void send_request(String d_id, final int position) {

        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> add_complaint_user = apiService.UsreuestDoc("UsreuestDoc",user_id,d_id);

        add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                if (response.body() != null) {
                    ArrayList<commondata> login = response.body();
                    Log.e("SIze of",""+login.get(0).getStatus() );
                    if(login.get(0).getStatus().equals("1"))
                    {
                        Toast.makeText(ac,"Request Send to doctor",Toast.LENGTH_SHORT).show();
                        docdata.get(position).setP_r_status("0");
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
       Button bt_request;
       RelativeLayout rl_dlist;
 
        public myViewHolder(View itemView) {
 
            super(itemView);
            _imgview = (ImageView) itemView.findViewById(R.id.img);
            _title = (TextView) itemView.findViewById(R.id.txttitle);
            _desc = (TextView) itemView.findViewById(R.id.txtdesc);
            bt_request=itemView.findViewById(R.id.bt_sendrequest);
            rl_dlist=itemView.findViewById(R.id.rl_dlist);
        }
    }
}