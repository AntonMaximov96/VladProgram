package com.example.vladprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoActivity extends AppCompatActivity {
    PersonDataBase personDB;
    RecyclerView recyclerView;
    MyAdapter adapter;
    Person person;
    LinearLayoutManager layoutManager;
    List<Person> personList;
    ImageButton add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        add_button = findViewById(R.id.add_button);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MySwipeHelper swipeHelper = new MySwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(TwoActivity.this,
                        "Delete",
                        30,
                        R.drawable.delete_svg,
                        Color.parseColor("#FF3C30"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                int s = (int) adapter.getItemId(pos);
                                Toast.makeText(TwoActivity.this, "Delete click - " + s, Toast.LENGTH_SHORT).show();
                                deleteObjectById(s);

                            }
                        }
                ));

                buffer.add(new MyButton(TwoActivity.this,
                        "Update",
                        30,
                        R.drawable.update_svg,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {

                                Toast.makeText(TwoActivity.this, "Update click", Toast.LENGTH_SHORT).show();
                            }
                        }
                ));
            }
        };
//------------------------ SWIPE END ------------------------

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_button();
            }
        });


        initRecyclerView();
        getAllCategoryList();

    }


    public void deleteObjectById(int id) {
        PersonDataBase db = PersonDataBase.getDBinstance(this.getApplicationContext());
        try {
            // Удаление объекта по идентификатору
            db.getPersonDAO().deletePerson(id);

            // Обновление пользовательского интерфейса

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрытие соединения с базой данных
            if (db != null && !db.isOpen()) {
                db.close();
            }
        }
    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void getAllCategoryList() {
        PersonDataBase db = PersonDataBase.getDBinstance(this.getApplicationContext());
        List<Person> userList = db.getPersonDAO().getAllPerson();
        adapter.setUserList(userList);
    }

    public void add_button() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            getAllCategoryList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}