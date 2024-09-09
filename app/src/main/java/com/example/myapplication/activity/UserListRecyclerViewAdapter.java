package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Interfaces.UserDeleteInterface;
import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.UsersRealm;

import java.util.List;

public class UserListRecyclerViewAdapter extends RecyclerView.Adapter<UserListRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<UsersRealm> usersRealmList;
    private UserDeleteInterface userdelete;


    public UserListRecyclerViewAdapter(Context context, List<UsersRealm> usersRealmList, UserDeleteInterface userdelete)
                                       {
        this.context = context;
        this.usersRealmList = usersRealmList;
        this.userdelete=userdelete;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_user_details, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final UsersRealm userRealm = usersRealmList.get(holder.getAdapterPosition());
        holder.txtUsername.setText(userRealm.getUserName());
        holder.txtMobileNumber.setText(userRealm.getUserMobileNumber());
        holder.txtEmailId.setText(userRealm.getUserEmailId());

        holder.lnrUserDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, userDetails.class);
                intent.putExtra("user_UUId", userRealm.getUserUUID());
                context.startActivity(intent);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userdelete.deleteUser(holder.getAdapterPosition(), userRealm.getUserUUID());
            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,updateuserlist.class);
                intent.putExtra("user_UUId", userRealm.getUserUUID());
                intent.putExtra("username" ,userRealm.getUserName());
                intent.putExtra("usermobile", userRealm.getUserMobileNumber());
                intent.putExtra("useremail", userRealm.getUserEmailId());
                context.startActivity(intent);
            }
        });


    }

    public void deleteUser(int position){
        usersRealmList.remove(position);
        notifyItemRemoved(position);
    }





    @Override
    public int getItemCount() {
        return usersRealmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtUsername, txtMobileNumber, txtEmailId;
        public LinearLayoutCompat lnrUserDetails;
        public AppCompatButton btnDelete;
        public AppCompatButton btnUpdate;



        public ViewHolder(View itemView) {
            super(itemView);
            lnrUserDetails=(LinearLayoutCompat) itemView.findViewById(R.id.lenearlayout);
            this.txtUsername = (TextView) itemView.findViewById(R.id.txt_username);
            this.txtMobileNumber = (TextView) itemView.findViewById(R.id.txt_mobile_number);
            this.txtEmailId = (TextView) itemView.findViewById(R.id.txt_email_id);
            btnDelete=(AppCompatButton) itemView.findViewById(R.id.userdelete);
            btnUpdate=(AppCompatButton) itemView.findViewById(R.id.userupdate);

        }
    }
}
