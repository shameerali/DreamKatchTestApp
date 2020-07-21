package com.example.dreamkatchtestapp.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreamkatchtestapp.R;
import com.example.dreamkatchtestapp.base.BaseActivity;
import com.example.dreamkatchtestapp.model.VideoResponse;
import com.example.dreamkatchtestapp.ui.adapter.VideoListAdapter;
import com.example.dreamkatchtestapp.utils.VideoPlayerConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageActivity extends BaseActivity {

    @BindView(R.id.rvList)
    RecyclerView rvList;

    private VideoListAdapter videoListAdapter;

    private Observer<VideoResponse> videoResponseObserver;
    private HomeViewModel homeViewModel;

    public static Intent startActivity(Context context){
        return new Intent(context, HomePageActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        initViews();

        if (homeViewModel == null){
            homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
            homeViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean isLoading) {
                    if (isLoading) {
                        showProgress();
                    } else {
                        dismissProgress();
                    }
                }
            });

            videoResponseObserver = this::onSuccessVideoResponse;
        }


        homeViewModel.getVideosList("")
                .observe(this, videoResponseObserver);


    }

    private void initViews(){
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onSuccessVideoResponse(VideoResponse response){
        videoListAdapter = new VideoListAdapter( response.getResults(),getApplicationContext() );
        rvList.setAdapter(videoListAdapter);
    }



    @Override
    public int setLayout() {
        return R.layout.activity_home_page;
    }

    @Override
    public boolean setToolbar() {
        return false;
    }

    @Override
    public boolean hideStatusbar() {
        return false;
    }

    @Override
    public boolean setFullScreen() {
        return false;
    }
}