package com.example.labor2_hazi1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {
    private static final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG, "ActivityTwo - onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityTwo - onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityTwo - onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityTwo - onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityTwo - onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityTwo - onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivityTwo - onDestroy called");
    }

    public void startActivityThree(View view) {
        Intent intent = new Intent(this, ActivityThree.class);
        startActivity(intent);
    }
}
