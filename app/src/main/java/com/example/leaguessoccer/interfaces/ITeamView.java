package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ITeamView {
    void showTeam(Team team);
    void showNextsEvent();
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
