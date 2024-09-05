package com.example.vladprogram;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView item_time_hour,item_time_min,name_guest,number_guest,cal_1,cal_2,comments;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name_guest = itemView.findViewById(R.id.name_guest_item);
        item_time_hour = itemView.findViewById(R.id.text_time_hour);
        item_time_min = itemView.findViewById(R.id.text_time_min);
        number_guest = itemView.findViewById(R.id.text_num_people);
        cal_1 = itemView.findViewById(R.id.cal_num_lite);
        cal_2 = itemView.findViewById(R.id.cal_num_hard);
        comments = itemView.findViewById(R.id.commentsActivityTwo);


    }
}
