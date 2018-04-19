package com.example.dipto.dagger2example;

import com.example.dipto.dagger2example.model.ResponseRoot;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dipto on 3/29/2018.
 */

public interface GithubService {

    @GET("retrofitpractice.php")
    Call<ResponseRoot> getDetailList();
}
