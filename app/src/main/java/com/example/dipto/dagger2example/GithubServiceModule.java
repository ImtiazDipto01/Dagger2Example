package com.example.dipto.dagger2example;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dipto on 3/29/2018.
 */
@Module
public class GithubServiceModule {

    @Provides
    public GithubService githubservice(Retrofit githubRetrofit){
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
