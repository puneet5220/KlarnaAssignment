package com.sample.klarna.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BaseViewModel extends ViewModel {
    private final CompositeDisposable mCompositeDisposable;

    @Inject
    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void addDisposable(@NonNull final Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
        super.onCleared();
    }

    /**
     * @param <S> Type of object that Single emits.
     * @return a Single that subscribed on IO and observes on Main schedulers.
     */
    <S> SingleTransformer<S, S> applySingleSchedulers() {
        return single -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
