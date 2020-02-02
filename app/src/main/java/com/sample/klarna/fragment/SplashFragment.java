package com.sample.klarna.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.sample.klarna.datainjection.DependencyInjector;
import com.sample.klarna.repository.Repository;
import com.sample.klarna.statedata.StateData;
import com.sample.klarna.utils.NavigationalHandler;
import com.sample.klarna.viewmodel.CustomViewModelFactory;
import com.sample.klarna.viewmodel.WeatherViewModel;
import com.sample.klarna.viewmodel.WeatherDataModel;
import com.sample.klarna.R;

import javax.inject.Inject;

public class SplashFragment extends BaseFragment {
    @Inject
    Repository mRepository;
    @Inject
    CustomViewModelFactory mViewModelFactory;
    private NavigationalHandler mNavigationalHandler;
    private WeatherViewModel mWeatherViewModel;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mNavigationalHandler = (NavigationalHandler) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement mNavigationalHandler");
        }
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
        return inflater.inflate(R.layout.splash_screen, container, false);
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
        mWeatherViewModel.getWeatherResponse(requireContext());
    }

    /**
     * Perform Action when Data is received.
     *
     * @param data data
     */
    private void performActionOnObserverState(@Nullable final StateData<WeatherDataModel>
                                                      data) {
        if (data != null) {
            switch (data.getStatus()) {
                case SUCCESS:
                    proceedToFragment();
                    break;
                case ERROR:
                    setError(data);
                    break;
                default:
                    break;
            }
        }
    }

    private void setError(@NonNull final StateData<WeatherDataModel> data) {
        if (data.getError() != null) {
            Toast.makeText(getContext(), data.getError().getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Invalid", Toast.LENGTH_LONG).show();
        }
    }

    private void proceedToFragment() {
        mNavigationalHandler.loadFragment(WeatherDetailsFragment.newInstance(), false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mWeatherViewModel.getObservable()
                .removeObservers(getViewLifecycleOwner());
    }
}
