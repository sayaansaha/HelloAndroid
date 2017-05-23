package sayaan.com.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.leanplum.LeanplumActivityHelper;

import sayaan.com.helloandroid.MainActivity;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // Only start intent to MainActivity if current activity != splash screen.
                if (LeanplumActivityHelper.getCurrentActivity() == null ||
                        (LeanplumActivityHelper.getCurrentActivity() != null &&
                                LeanplumActivityHelper.getCurrentActivity().equals(SplashActivity.this))) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }
        }, 3000);
    }
}
