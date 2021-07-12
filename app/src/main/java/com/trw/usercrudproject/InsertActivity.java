package com.trw.usercrudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trw.usercrudproject.Model.PostPutDelUser;
import com.trw.usercrudproject.rest.ApiClient;
import com.trw.usercrudproject.rest.Apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText editName,editEmail;
    Button btnInsert,btnBack;
    Apiinterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editName =(EditText)findViewById(R.id.editNama);
        editEmail =(EditText)findViewById(R.id.editEmail);
        mApiInterface = ApiClient.getClient().create(Apiinterface.class);
        btnInsert=(Button)findViewById(R.id.BtnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> postUserCall = mApiInterface.postUser(editName.getText().toString(),editEmail.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        btnBack = (Button)findViewById(R.id.BtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}