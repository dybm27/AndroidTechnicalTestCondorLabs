package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.Event;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ITeamPresenter {
    void getTeam(String idTeam);
    void showTeam(Team team);
    void getNextsEvent(String idTeam);
    void showNextsEvent(List<Event> events);
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
