package com.example.vladprogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final Context context;
    private List<Person> personList;

    public MyAdapter(Context context) {
        this.context = context;

    }

    public void setUserList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_guest.setText(this.personList.get(position).name_guest);
        holder.item_time_hour.setText(String.valueOf(this.personList.get(position).time_hour));
        holder.item_time_min.setText(String.valueOf(this.personList.get(position).time_min));
        holder.number_guest.setText(String.valueOf(this.personList.get(position).number_people));

        holder.cal_1.setText(String.valueOf(this.personList.get(position).basic));
        holder.cal_2.setText(String.valueOf(this.personList.get(position).premium));
        holder.comments.setText(this.personList.get(position).comments);


    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    @Override
    public long getItemId(int position) {
        return personList.get(position).getId();
    }


    public void removeItem(int position) {
        personList.remove(position);
        notifyItemRemoved(position);
    }


}
