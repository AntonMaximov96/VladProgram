package com.example.vladprogram;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Person")
public class Person implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    int id = 0;
    @ColumnInfo(name = "time_hour")
    String time_hour = "";
    @ColumnInfo(name = "time_min")
    String time_min = "";
    @ColumnInfo(name = "name_guest")
    String name_guest = "";
    @ColumnInfo(name = "number_people")
    String number_people = "";
    @ColumnInfo(name = "basic")
    String basic = "";
    @ColumnInfo(name = "premium")
    String premium = "";
    @ColumnInfo(name = "comments")
    String comments = "";
    @Ignore
    public Person(){
    }

    public Person(String time_hour, String time_min, String name_guest, String number_people, String basic, String premium, String comments) {
        this.id = 0;
        this.time_hour = time_hour;
        this.time_min = time_min;
        this.name_guest = name_guest;
        this.number_people = number_people;
        this.basic = basic;
        this.premium = premium;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime_hour() {
        return time_hour;
    }

    public void setTime_hour(String time_hour) {
        this.time_hour = time_hour;
    }

    public String getTime_min() {
        return time_min;
    }

    public void setTime_min(String time_min) {
        this.time_min = time_min;
    }

    public String getName_guest() {
        return name_guest;
    }

    public void setName_guest(String name_guest) {
        this.name_guest = name_guest;
    }

    public String getNumber_people() {
        return number_people;
    }

    public void setNumber_people(String number_people) {
        this.number_people = number_people;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
