package agency.alterway.sekac;

import android.app.Application;
import android.content.Context;

/**
 * Created by marekrigan on 22/02/16.
 */
public class SekacApplication extends Application
{
    private static SekacApplication instance;
    private static Context             context;

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
