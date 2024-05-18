package com.example.basicapplication;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserDetails.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDetailsDao userDetailsDao();
}

