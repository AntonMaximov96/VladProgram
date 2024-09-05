package com.example.vladprogram;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PersonDAO {

    @Insert
    void addPerson(Person person);
    @Update
    void updatePerson(Person person);
    @Delete
    void deletePerson(Person person);

    @Query("select * from person")
    public List<Person>getAllPerson();

    @Query("select * from person where person_id ==:person_id")
    public Person getPerson(int person_id);

    @Query("delete from person where person_id =:person_id")
    public void deletePerson(int person_id);


}
