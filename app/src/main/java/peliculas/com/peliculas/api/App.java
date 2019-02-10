package peliculas.com.peliculas.api;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("7ljEk8ZnBOC7RzufS5RDA9rhua2EagLyLElrAEqv")
                // if defined
                .clientKey("hqK3QnCssF4I5IDjiB6dmWBKfev22GlzZOUGRIQc")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}