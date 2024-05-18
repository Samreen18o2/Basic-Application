package com.example.basicapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDetailsDao {

    @Insert
    void insert(UserDetails userDetails);

    @Update
    void update(UserDetails userDetails);

    @Delete
    void delete(UserDetails userDetails);

    @Query("SELECT * FROM user_details")
    List<UserDetails> getAllUserDetails();
}

