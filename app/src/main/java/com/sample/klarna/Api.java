package com.sample.klarna;

import com.sample.klarna.dto.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("forecast/2bb07c3bece89caf533ac9a5d23d8417/59.337239,18.062381")
    Single<WeatherResponse> getWeatherResponse();
    
    
}
