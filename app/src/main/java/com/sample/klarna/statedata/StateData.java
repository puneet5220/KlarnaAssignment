package com.sample.klarna.statedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StateData<T> {

    @NonNull
    private DataStatus mStatus;

    @Nullable
    private T mData;

    @Nullable
    private Throwable mError;

    StateData() {
        this.mStatus = DataStatus.CREATED;
        this.mData = null;
        this.mError = null;
    }

    StateData<T> success(@NonNull final T data) {
        this.mStatus = DataStatus.SUCCESS;
        this.mData = data;
        this.mError = null;
        return this;
    }

    StateData<T> error(@NonNull final Throwable error) {
        this.mStatus = DataStatus.ERROR;
        this.mData = null;
        this.mError = error;
        return this;
    }

    @NonNull
    public DataStatus getStatus() {
        return mStatus;
    }

    @Nullable
    public T getData() {
        return mData;
    }

    @Nullable
    public Throwable getError() {
        return mError;
    }

    public enum DataStatus {
        CREATED,
        SUCCESS,
        ERROR
    }
}
