package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.models.Team;

import java.util.List;

public interface ILeagueView {
    void showTeams(List<Team> teams);
    void showTeam(Team team);
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
