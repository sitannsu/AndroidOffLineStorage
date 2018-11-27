package com.Virtusa.android.repositories;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;


import com.Virtusa.android.App;
import com.Virtusa.android.api.UserWebservice;
import com.Virtusa.android.database.dao.UserDao;
import com.Virtusa.android.database.entity.User;
import com.Virtusa.android.database.entity.UserList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sjena on 25/11/18.
 */

@Singleton
public class UserRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 1;

    private final UserWebservice webservice;
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepository(UserWebservice webservice, UserDao userDao, Executor executor) {
        this.webservice = webservice;
        this.userDao = userDao;
        this.executor = executor;
    }

    // ---

    public LiveData<List<User> > getUser() {
        refreshUser(); // try to refresh data if possible from  Api
        return userDao.load(); // return a LiveData directly from the database.
    }

    // ---

    private void refreshUser( ) {
        executor.execute(() -> {
            // Check if user was fetched recently
            boolean userExists = (userDao.hasUser()) != null;
            // If user have to be updated
            //if (!userExists) {
                webservice.getUser().enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        Log.e("TAG", "DATA REFRESHED FROM NETWORK");
                        Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            List<User> userList = response.body();

                            userDao.save(userList);
                        });
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Log.e("TAG", "DATA REFRESHED FROM NETWORK  FAILED");

                    }
                });
            //}
        });
    }

    // ---


}
