package com.example.restaurant.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.restaurant.restaurants;

import java.util.List;

    @Dao
    public interface Database {
        @Query("SELECT * FROM restaurants")
        List<restaurants> getAll();

        @Query("SELECT * FROM restaurants WHERE name LIKE :name")
        List<restaurants> getByName(String name);


        @Insert
        void insert(restaurants restaurant);
       // @Query("SELECT * FROM restaurants WHERE rating =:Rating || name=:name ||location=:location||phone=:phone " )
       @Query("SELECT * FROM restaurants WHERE  name LIKE  :name || '%' AND location LIKE '%' || :location || '%' AND phone LIKE '%' || :phone || '%' AND rating LIKE '%' || :rating || '%'AND description LIKE '%' || :Des || '%'")


            // @Query("SELECT * FROM restaurants WHERE rating =:Rating AND " +
         //       "name LIKE '%' || :name || '%' AND location LIKE '%' || :location || '%' AND :Rating LIKE '%' || :phone || '%' " )
        List<restaurants> getByFilter(String name, String location,String Des, int phone, float rating);

    }
