package sayaan.com.helloandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.leanplum.Leanplum;
import com.leanplum.callbacks.StartCallback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends FragmentActivity {
    final long startTime = System.currentTimeMillis();

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Leanplum.start(this, "HomeMade App", null, new StartCallback() {
            @Override
            public void onResponse(boolean success) {
                Log.i("Sayaan App", "App has been started: " + success);
            }
        });

        Leanplum.track("Test Activity");
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("Leanplum", "San Francisco");
        attributes.put("Sayaan", "Saha");
        List<String> list = Arrays.asList("Alpha", "bravo", "charlie");
        attributes.put("list an object", list);
        Leanplum.setUserAttributes(attributes);


        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        final TextView tv = new TextView(this);
        final ImageView im = new ImageView(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.addView(tv);
        layout.addView(im);
        getResources().getString(R.string.title_home);


        final Button buttonParis = (Button) findViewById(R.id.buttonParis);
        buttonParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leanplum.track("Paris");
            }
        });

        final Button buttonChicago = (Button) findViewById(R.id.buttonChicago);
        buttonChicago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leanplum.track("Chicago");
            }
        });

        final Button buttonNewYork = (Button) findViewById(R.id.buttonNewYork);
        buttonNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leanplum.track("New York");
            }
        });

        final Button buttonLA = (Button) findViewById(R.id.buttonLA);
        buttonLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leanplum.track("LA");
            }
        });


        TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == 0)) {
                    // hide virtual keyboard
                    InputMethodManager imm = (InputMethodManager) v.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        };

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

        };

        Map<String, String> info = new HashMap<String, String>();
        info.put("publisherId", "asdf");
        Leanplum.setTrafficSourceInfo(info);

        Log.i("Android SDK Test App", "Start time: " +
                ((System.currentTimeMillis() - startTime) / 1000.0));

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("Leanplum", "original touch listener!!!");
                }
                return false;
            }
        });
    }
}
