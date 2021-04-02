package com.example.leaguessoccer.database.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class LeagueWhitTeamList {
    @Embedded
    public League league;
    @Relation(
            parentColumn = "name",
            entityColumn = "nameLeague"
    )
    public List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
