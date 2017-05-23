package sayaan.com.helloandroid;

/**
 * Created by sayaan on 5/16/17.
 */

import com.leanplum.Leanplum;
import com.leanplum.LeanplumApplication;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.Var;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.annotations.Parser;


public class LeanplumApp extends LeanplumApplication {
    public static final String API_HOST_NAME = "Asdasda";
    public static final String APP_ID = "qweqweqwe";
    public static final String DEVELOPMENT_KEY = "234235345334";

    @Override
    public void onCreate(){
        super.onCreate();
        if(BuildConfig.DEBUG){
            Leanplum.setAppIdForDevelopmentMode(APP_ID, DEVELOPMENT_KEY);
        }
    }


}
