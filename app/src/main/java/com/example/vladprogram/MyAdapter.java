package com.example.vladprogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private MyAdapter adapter;
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


//    public void updatePersonPremium(int person_id, int premium) {
//        PersonDataBase db = PersonDataBase.getDBinstance(context.getApplicationContext());
//        PersonDAO personDao = db.getPersonDAO();
//        int rowsUpdated = personDao.updatePersonPremium(person_id,premium);
//        List<Person> userList = db.getPersonDAO().getAllPerson();
//        adapter = new MyAdapter(context.getApplicationContext());
//        adapter.setUserList(userList);
//        adapter.notifyItemChanged(person_id);
//
//
//        adapter.notifyDataSetChanged();
//
//
////        if (rowsUpdated > 0) {
////            Toast.makeText(context.getApplicationContext(), "Данные успешно обновлены", Toast.LENGTH_SHORT).show();
////        } else {
////            Toast.makeText(context.getApplicationContext(), "Обновление не произошло", Toast.LENGTH_SHORT).show();
////        }
//
//    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_guest.setText(this.personList.get(position).name_guest);
        holder.item_time_hour.setText(String.valueOf(this.personList.get(position).time_hour));
        holder.item_time_min.setText(String.valueOf(this.personList.get(position).time_min));
        holder.number_guest.setText(String.valueOf(this.personList.get(position).number_people));

        holder.cal_1.setText(String.valueOf(this.personList.get(position).basic));
        holder.cal_2.setText(String.valueOf(this.personList.get(position).premium));
        holder.comments.setText(this.personList.get(position).comments);

        int id = (int) getItemId(position);


        holder.button_one_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition() +1;

                PersonDataBase db = PersonDataBase.getDBinstance(context.getApplicationContext());
                PersonDAO personDao = db.getPersonDAO();
                personDao.updatePersonPremium(id, 6);
                List<Person> userList = db.getPersonDAO().getAllPerson();

                adapter = new MyAdapter(context.getApplicationContext());

                adapter.setUserList(userList);
                adapter.notifyItemChanged(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(context.getApplicationContext(), "position: " + id + " " + position, Toast.LENGTH_SHORT).show();


//                Person person = personList.get(pos);
////
//                adapter.notifyDataSetChanged();
//                adapter.notifyItemChanged(pos);
            }
        });

//        holder.button_two_client.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
//        holder.button_one_client.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "2",Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.button_two_lite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "3",Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.button_one_lite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "4",Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.button_two_hard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "People",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.end.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "End",Toast.LENGTH_SHORT).show();
//            }
//        });
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



