package sayaan.com.helloandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.leanplum.Leanplum;

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
        if(BuildConfig.TEST_START_IN_ACTIVITY){

        }


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
            public void onClick(View v){
                Leanplum.track("Paris");
            }
        });

        final Button buttonChicago = (Button) findViewById(R.id.buttonChicago);
        buttonChicago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Leanplum.track("Chicago");
            }
        });

        final  Button buttonNewYork = (Button) findViewById(R.id.buttonNewYork);
        buttonNewYork.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Leanplum.track("New York");
            }
        });

        final Button buttonLA = (Button) findViewById(R.id.buttonLA);
        buttonLA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Leanplum.track("LA");
            }
        });


    }

}
