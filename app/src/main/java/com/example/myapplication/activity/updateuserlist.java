package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.RealmOperations;
import com.example.myapplication.RealmClasses.UsersRealm;


public class updateuserlist extends AppCompatActivity  {
    private AppCompatEditText edtempname,edtmoblienumber,edtemail;
    String name,phone,mail;
    private AppCompatButton edtupdate;
    private String uuId;
    Context context;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_update);
        context=updateuserlist.this;
        edtempname=findViewById(R.id.edt_username);
        edtmoblienumber=findViewById(R.id.edt_mobile_number);
        edtemail=findViewById(R.id.edt_email);
        edtupdate=findViewById(R.id.btn_update);

        uuId=getIntent().getStringExtra("user_UUId");
        name=getIntent().getStringExtra("username");
        phone=getIntent().getStringExtra("usermobile");
        mail=getIntent().getStringExtra("useremail");

        edtempname.setText(name);
        edtmoblienumber.setText(phone);
        edtemail.setText(mail);



        /*String ename=edtempname.getText().toString();
        String ephone=edtmoblienumber.getText().toString();
        String eemail=edtemail.getText().toString();*/

        edtupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersRealm usersRealm=new UsersRealm(edtempname.getText().toString(),
                        edtmoblienumber.getText().toString(),
                        edtemail.getText().toString());
                new RealmOperations().updatedetails(usersRealm,uuId);
                Toast.makeText(context,"Suessfully Updated",Toast.LENGTH_LONG).show();
                Intent i=new Intent(context,userRealmlist.class);
                startActivity(i);
            }

        });
        }



}
