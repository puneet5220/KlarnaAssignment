package com.sample.klarna.viewmodel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.sample.klarna.repository.Repository;
import com.sample.klarna.statedata.StateData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherViewModelTest {

    @Rule
    public TestRule mRule = new InstantTaskExecutorRule();
    @Mock
    Repository mRepository;
    @Mock
    private WeatherDataModel mWeatherDataModel;
    @Mock
    private ConnectivityManager mConnectivityManager;
    @Mock
    private NetworkInfo mNetworkInfo;
    @Mock
    private Context mContext;
    @Mock
    private Throwable mThrowable;
    private WeatherViewModel mWeatherViewModel;

    @Before
    public void init() {
        mWeatherViewModel = new WeatherViewModel(mRepository);
        when(mContext.getSystemService(Context.CONNECTIVITY_SERVICE))
                .thenReturn(mConnectivityManager);
        when(mConnectivityManager.getActiveNetworkInfo())
                .thenReturn(mNetworkInfo);
    }

    @Test
    public void getWeatherResponse_whenSuccess_returnPostSuccess() {
        when(mNetworkInfo.isConnected()).thenReturn(true);
        when(mRepository.getWeatherResponse())
                .thenReturn(Single.just(mWeatherDataModel));
        mWeatherViewModel.getWeatherResponse(mContext);

        final StateData<WeatherDataModel> stateData = mWeatherViewModel.
                getObservable().getValue();
        Assert.assertNotNull(stateData);
    }

    @Test
    public void getWeatherResponse_whenError_returnError() {
        when(mNetworkInfo.isConnected()).thenReturn(true);
        when(mRepository.getWeatherResponse()).thenReturn(Single.error(mThrowable));
        mWeatherViewModel.getWeatherResponse(mContext);

        final StateData<WeatherDataModel> stateData = mWeatherViewModel.
                getObservable().getValue();
        Assert.assertNull(stateData.getData());
    }

    @BeforeClass
    public static void before() {
        RxJavaPlugins.setIoSchedulerHandler(scheduler
                -> Schedulers.trampoline());
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable
                -> Schedulers.trampoline());
    }
}
