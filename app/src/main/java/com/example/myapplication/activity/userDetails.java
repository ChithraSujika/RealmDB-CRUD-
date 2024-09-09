package com.example.myapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.RealmOperations;
import com.example.myapplication.RealmClasses.UsersRealm;


public class userDetails extends AppCompatActivity {

   private TextView name,phone,email;
   private String uuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_user_list);
        this.name=(TextView) findViewById(R.id.name);
        this.phone=(TextView) findViewById(R.id.mobile);
        this.email=(TextView) findViewById(R.id.mailid);
        uuId=getIntent().getStringExtra("user_UUId");

        UsersRealm usersRealm = new RealmOperations().getUserDetailsByUUID(uuId);
        if(usersRealm != null) {
            name.setText(usersRealm.getUserName());
            phone.setText(usersRealm.getUserMobileNumber());
            email.setText(usersRealm.getUserEmailId());
        }


    }
}
