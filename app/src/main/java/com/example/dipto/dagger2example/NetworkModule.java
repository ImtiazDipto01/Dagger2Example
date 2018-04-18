package com.example.dipto.dagger2example;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Dipto on 3/29/2018.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public Cache cache(File cacheFile){
        return new Cache(cacheFile, 10 * 1000 * 1000) ;
    }

    @Provides
    @GithubApplicationScope
    public File cacheFile(@AplicationContextQualifiers Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @GithubApplicationScope
    public OkHttpClient okHttpClient(Cache cache){
        return  new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }
}
