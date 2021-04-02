package com.example.leaguessoccer.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.leaguessoccer.database.entity.Team;

import java.util.List;


@Dao
public interface TeamDao {
    @Query("SELECT * FROM team")
    List<Team> getAll();

    @Query("SELECT * FROM team WHERE idTeam = :id")
    Team findById(String id);

    @Insert
    void insertAll(List<Team> teams);

    @Delete
    void delete(Team team);
}
