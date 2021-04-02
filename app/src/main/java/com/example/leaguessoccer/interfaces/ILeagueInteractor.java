package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ILeagueInteractor {
    List<Team> getTeamsBd(String league);
    void getTeams(String league);
    void getTeam(String idTeam);
    void addLeagueBd(League league);
}
