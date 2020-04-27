package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;
import com.laioffer.tinnews.database.AppDatabase;

public class TinNewsApplication extends Application {
    private  static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Gander.setGanderStorage(GanderIMDB.getInstance());
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "tin_db").build();
        Stetho.initializeWithDefaults(this);
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
