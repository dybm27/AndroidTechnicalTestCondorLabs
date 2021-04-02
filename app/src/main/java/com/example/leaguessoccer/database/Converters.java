package com.example.leaguessoccer.database;

import androidx.room.TypeConverter;

import com.example.leaguessoccer.database.entity.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Team> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Team>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Team> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
