package com.Virtusa.android.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.Virtusa.android.database.entity.User;
import com.Virtusa.android.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sjena on 25/11/18.
 */

public class UserProfileViewModel extends ViewModel {

    private LiveData<List<User>> user;
    private UserRepository userRepo;

    @Inject
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // ----

    public void init() {
        if (this.user != null) {
            return;
        }
        user = userRepo.getUser();
    }

    public LiveData<List<User> > getUser() {
        return this.user;
    }
}
