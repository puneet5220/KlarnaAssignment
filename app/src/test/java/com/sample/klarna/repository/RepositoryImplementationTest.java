package com.sample.klarna.repository;

import com.sample.klarna.Api;
import com.sample.klarna.dto.Currently;
import com.sample.klarna.dto.Daily;
import com.sample.klarna.dto.Hourly;
import com.sample.klarna.dto.WeatherResponse;
import com.sample.klarna.viewmodel.WeatherDataModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryImplementationTest {
    private static final String SUMMARY = "SUMMARY";
    private static final String TIMEZONE = "TIMEZONE";

    @Mock
    private Api mApi;
    @Mock
    private WeatherResponse mWeatherResponse;
    @Mock
    private Currently mCurrentData;
    @Mock
    private Hourly mHourlyData;
    @Mock
    private Daily mDailyData;
    @Mock
    private WeatherDataModel mWeatherDataModel;
    @Mock
    private Throwable mThrowable;
    private Repository mRepository;

    @Before
    public void setUp() {
        mRepository = new RepositoryImplementation(mApi);
    }

    @Test
    public void getWeatherResponse_whenSuccess_returnSuccess() {
        mockResponse();

        when(mApi.getWeatherResponse()).
                thenReturn(Single.just(mWeatherResponse));

        final TestObserver<WeatherDataModel> test =
                mRepository.getWeatherResponse().test();
        test.assertComplete();
    }

    @Test
    public void getWeatherResponse_whenFailure_returnError() {
        when(mApi.getWeatherResponse()).
                thenReturn(Single.error(mThrowable));

        final TestObserver<WeatherDataModel> test =
                mRepository.getWeatherResponse().test();
        test.assertError(mThrowable);
    }

    private void mockResponse() {
        when(mCurrentData.getSummary()).thenReturn(SUMMARY);
        when(mHourlyData.getSummary()).thenReturn(SUMMARY);
        when(mDailyData.getSummary()).thenReturn(SUMMARY);

        when(mWeatherResponse.getCurrently()).thenReturn(mCurrentData);
        when(mWeatherResponse.getHourly()).thenReturn(mHourlyData);
        when(mWeatherResponse.getTimezone()).thenReturn(TIMEZONE);
        when(mWeatherResponse.getDaily()).thenReturn(mDailyData);
    }
}
