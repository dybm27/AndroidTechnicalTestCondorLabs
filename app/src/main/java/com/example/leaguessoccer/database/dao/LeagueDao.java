package com.example.leaguessoccer.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.leaguessoccer.database.entity.LeagueWhitTeamList;
import com.example.leaguessoccer.database.entity.League;

import java.util.List;


@Dao
public interface LeagueDao {
    @Insert
    void insertLeague(League league);

    @Delete
    void delete(League league);

    @Query("SELECT * FROM league")
    List<League> getAll();

    @Query("SELECT * FROM league WHERE name LIKE :name")
    League findByName(String name);

    @Transaction
    @Query("SELECT * FROM league WHERE name LIKE :name")
    LeagueWhitTeamList getLeagueWhitTeams(String name);
}
