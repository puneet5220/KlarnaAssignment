package com.sample.klarna.datainjection;

import com.sample.klarna.fragment.WeatherDetailsFragment;
import com.sample.klarna.fragment.SplashFragment;

import dagger.Component;

@Component(modules = {
        ViewModelModule.class,
        NetworkModule.class
})
@AppScope
public interface AppComponent {

    void inject(WeatherDetailsFragment fragment);

    void inject(SplashFragment fragment);

    @Component.Builder
    interface Builder {

        AppComponent build();
    }
}
