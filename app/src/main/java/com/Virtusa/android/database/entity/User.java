package com.Virtusa.android.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by sjena on 25/11/18.
 */


@Entity
public class User {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private int id;



    @SerializedName("userId")
    @Expose
    private int userId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("title")
    @Expose
    private String title;



    // --- CONSTRUCTORS ---

    public User() { }

    public User(@NonNull int id, int userId, String title ) {
        this.id = id;
        this.userId = userId;
        this.title = title;

    }

    // --- GETTER ---

    public int getId() { return id; }
    public int getUserId() { return userId; }

    public String gettittle() { return title; }


    // --- SETTER ---

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setUserId(String title) { this.title = title; }

}
