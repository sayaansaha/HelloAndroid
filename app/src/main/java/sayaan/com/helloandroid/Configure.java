package sayaan.com.helloandroid;

/**
 * Created by sayaan on 5/23/17.
 */

import com.leanplum.LeanplumDeviceIdMode;

public class Configure {
    public static final String APP_ID= "";
    public static final String PRODUCTION_KEY = "";
    public static final String DEVELOPMENT_KEY= "";

    public static final String API_HOST_NAME = "leanplum-qa-1372.appspot.com";
    public static final Boolean API_SSL = true;

    public static final String SOCKET_HOST_NAME = "dev-qa.leanplum.com";
    public static final Integer SOCKET_PORT = 80;
    public static final LeanplumDeviceIdMode DEVICE_ID_MODE = LeanplumDeviceIdMode.MD5_MAC_ADDRESS;

}
