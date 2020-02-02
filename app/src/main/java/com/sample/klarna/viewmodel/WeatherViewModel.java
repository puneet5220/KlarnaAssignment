package com.sample.klarna.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;

import com.sample.klarna.R;
import com.sample.klarna.repository.Repository;
import com.sample.klarna.statedata.StateLiveData;
import com.sample.klarna.utils.NetworkUtils;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class WeatherViewModel extends BaseViewModel {
    private final StateLiveData<WeatherDataModel> mStateData;
    private final Repository mRepository;

    @Inject
    public WeatherViewModel(Repository repository) {
        super();
        mRepository = repository;
        mStateData = new StateLiveData<>();
    }

    /**
     * Post Details after Fetching
     */
    public void getWeatherResponse(@NonNull final Context context) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            addDisposable(mRepository.getWeatherResponse()
                    .compose(applySingleSchedulers())
                    .subscribe(mStateData::postSuccess,
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable error) throws Exception {
                                    mStateData.postError(error);
                                }
                            }));
        } else {
            // Should have a Generic Error Handler.
            mStateData.postError
                    (new Throwable
                            (context.getString(R.string.offline)));
        }
    }

    /**
     * Return StateLiveData data object
     *
     * @return StateLiveData
     */
    @NonNull
    public StateLiveData<WeatherDataModel> getObservable() {
        return mStateData;
    }
}