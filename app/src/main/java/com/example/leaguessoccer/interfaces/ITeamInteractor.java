package com.example.leaguessoccer.interfaces;

import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

import java.util.List;

public interface ITeamInteractor {
    Team getTeamBd(String idTeam);
    void getNextsEvent(String idTeam);
}
