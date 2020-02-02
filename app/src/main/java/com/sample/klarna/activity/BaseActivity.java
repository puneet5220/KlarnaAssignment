package com.sample.klarna.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sample.klarna.utils.NavigationalHandler;
import com.sample.klarna.R;

public class BaseActivity extends AppCompatActivity implements NavigationalHandler {

    @Nullable
    public FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        setStatusBarColor(R.color.colorPrimary);
        mFragmentManager = getSupportFragmentManager();
    }

    /**
     * Adds the new fragment to the activity.
     *
     * @param fragment         Fragment to be added.
     * @param isAddToBackStack true if fragment to be added to the backStack.
     */
    @Override
    public void loadFragment(@NonNull Fragment fragment,
                             final boolean isAddToBackStack) {
        if (mFragmentManager == null) {
            mFragmentManager = getSupportFragmentManager();
        }
        final FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.baseContainer, fragment);

        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getTag());
        }
        fragmentTransaction.commit();
    }

    public void setStatusBarColor(final int color) {
        getWindow().setStatusBarColor(ContextCompat.getColor(this, color));
    }
}
