package sayaan.com.helloandroid;

/**
 * Created by sayaan on 5/16/17.
 */

import com.leanplum.Leanplum;
import com.leanplum.LeanplumApplication;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumDeviceIdMode;
import com.leanplum.LeanplumPushService;
import com.leanplum.Var;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.annotations.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class LeanplumApp extends LeanplumApplication {
    public static final String API_HOST_NAME = Configure.API_HOST_NAME;
    public static final String APP_ID = Configure.APP_ID;
    public static final String DEVELOPMENT_KEY = Configure.DEVELOPMENT_KEY;
    public static final String PRODUCTION_KEY = Configure.PRODUCTION_KEY;
    public static final String SOCKET_HOST_NAME = Configure.SOCKET_HOST_NAME;
    public static final int SOCKET_PORT = Configure.SOCKET_PORT;
    public static final boolean API_SSL = Configure.API_SSL;
    public static final LeanplumDeviceIdMode DEVICE_ID_MODE = Configure.DEVICE_ID_MODE;

    @Override
    public void onCreate(){
        super.onCreate();
        if(BuildConfig.DEBUG){
            Leanplum.setAppIdForDevelopmentMode(APP_ID, DEVELOPMENT_KEY);
        }
        else {
            Leanplum.setAppIdForProductionMode(APP_ID,PRODUCTION_KEY);
        }
        Leanplum.setApiConnectionSettings(API_HOST_NAME, "api", API_SSL);
        Leanplum.setSocketConnectionSettings(SOCKET_HOST_NAME, SOCKET_PORT);
        Leanplum.enableVerboseLoggingInDevelopmentMode();

        if(BuildConfig.USE_FIREBASE){
            LeanplumPushService.enableFirebase();
        }

        List<String> resourceList = Arrays.asList( ".*main.*.xml.*", ".*ic_launcher.png", ".*dialog.*.xml", ".*jinja.*");
        Leanplum.setDeviceIdMode(DEVICE_ID_MODE);
        Parser.parseVariablesForClasses(LeanplumVars.class);

        LeanplumPushService.setGcmSenderIds(LeanplumPushService.LEANPLUM_SENDER_ID);
        //LeanplumPushService.unregister();

        Map<String,Object> attributes = new HashMap<String, Object>();
        attributes.put("email","sayaan@leanplum.com");

        //MessageTemplates.register(getApplicationContext());

        long start = System.nanoTime();
        LeanplumActivityHelper.deferMessagesForActivities(sayaan.com.helloandroid.SplashActivity);

    }


}
