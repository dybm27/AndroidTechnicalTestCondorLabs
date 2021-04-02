package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

public interface ITeamPresenter {
    void getTeam(String idTeam);
    void showTeam(Team team);
    void getNextsEvent(String idTeam);
    void showNextsEvent();
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
