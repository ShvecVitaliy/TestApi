package com.example.testapi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.testapi.Interface.ApiService;
import com.example.testapi.R;
import com.example.testapi.model.Account;
import com.example.testapi.retrofitclien.Client;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquiryActivity extends AppCompatActivity {

    private EditText txt_login, txt_password;
    private Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inqiiry);

        txt_login = findViewById(R.id.login);
        txt_password = findViewById(R.id.password);
        btn_confirm = findViewById(R.id.buttonInquiry);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = txt_login.getText().toString();
                String password = txt_password.getText().toString();
                createAccount(login, password);
            }
        });
    }
    private static String token;

    ApiService api = Client.getRetrofit().create(ApiService.class);

    private void createAccount(String login, String password) {
       Account account = new Account(login, password);
        Call<ResponseBody> call = api.createAccount(account);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String myString = response.body().toString();
                if (response.isSuccessful()) {
                    try {
                        token = response.body().string();

                        if(token!=null) {
                            token =token.replace("\"", "");
                            Toast.makeText(InquiryActivity.this, token, Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(InquiryActivity.this, AnswerActivity.class);
                            intent.putExtra("message", token);
                            startActivity(intent);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(InquiryActivity.this, "login not correct :(", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(InquiryActivity.this, "error:(", Toast.LENGTH_SHORT).show();
                Log.v("Project", String.valueOf(t));
            }
        });


    }
}
