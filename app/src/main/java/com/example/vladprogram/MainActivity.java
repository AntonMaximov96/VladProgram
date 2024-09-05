package com.example.vladprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText time_hour;
    EditText time_min;
    EditText name_guest;
    EditText number_people;
    EditText basic;
    EditText premium;
    EditText comments;
    Button begin;
    Button constants;
    Button next_activity;
    PersonDataBase personDB;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_hour = findViewById(R.id.text_time_one);
        time_min = findViewById(R.id.text_time_two);
        name_guest = findViewById(R.id.name_guest);
        number_people = findViewById(R.id.number_of_guests);
        basic = findViewById(R.id.basic);
        premium = findViewById(R.id.premium);
        comments = findViewById(R.id.comments);
        next_activity = findViewById(R.id.next_activity);

        begin = findViewById(R.id.begin);
        constants = findViewById(R.id.constants);

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };


        personDB = PersonDataBase.getDBinstance(this.getApplicationContext());


        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = time_hour.getText().toString();
                String min = time_min.getText().toString();
                String name = name_guest.getText().toString();
                String people = number_people.getText().toString();
                String bas = basic.getText().toString();
                String prem = premium.getText().toString();
                String comment = comments.getText().toString();
                Person p1 = new Person(hour, min, name, people, bas, prem, comment);

                addPersonInBackground(p1);

                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);

            }
        });

        constants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPersonListInBackground();
            }
        });

        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_activity();
            }
        });

    }

    public void addPersonInBackground(Person person) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // background task
                personDB.getPersonDAO().addPerson(person);

                // on finishing background task
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Added to Database ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void getPersonListInBackground() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                personList = personDB.getPersonDAO().getAllPerson();


                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        StringBuilder sb = new StringBuilder();
                        for (Person p : personList) {
                            sb.append(p.getName_guest()).append(" : ").append(p.getNumber_people());
                            sb.append("\n");
                        }
                        String finalData = sb.toString();
                        Toast.makeText(MainActivity.this, " - " + finalData, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    public void next_activity(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);


            }
        });

    }

}