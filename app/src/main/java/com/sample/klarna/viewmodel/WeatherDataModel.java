package com.sample.klarna.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.sample.klarna.dto.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataModel implements Parcelable {

    @NonNull
    private String mTimeZone;
    @NonNull
    private String mCurrentSummary;
    @NonNull
    private String mHourlySummary;
    @NonNull
    private String mDailySummary;

    public WeatherDataModel(@NonNull final String timeZone,
                            @NonNull final String currentSummary,
                            @NonNull final String hourlySummary,
                            @NonNull final String dailySummary) {
        mTimeZone = timeZone;
        mCurrentSummary = currentSummary;
        mHourlySummary = hourlySummary;
        mDailySummary = dailySummary;
    }

    protected WeatherDataModel(Parcel in) {
        mTimeZone = in.readString();
        mCurrentSummary = in.readString();
        mHourlySummary = in.readString();
        mDailySummary = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTimeZone);
        dest.writeString(mCurrentSummary);
        dest.writeString(mHourlySummary);
        dest.writeString(mDailySummary);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherDataModel> CREATOR =
            new Creator<WeatherDataModel>() {
                @Override
                public WeatherDataModel createFromParcel(Parcel in) {
                    return new WeatherDataModel(in);
                }

                @Override
                public WeatherDataModel[] newArray(int size) {
                    return new WeatherDataModel[size];
                }
            };

    @NonNull
    public String getTimeZone() {
        return mTimeZone;
    }

    @NonNull
    public String getCurrentSummary() {
        return mCurrentSummary;
    }

    @NonNull
    public String getHourlySummary() {
        return mHourlySummary;
    }

    @NonNull
    public String getDailySummary() {
        return mDailySummary;
    }

    @NonNull
    public static WeatherDataModel fromWeatherResponse
            (@NonNull final WeatherResponse weatherResponse) {
        return new WeatherDataModel(weatherResponse.getTimezone(),
                weatherResponse.getCurrently().getSummary(),
                weatherResponse.getHourly().getSummary(),
                weatherResponse.getDaily().getSummary());
    }
}
