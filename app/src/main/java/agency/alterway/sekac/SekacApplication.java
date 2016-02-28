package agency.alterway.sekac;

import android.app.Application;
import android.content.Context;

/**
 * Application class to provide context for non-Android classes
 *
 * Created by marekrigan on 22/02/16.
 */
public class SekacApplication extends Application
{
    private static SekacApplication instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext()
    {
        return instance.getApplicationContext();
    }

}
