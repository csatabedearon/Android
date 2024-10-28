package com.example.labor2_hazi1;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityThree extends AppCompatActivity {
    private static final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Log.d(TAG, "ActivityThree - onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityThree - onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityThree - onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityThree - onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityThree - onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityThree - onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivityThree - onDestroy called");
    }
}
