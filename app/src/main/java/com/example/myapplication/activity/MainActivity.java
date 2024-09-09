package com.example.myapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.RealmOperations;
import com.example.myapplication.RealmClasses.UsersRealm;

public class MainActivity extends AppCompatActivity {

        private AppCompatEditText edtUsername, edtPassword, edtMobileNumber, edtEmail;

        private AppCompatButton btnRegister, btnUserList, btnProductList;
        private Context context;
        private ProgressDialog progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            context =MainActivity.this;

            progressBar = new ProgressDialog(this);
            progressBar.setCancelable(false);//you can cancel it by pressing back button
            progressBar.setMessage("Please wait...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);


            edtUsername = findViewById(R.id.edt_username);
            edtPassword = findViewById(R.id.edt_password);
            edtMobileNumber = findViewById(R.id.edt_mobile_number);
            edtEmail = findViewById(R.id.edt_email);

            btnRegister = findViewById(R.id.btn_register);
            btnUserList = findViewById(R.id.btn_userlist);
            btnProductList = findViewById(R.id.btn_product_list);

            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtUsername.getText().toString().trim().isEmpty()) {
                        Toast.makeText(context, "Please enter Username", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (edtPassword.getText().toString().trim().isEmpty()) {
                        Toast.makeText(context, "Please enter Password", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (edtMobileNumber.getText().toString().trim().isEmpty()) {
                        Toast.makeText(context, "Please enter Mobile Number", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (edtEmail.getText().toString().trim().isEmpty()) {
                        Toast.makeText(context, "Please enter Email", Toast.LENGTH_LONG).show();
                        return;
                    }

                    insertUserDataIntoRealmDB();

                    //registerNewUser();


                }
            });

            btnUserList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, userRealmlist.class);
                    startActivity(intent);
                }
            });

            btnProductList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProductActivity.class);
                    startActivity(intent);
                }
            });

        }

        /*===============INSERT USER DATA INTO REALM DB================*/
        private void insertUserDataIntoRealmDB() {

            UsersRealm usersRealm = new UsersRealm(
                    edtUsername.getText().toString(),
                    edtMobileNumber.getText().toString(),
                    edtEmail.getText().toString());


            new RealmOperations().insertUserDetails(usersRealm);

            Toast.makeText(context, "Successfully Inserted", Toast.LENGTH_LONG).show();


            edtEmail.setText("");
            edtUsername.setText("");
            edtMobileNumber.setText("");
            edtPassword.setText("");


        }

}