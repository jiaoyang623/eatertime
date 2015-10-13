package com.happyfinger.eatertime;

import android.app.Activity;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(getApplicationContext());
    }
}
