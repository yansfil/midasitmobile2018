package com.example.hoyeonlee.example.ViewHolder.Admin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoyeonlee.example.R;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

/**
 * Created by hoyeonlee on 2018. 5. 26..
 */

public class ReservationHolder extends RecyclerView.ViewHolder {
    private Context context;
    private View view;
    public ImageView profileView;
    public TextView timeView;
    public TextView priceView;
    public TextView nameView;
    public ReservationHolder(Context context, View view){
        super(view);
        this.context = context;
        this.view = view;
        profileView = view.findViewById(R.id.iv_image);
        timeView = view.findViewById(R.id.tv_time);
        nameView = view.findViewById(R.id.tv_name);
        priceView = view.findViewById(R.id.tv_price);
    }


    public void setData(String imageUrl, String name ,String time, int price){
        String dateTime = DateTime.parse(time).toString("MM월 dd일 HH시 mm분 ss초");
        Picasso.get().load(imageUrl)
                .resize(100,100)
                .placeholder(R.drawable.placeholder)
                .centerCrop().into(profileView); // Image scaling typeinto(profileView// );
        timeView.setText(dateTime);
        String pr = String.format("%,d원", price);
        priceView.setText(pr);
        nameView.setText(name+"님");
    }

    public View getView() {
        return view;
    }
}
