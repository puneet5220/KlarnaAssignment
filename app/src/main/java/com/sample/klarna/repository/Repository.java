package com.sample.klarna.repository;

import com.sample.klarna.dto.WeatherResponse;
import com.sample.klarna.viewmodel.WeatherDataModel;

import io.reactivex.Single;

public interface Repository {

    Single<WeatherDataModel> getWeatherResponse();
}
