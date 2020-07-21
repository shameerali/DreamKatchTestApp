package com.example.dreamkatchtestapp.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    MutableLiveData<Boolean> isLoading= new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsLoading(){
        return isLoading;
    }

    public void setIsLoading(boolean isLoading){
        this.isLoading.postValue(isLoading);
    }
}
