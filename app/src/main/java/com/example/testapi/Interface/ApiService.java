package com.example.testapi.Interface;

import com.example.testapi.model.Account;
import com.example.testapi.model.ModelGet;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

   @Headers({"Content-Type: application/json"})
    @POST("api/Authentication/RequestMoblieCabinetApiToken")
    Call<ResponseBody> createAccount(@Body Account account);

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("clientmobile/GetAnalyticSignals/20234561?tradingsystem=3&pairs=GBPJPY,EURJPY&from=1479860023&to=1480066860")
    Call<List<ModelGet>>  getSecret(@Header("passkey") String autchToken);
}
