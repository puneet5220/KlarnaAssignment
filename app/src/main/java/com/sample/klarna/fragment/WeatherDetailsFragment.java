package com.sample.klarna.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.sample.klarna.datainjection.DependencyInjector;
import com.sample.klarna.statedata.StateData;
import com.sample.klarna.viewmodel.CustomViewModelFactory;
import com.sample.klarna.viewmodel.WeatherDataModel;
import com.sample.klarna.viewmodel.WeatherViewModel;
import com.sample.klarna.R;

import javax.inject.Inject;

import butterknife.BindView;

public class WeatherDetailsFragment extends BaseFragment {

    @BindView(R.id.tv_timezone)
    TextView mTImeZone;
    @BindView(R.id.tv_current_summary)
    TextView mCurrentSummary;
    @BindView(R.id.tv_hourly_summary)
    TextView mHourlySummary;
    @BindView(R.id.tv_daily_summary)
    TextView mDailySummary;

    @Inject
    CustomViewModelFactory mViewModelFactory;
    private WeatherViewModel mWeatherViewModel;

    static WeatherDetailsFragment newInstance() {
        return new WeatherDetailsFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DependencyInjector
                .applicationComponent()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        observeViewModel();
    }

    /**
     * Observe ViewModel for the Data
     */
    private void observeViewModel() {
        mWeatherViewModel = ViewModelProviders
                .of(this, mViewModelFactory).get(WeatherViewModel.class);
        mWeatherViewModel.getObservable().observe(getViewLifecycleOwner(),
                this::performActionOnObserverState);
    }

    /**
     * Perform Action when Data is received.
     *
     * @param data data
     */
    private void performActionOnObserverState(@Nullable final StateData<WeatherDataModel> data) {
        if (data != null) {
            switch (data.getStatus()) {
                case SUCCESS:
                    setDetails(data);
                    break;
                case ERROR:
                    setError();
                    break;
                default:
                    break;
            }
        }
    }

    private void setDetails(@NonNull final StateData<WeatherDataModel> weatherData) {
        if (weatherData.getData() != null) {
            mTImeZone.setText(getString(R.string.timezone,
                    weatherData.getData().getTimeZone()));
            mCurrentSummary.setText(getString(R.string.currentSummary,
                    weatherData.getData().getCurrentSummary()));
            mHourlySummary.setText(getString(R.string.hourlySummary,
                    weatherData.getData().getHourlySummary()));
            mDailySummary.setText(getString(R.string.dailySummary,
                    weatherData.getData().getDailySummary()));
        }
    }

    private void setError() {
        Toast.makeText(getContext(), "InValid", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mWeatherViewModel.getObservable().removeObservers(getViewLifecycleOwner());
    }
}
