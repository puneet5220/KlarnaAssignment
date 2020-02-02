package com.sample.klarna.activity;

import android.os.Bundle;

import com.sample.klarna.fragment.SplashFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            loadFragment(SplashFragment.newInstance(), false);
        }
    }
}
