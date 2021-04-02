package com.example.leaguessoccer.presenter;

import com.example.leaguessoccer.interactors.LeagueInteractorImpl;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ILeagueView;
import com.example.leaguessoccer.models.League;
import com.example.leaguessoccer.models.Team;

import java.util.List;

public class LeaguePresenterImpl implements ILeaguePresenter {
    private ILeagueView view;
    private ILeagueInteractor interactor;

    public LeaguePresenterImpl(ILeagueView leagueView) {
        view = leagueView;
        interactor = new LeagueInteractorImpl(this);
    }

    @Override
    public void getTeams(String league) {
        interactor.getTeams(league);
    }

    @Override
    public void getTeam(String idTeam) {
        interactor.getTeam(idTeam);
    }

    @Override
    public void showTeams(League league) {
        if (!league.getTeams().isEmpty()){
            view.showTeams(league.getTeams());
        }else {
            view.showToast("Lista de equipos vacia");
        }
    }

    @Override
    public void showTeam(Team team) {

    }

    @Override
    public void initProgressBar() {

    }

    @Override
    public void cancelProgressBar() {

    }

    @Override
    public void showToast(String message){

    }

    private boolean validateView() {
        return view != null;
    }

    private boolean validateInteractor() {
        return interactor != null;
    }
}
