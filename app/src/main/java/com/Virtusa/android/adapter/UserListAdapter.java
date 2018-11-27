package com.Virtusa.android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Virtusa.android.R;
import com.Virtusa.android.database.entity.User;

import java.util.List;

/**
 * Created by sjena on 25/11/18.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<User> userList;

    public UserListAdapter(Context context, List<User> userList)
    {
        this.context = context;
        this.userList = userList;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if  (holder instanceof UserHolder) {

            final UserHolder itemHolder = (UserHolder) holder;
            itemHolder.userName.setText(userList.get(position).getTitle());


        }


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void notifyDataSetChange(List<User> userList)
    {
        this.userList = userList;
        notifyDataSetChanged();

    }

    public class UserHolder extends RecyclerView.ViewHolder {



        private TextView userName;





        public UserHolder(View itemView) {
            super(itemView);

            userName = (TextView) itemView.findViewById(R.id.userName);




        }
    }

}
