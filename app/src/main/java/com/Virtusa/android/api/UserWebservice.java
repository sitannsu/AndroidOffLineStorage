package com.Virtusa.android.api;

import com.Virtusa.android.database.entity.User;
import com.Virtusa.android.database.entity.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sjena on 20/11/18.
 */

public interface UserWebservice {

    @GET("/albums")
    Call<List<User>> getUser();
}
