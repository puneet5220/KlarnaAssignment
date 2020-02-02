package com.sample.klarna.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public interface NavigationalHandler {

    void loadFragment(@NonNull Fragment fragment, final boolean isAddToBackStack);
}
