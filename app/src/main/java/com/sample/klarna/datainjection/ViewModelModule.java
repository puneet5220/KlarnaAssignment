package com.sample.klarna.datainjection;

import androidx.lifecycle.ViewModel;

import com.sample.klarna.repository.Repository;
import com.sample.klarna.viewmodel.CustomViewModelFactory;
import com.sample.klarna.viewmodel.WeatherViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * This is a module with all the dependencies needed for the injections of ViewModel.
 */
@Module
class ViewModelModule {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @Provides
    @IntoMap
    @AppScope
    @ViewModelKey(WeatherViewModel.class)
    ViewModel weatherViewModel(Repository repository) {
        return new WeatherViewModel(repository);
    }

    @Provides
    @AppScope
    CustomViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>,
            Provider<ViewModel>> providerMap) {
        return new CustomViewModelFactory(providerMap);
    }
}
