package com.diabites.doctor.fragment;

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
import com.GetSet.userlogin;
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
import static com.diabites.doctor.DoctorDashMainActivity.doc_id;


public class ClinetListAdapter extends RecyclerView.Adapter<ClinetListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<userlogin> docdata;
    FragmentActivity ac;

    ApiInterface apiService;



    public ClinetListAdapter(FragmentActivity activity, List<userlogin> postList) {
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
 
        holder._title.setText(docdata.get(position).getU_fname());
        holder._desc.setText(docdata.get(position).getU_email());
String url=Imageurl+docdata.get(position).getU_pic();
        Glide.with(ac)
                .load(url)
                .error(R.mipmap.ic_launcher_foreground)
                .into(holder._imgview);


        if(docdata.get(position).getP_r_status().equals("0"))
        {
            holder.bt_request.setText("Approve");
        }
        else if(docdata.get(position).getP_r_status().equals("1"))
        {
            holder.bt_request.setText("View Profile");

        }

        holder.bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlogin u=docdata.get(position);


                if(docdata.get(position).getP_r_status().equals("0"))
                {
                    send_request(docdata.get(position).getU_id(),position);

                }
//                if(docdata.get(position).getP_r_status().equals("1"))
//                {
//                    Intent i=new Intent(ac, UserDetailActivity.class);
//                    i.putExtra("userinfo",u);
//
//                    ac.startActivity(i);
//
//                }

            }
        });


    }


    private void send_request(String u_id, final int position) {

        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<commondata>> add_complaint_user = apiService.Doctouser("Doctouser",doc_id,u_id);

        add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
            @Override
            public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
                if (response.body() != null) {
                    ArrayList<commondata> login = response.body();
                    Log.e("SIze of",""+login.get(0).getStatus() );
                    if(login.get(0).getStatus().equals("1"))
                    {
                        Toast.makeText(ac,"Request Send to doctor",Toast.LENGTH_SHORT).show();
                        docdata.get(position).setP_r_status("1");
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