package com.sample.klarna.statedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class StateLiveData<T> extends MutableLiveData<StateData<T>> {

    /**
     * set Data on a ERROR DataStatus
     *
     * @param error the error to be handled
     */
    public void postError(@NonNull final Throwable error) {
        postValue(new StateData<T>().error(error));
    }

    /**
     * set Data on a SUCCESS DataStatus
     *
     * @param data data to be set
     */
    public void postSuccess(final @NonNull T data) {
        postValue(new StateData<T>().success(data));
    }
}

