package com.example.dipto.dagger2example.main;

import com.example.dipto.dagger2example.GithubApplicationComponent;

import dagger.Component;
import dagger.Module;

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);
}
