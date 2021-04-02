package com.example.leaguessoccer.database.scheme;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.leaguessoccer.database.Converters;
import com.example.leaguessoccer.database.dao.LeagueDao;
import com.example.leaguessoccer.database.dao.TeamDao;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

@Database(entities = {League.class, Team.class}, version = 6)
@TypeConverters({Converters.class})
public abstract class LeagueDb extends RoomDatabase {
    public abstract LeagueDao leagueDao();
    public abstract TeamDao teamDao();
}
