package com.example.lab4_20203607.retrofithelpers;

import com.example.lab4_20203607.entity.Clima;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClimaService {


    @GET("geo/1.0/direct")
    Call<List<Clima>> getClima(@Query("q") String cityName, @Query("limit") int limit, @Query("appid") String apiKey);

}
