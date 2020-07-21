package com.example.dreamkatchtestapp.ui.home;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.dreamkatchtestapp.api.ApiClient;
import com.example.dreamkatchtestapp.base.BaseViewModel;
import com.example.dreamkatchtestapp.model.VideoResponse;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;


import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class HomeViewModel extends BaseViewModel {
    private MutableLiveData<VideoResponse> videoResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<VideoResponse> getVideosList(String pageNo) {
        ApiClient.getApiInterface().getVideosList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<VideoResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        setIsLoading(true);
                    }

                    @Override
                    public void onSuccess(VideoResponse videoResponse) {
                        setIsLoading(false);
                        videoResponseMutableLiveData.postValue(videoResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setIsLoading(false);
                    }
                });
        return videoResponseMutableLiveData;
    }

}
