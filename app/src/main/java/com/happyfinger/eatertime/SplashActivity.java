package com.happyfinger.eatertime;

import android.content.Intent;
import android.os.Bundle;
import com.umeng.fb.FeedbackAgent;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class SplashActivity extends BaseActivity implements Runnable {
    private boolean mIsPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        OneApp.getHandler().postDelayed(this, 1000);
        // umeng
        FeedbackAgent agent = new FeedbackAgent(getApplicationContext());
        agent.sync();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsPaused = true;
    }

    @Override
    public void run() {
        if (!mIsPaused) {
            startActivity(new Intent(getApplicationContext(), GuideActivity.class));
        }
        finish();
    }
}
