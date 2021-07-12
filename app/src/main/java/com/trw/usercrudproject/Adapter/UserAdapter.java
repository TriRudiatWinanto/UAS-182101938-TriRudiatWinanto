package com.trw.usercrudproject.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trw.usercrudproject.EditActivity;
import com.trw.usercrudproject.Model.User;
import com.trw.usercrudproject.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    List<User> mUsersList;

    public UserAdapter(List<User> usersList){
        mUsersList = usersList;

    }






    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  UserAdapter.MyViewHolder holder, int position) {
        holder.mTextViewId.setText("Id = "+mUsersList.get(position).getId());
        holder.mTextViewName.setText("Name" +mUsersList.get(position).getNama());
        holder.getmTextViewEmail.setText("Email "+mUsersList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id",mUsersList.get(position).getId());
                mIntent.putExtra("Name",mUsersList.get(position).getNama());
                mIntent.putExtra( "Email", mUsersList.get(position).getEmail());
                view.getContext().startActivity(mIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
       return mUsersList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewName, getmTextViewEmail;

        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewName = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewName = (TextView) itemView.findViewById(R.id.tvEmail);
        }

    }
}
