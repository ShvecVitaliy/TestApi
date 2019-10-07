package com.example.testapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testapi.Interface.ApiService;
import com.example.testapi.R;
import com.example.testapi.model.ModelGet;
import com.example.testapi.retrofitclien.Client;
import com.example.testapi.retrofitclien.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerActivity extends AppCompatActivity {
    private static String token;
    private LinearLayoutManager layoutManager;
    private List<ModelGet> userList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("message");
        Log.i("autolog", "onCreate");
        getSecret();

    }
    ApiService api = Client.getRetrofit().create(ApiService.class);
    private void getSecret() {
        Call<List<ModelGet>> call = api.getSecret(token);
        call.enqueue(new Callback<List<ModelGet>>() {
            @Override
            public void onResponse(Call<List<ModelGet>> call, Response<List<ModelGet>> response) {

                userList = response.body();
                Log.i("autolog", "List<User> userList = response.body();");

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                Log.i("autolog", "RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);");

                layoutManager = new LinearLayoutManager(AnswerActivity.this);
                Log.i("autolog", "layoutManager = new LinearLayoutManager(MainActivity.this);");
                recyclerView.setLayoutManager(layoutManager);
                Log.i("autolog", "recyclerView.setLayoutManager(layoutManager);");

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), userList);
                Log.i("autolog", "RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(getApplicationContext(), userList);");
                recyclerView.setAdapter(recyclerViewAdapter);
                Log.i("autolog", "recyclerView.setAdapter(recyclerViewAdapter);");
            }
            @Override
            public void onFailure(Call<List<ModelGet>> call, Throwable t) {
                Toast.makeText(AnswerActivity.this, "error:(", Toast.LENGTH_SHORT).show();
                Log.v("Project", String.valueOf(t));
            }
        });
    }
}
