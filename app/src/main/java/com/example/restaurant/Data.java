package com.example.restaurant;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {restaurants.class}, version = 1)
public abstract class Data extends RoomDatabase {
    public abstract com.example.restaurant.Dao.Database Database();
    private static Data instance;

    public static synchronized Data getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Data.class, "restaurants").allowMainThreadQueries().build();
        }
        return instance;
    }

}