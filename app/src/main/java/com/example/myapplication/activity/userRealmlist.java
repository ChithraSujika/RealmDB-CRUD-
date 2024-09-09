package com.example.myapplication.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interfaces.UserDeleteInterface;
import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.RealmOperations;
import com.example.myapplication.RealmClasses.UsersRealm;

import java.util.List;

public class userRealmlist extends AppCompatActivity implements UserDeleteInterface {
    private Context context;
    private RecyclerView rvUserlist;
    private UserListRecyclerViewAdapter userListRecyclerViewAdapter;
    private List<UsersRealm> usersRealmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_in_recycler_view);
        context = userRealmlist.this;
        rvUserlist = findViewById(R.id.rv_userlist);
        rvUserlist.setLayoutManager(new LinearLayoutManager(this));
        usersRealmList = new RealmOperations().getUserList();
        userListRecyclerViewAdapter = new UserListRecyclerViewAdapter(context, usersRealmList,this);
        rvUserlist.setAdapter(userListRecyclerViewAdapter);
    }
    public void deleteUser(int position, String userUUID){
        new RealmOperations().deleteuserByUUID(userUUID);
        userListRecyclerViewAdapter.deleteUser(position);
    }
}
