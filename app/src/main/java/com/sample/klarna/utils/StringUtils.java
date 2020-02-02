package com.sample.klarna.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StringUtils {
    private static final String EMPTY_STRING = "";

    StringUtils() {
        // Not allowed.
    }

    @NonNull
    public static String emptyIfNull(@Nullable final String str) {
        return isEmpty(str) ? EMPTY_STRING : str;
    }

    private static boolean isEmpty(String cs) {
        return cs == null || cs.length() == 0;
    }
}
