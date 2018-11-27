package com.Virtusa.android.fragmets;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Virtusa.android.R;
import com.Virtusa.android.adapter.UserListAdapter;
import com.Virtusa.android.database.entity.User;
import com.Virtusa.android.view_models.UserProfileViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by sjena on 20/11/18.
 */

public class DataFragment extends Fragment {

    @BindView(R.id.datarEcycler)
    RecyclerView datarEcycler;



    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private UserProfileViewModel viewModel;
    List<User> userList = new ArrayList<>();
    UserListAdapter userListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inItRecycler();
        this.configureDagger();
        this.configureViewModel();
    }

    private void inItRecycler() {

        datarEcycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        userListAdapter = new UserListAdapter(getActivity(), userList);
        datarEcycler.setAdapter(userListAdapter);
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserProfileViewModel.class);
        viewModel.init();
        viewModel.getUser().observe(this, user -> updateUI(user));
    }


    private void updateUI(@Nullable List<User> user){

        Log.d("useruser",""+user);
        userListAdapter.notifyDataSetChange(user);


    }
}
