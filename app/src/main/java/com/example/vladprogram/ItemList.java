package com.example.vladprogram;

public class ItemList {

    int item_time_hour, item_time_min, number_guest, cal_1, cal_2;
    String name_guest, comments;


    public ItemList(int item_time_hour, int item_time_min, String name_guest, int number_guest, int cal_1, int cal_2, String comments) {
        this.item_time_hour = item_time_hour;
        this.item_time_min = item_time_min;
        this.name_guest = name_guest;
        this.number_guest = number_guest;
        this.cal_1 = cal_1;
        this.cal_2 = cal_2;
        this.comments = comments;
    }

    public int getItem_time_hour() {
        return item_time_hour;
    }

    public void setItem_time_hour(int item_time_hour) {
        this.item_time_hour = item_time_hour;
    }

    public int getItem_time_min() {
        return item_time_min;
    }

    public void setItem_time_min(int item_time_min) {
        this.item_time_min = item_time_min;
    }

    public int getNumber_guest() {
        return number_guest;
    }

    public void setNumber_guest(int number_guest) {
        this.number_guest = number_guest;
    }

    public int getCal_1() {
        return cal_1;
    }

    public void setCal_1(int cal_1) {
        this.cal_1 = cal_1;
    }

    public int getCal_2() {
        return cal_2;
    }

    public void setCal_2(int cal_2) {
        this.cal_2 = cal_2;
    }

    public String getName_guest() {
        return name_guest;
    }

    public void setName_guest(String name_guest) {
        this.name_guest = name_guest;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
