package com.example.dipto.dagger2example.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dipto.dagger2example.GithubApplication;
import com.example.dipto.dagger2example.GithubService;
import com.example.dipto.dagger2example.R;
import com.example.dipto.dagger2example.RecylerAdapter;
import com.example.dipto.dagger2example.model.ResponseRoot;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recylerview)
    RecyclerView recylerview;

    GithubService githubService ;
    Picasso picasso ;
    Call<ResponseRoot> call ;
    RecylerAdapter recylerAdapter ;
    private LinearLayoutManager layoutManager;
    MainActivityComponent component ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        githubService = GithubApplication.get(this).getGithubService() ;
        picasso = GithubApplication.get(this).getPicasso() ;

        component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).component())
                .build() ;

    }

    private void setNotificationRecylerView() {
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recylerAdapter = component.recylerAdapter() ;
        recylerview.setLayoutManager(layoutManager);
        //notificationAdapter.setClicklistner(this);
        recylerview.setAdapter(recylerAdapter);
    }
}
