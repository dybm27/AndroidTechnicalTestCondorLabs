package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ILeagueView {
    void showTeams(List<Team> teams);
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
