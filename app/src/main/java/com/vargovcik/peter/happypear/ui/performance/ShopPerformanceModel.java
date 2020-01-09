package com.vargovcik.peter.happypear.ui.performance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShopPerformanceModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShopPerformanceModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}