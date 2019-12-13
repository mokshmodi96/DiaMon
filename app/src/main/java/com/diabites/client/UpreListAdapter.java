package com.diabites.client;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.GetSet.prescdata;
import com.Network.ApiInterface;
import com.bumptech.glide.Glide;
import com.diabites.R;

import java.util.List;

import static com.Network.getClient.Imageurl;


public class UpreListAdapter extends RecyclerView.Adapter<UpreListAdapter.myViewHolder> {

    private final LayoutInflater inflater;
    List<prescdata> docdata;
    FragmentActivity ac;

    ApiInterface apiService;



    public UpreListAdapter(FragmentActivity activity, List<prescdata> postList) {
        inflater = LayoutInflater.from(activity);
        this.docdata=postList;
        this.ac=activity;


    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        View view = inflater.inflate(R.layout.custome_user_prelist,parent,false);
        myViewHolder holder = new myViewHolder(view);
 
        return holder;
    }
 
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
 
        holder._title.setText("Doctor Name:-"+docdata.get(position).getU_fname());
        holder._desc.setText(docdata.get(position).getPre_detail());
        holder.tv_date.setText("Date:-"+docdata.get(position).getPre_date());
        Log.e("Data",""+docdata.get(position).getPre_pic());
String url=Imageurl+docdata.get(position).getPre_pic();
        Log.e("Preurl",""+url);
        Glide.with(ac)
                .load(url)
                .error(R.mipmap.ic_launcher_foreground)
                .into(holder._imgview);
//        holder._imgview.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return  docdata.size();
    }
 
   public class myViewHolder extends RecyclerView.ViewHolder {
 
       ImageView _imgview;
       TextView _title;
       TextView _desc,tv_date,tv_month;

 
        public myViewHolder(View itemView) {
 
            super(itemView);
            _imgview = (ImageView) itemView.findViewById(R.id.imageViewThumbnail);
            _title = (TextView) itemView.findViewById(R.id.textViewTitle);
            _desc = (TextView) itemView.findViewById(R.id.textViewDescription);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_month=itemView.findViewById(R.id.tv_month);
        }
    }
}