package com.example.yeschef;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Recipe.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("WzUaBK9Vzy7jJ9gAnt47RkqZyZo00sKUOXxoxodD")
                .clientKey("8JYwvId3jNSPqanoWjEfDqO5HY4TXzLFr9JF7Hpq")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
