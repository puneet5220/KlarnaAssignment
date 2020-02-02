package com.sample.klarna.repository;

import androidx.annotation.NonNull;

import com.sample.klarna.Api;
import com.sample.klarna.dto.WeatherResponse;
import com.sample.klarna.viewmodel.WeatherDataModel;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class RepositoryImplementation implements Repository {
    private Api mApi;

    @Inject
    public RepositoryImplementation(@NonNull final Api api) {
        mApi = api;
    }

    @Override
    public Single<WeatherDataModel> getWeatherResponse() {
        return mApi.getWeatherResponse()
                .flatMap(new Function<WeatherResponse, SingleSource<WeatherDataModel>>() {
                    @Override
                    public SingleSource<WeatherDataModel> apply(WeatherResponse weatherResponse)
                            throws Exception {
                        final WeatherDataModel weatherDataModel =
                                WeatherDataModel.fromWeatherResponse(weatherResponse);
                        return Single.just(weatherDataModel);
                    }
                });
    }
}
