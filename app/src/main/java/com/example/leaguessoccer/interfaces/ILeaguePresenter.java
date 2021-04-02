package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.models.League;
import com.example.leaguessoccer.models.Team;

import java.util.List;

public interface ILeaguePresenter {
    void getTeams(String league);
    void getTeam(String idTeam);
    void showTeams(League league);
    void showTeam(Team team);
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
