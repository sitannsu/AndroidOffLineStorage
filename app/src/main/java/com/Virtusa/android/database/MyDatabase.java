package com.Virtusa.android.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.Virtusa.android.database.converter.DateConverter;
import com.Virtusa.android.database.dao.UserDao;
import com.Virtusa.android.database.entity.User;


/**
 * Created by sjena on 25/11/18.
 */

@Database(entities = {User.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    // --- DAO ---
    public abstract UserDao userDao();
}
