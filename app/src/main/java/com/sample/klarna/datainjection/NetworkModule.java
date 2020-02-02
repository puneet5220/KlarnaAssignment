package com.sample.klarna.datainjection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.klarna.Api;
import com.sample.klarna.repository.Repository;
import com.sample.klarna.repository.RepositoryImplementation;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * This is a module with all the dependencies needed for network connections
 */
@Module
class NetworkModule {

    private static final String BASE_URL = "https://api.darksky.net/";

    @Provides
    @AppScope
    ObjectMapper getConfigMapper() {
        return new ObjectMapper();
    }

    @Provides
    @AppScope
    Api getRetrofitApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    @AppScope
    Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @AppScope
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @AppScope
    Repository getRepository(Api api) {
        return new RepositoryImplementation(api);
    }
}
