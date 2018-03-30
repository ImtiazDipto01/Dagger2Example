package com.example.dipto.dagger2example;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dipto on 3/30/2018.
 */

@Module
public class ContextModule {

    private final Context context ;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context(){
        return context ;
    }
}
