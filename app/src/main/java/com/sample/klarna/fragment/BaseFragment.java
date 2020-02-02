package com.sample.klarna.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment extends Fragment {

    @Nullable
    private Unbinder mViewUnbinder;

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        if (mViewUnbinder != null) {
            mViewUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
