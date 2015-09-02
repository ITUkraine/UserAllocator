package jobsukraine.com.ua.userallocator;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by User on 02.09.2015.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, getString(R.string.parse_application_id), getString(R.string.parse_client_key));
    }
}
