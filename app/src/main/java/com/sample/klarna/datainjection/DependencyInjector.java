package com.sample.klarna.datainjection;

import androidx.annotation.NonNull;

import com.sample.klarna.KlarnaApplication;

public class DependencyInjector {
    private static AppComponent applicationComponent;

    /**
     * Builds the app Component.
     */
    public static void initialize(@NonNull final KlarnaApplication application) {
        if (applicationComponent == null) {
            synchronized (DependencyInjector.class) {
                if (applicationComponent == null) {
                    applicationComponent = DaggerAppComponent
                            .builder()
                            .build();
                }
            }
        }
    }

    @NonNull
    public static AppComponent applicationComponent() {
        return applicationComponent;
    }

    private DependencyInjector() {
        // Not Permitted.
    }
}
