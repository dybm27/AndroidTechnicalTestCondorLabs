package com.example.leaguessoccer.interactors;


import com.example.leaguessoccer.apiconfig.RetrofitServices;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.models.League;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueInteractorImpl implements ILeagueInteractor {

    private ILeaguePresenter presenter;

    public LeagueInteractorImpl(ILeaguePresenter leaguePresenter) {
        this.presenter = leaguePresenter;
    }

    @Override
    public void getTeams(String league) {
        //validar si ya esta en la bd y retornar eso
        presenter.initProgressBar();
        Call<League> call = RetrofitServices.getApiService().getTeams(league);
        call.enqueue(new Callback<League>() {
            @Override
            public void onResponse(Call<League> call, Response<League> response) {
                presenter.cancelProgressBar();
                if (response.isSuccessful()){
                    presenter.showTeams(response.body());
                }else{
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
    public void getTeam(String idTeam) {
        //obtnener equipo de la bd
    }
}
