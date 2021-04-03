package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.Event;
import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ITeamView {
    void showTeam(Team team);
    void showNextsEvent(List<Event> events);
    void initProgressBar();
    void cancelProgressBar();
    void showToast(String message);
}
