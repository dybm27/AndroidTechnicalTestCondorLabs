package com.example.leaguessoccer.interactors;


import android.content.Context;

import androidx.room.Room;

import com.example.leaguessoccer.apiconfig.RetrofitServices;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.LeagueWhitTeamList;
import com.example.leaguessoccer.database.entity.ResponseEvents;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.database.scheme.LeagueDb;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ITeamInteractor;
import com.example.leaguessoccer.interfaces.ITeamPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamInteractorImpl implements ITeamInteractor {

    private ITeamPresenter presenter;
    private LeagueDb db;

    public TeamInteractorImpl(ITeamPresenter teamPresenter, Context context) {
        this.presenter = teamPresenter;
        this.db = Room.databaseBuilder(context,
                LeagueDb.class, "league")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Override
    public Team getTeamBd(String idTeam) {
        return db.teamDao().findById(idTeam);
    }

    @Override
    public void getNextsEvent(String idTeam) {
        Call<ResponseEvents> call = RetrofitServices.getApiService().getNextsEvents(idTeam);
        call.enqueue(new Callback<ResponseEvents>() {
            @Override
            public void onResponse(Call<ResponseEvents> call, Response<ResponseEvents> response) {
                presenter.cancelProgressBar();
                if (response.isSuccessful()) {
                    presenter.showNextsEvent(response.body().getResults());
                } else {
                    presenter.showToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseEvents> call, Throwable t) {
                presenter.showToast("Error de conexion");
            }
        });
    }
}
