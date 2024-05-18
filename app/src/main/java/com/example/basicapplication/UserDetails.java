package com.example.basicapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_details")
public class UserDetails {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "contact")
    private String contact;

    public UserDetails(@NonNull String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}

