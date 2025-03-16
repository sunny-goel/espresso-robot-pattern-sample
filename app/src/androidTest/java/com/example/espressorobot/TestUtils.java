package com.example.espressorobot;

import android.app.Activity;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import android.util.Log;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ftoptas on 04/01/18.
 */

public class TestUtils {

    public static Activity getCurrentActivity() {
        final Activity[] currentActivity = {null};
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }
}
