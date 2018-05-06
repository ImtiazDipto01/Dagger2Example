package com.example.dipto.dagger2example.main;

import com.example.dipto.dagger2example.MainActivity;
import com.example.dipto.dagger2example.RecylerAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    
    private final MainActivity mainActivity ;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity ;
    }

    @Provides
    public RecylerAdapter recylerAdapter(Picasso picasso){
        return new RecylerAdapter(mainActivity, picasso);
    }
}
