package com.sanju.udemylearning.BackgroundProcess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import static com.sanju.udemylearning.BackgroundProcess.BackgroundServicesActivity.ACTION_CHECK_STATUS;
import static com.sanju.udemylearning.BackgroundProcess.BackgroundServicesActivity.ACTION_DO_STAFF;

public class SimpleJobIntentService extends JobIntentService {

    /**
     * Unique job ID for this service.
     */
    static final int JOB_ID = 1000;

    /**
     * Convenience method for enqueuing work in to this service.
     */
    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, SimpleJobIntentService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        // We have received work to do.  The system or framework is already
        // holding a wake lock for us at this point, so we can just go.
        Log.i("SimpleJobIntentService", "Executing work: " + intent);
//        String label = intent.getStringExtra("label");
//        if (label == null) {
//            label = intent.toString();
//        }
//        toast("Executing: " + label);
//            Log.i("SimpleJobIntentService", "Running service " + (i + 1)
//                    + "/5 @ " + SystemClock.elapsedRealtime());
            if (intent.getAction() != null){
                switch (intent.getAction()){
                    case ACTION_DO_STAFF:
                        int staffToDo = 100;
                        for (int i=0; i<staffToDo; i++){
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e){
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("status", 1);
                            sendBroadcast(new Intent().setAction(ACTION_CHECK_STATUS).putExtras(bundle));
                        }
                        break;
                }
            }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toast("All work complete");
    }

    final Handler mHandler = new Handler();

    // Helper for showing tests
    void toast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override public void run() {
                Toast.makeText(SimpleJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
