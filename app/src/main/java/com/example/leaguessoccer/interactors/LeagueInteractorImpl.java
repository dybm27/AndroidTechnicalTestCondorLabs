package com.example.leaguessoccer.interactors;


import android.content.Context;

import androidx.room.Room;

import com.example.leaguessoccer.apiconfig.RetrofitServices;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.LeagueWhitTeamList;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.database.scheme.LeagueDb;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueInteractorImpl implements ILeagueInteractor {

    private ILeaguePresenter presenter;
    private LeagueDb db;

    public LeagueInteractorImpl(ILeaguePresenter leaguePresenter, Context context) {
        this.presenter = leaguePresenter;
        this.db = Room.databaseBuilder(context,
                LeagueDb.class, "league")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Override
    public List<Team> getTeamsBd(String league) {
        System.out.println(league);
        LeagueWhitTeamList lg = db.leagueDao().getLeagueWhitTeams(league);
        if (lg == null) {
            return null;
        }
        return lg.getTeams();
    }

    @Override
    public void getTeams(String league) {
        Call<League> call = RetrofitServices.getApiService().getTeams(league);
        call.enqueue(new Callback<League>() {
            @Override
            public void onResponse(Call<League> call, Response<League> response) {
                presenter.cancelProgressBar();
                if (response.isSuccessful()) {
                    League l = response.body();
                    l.setName(league);
                    presenter.addLeagueBd(l);
                    presenter.showTeams(l);
                } else {
                    presenter.showToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<League> call, Throwable t) {
                presenter.showToast("Error de conexion");
            }
        });
    }

    @Override
    public void addLeagueBd(League league) {
        for (Team t : league.getTeams()) {
            t.setNameLeague(league.getName());
        }
        db.leagueDao().insertLeague(league);
        db.teamDao().insertAll(league.getTeams());
    }

    public LeagueDb getDb(){
        return db;
    }
}
