package com.Virtusa.android.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.Virtusa.android.database.entity.User;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by sjena on 25/11/18.
 */

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void save(List<User> user);

    @Query("SELECT * FROM user")
    LiveData<List<User> > load();

    @Query("SELECT * FROM user" )
    List<User>  hasUser( );
}