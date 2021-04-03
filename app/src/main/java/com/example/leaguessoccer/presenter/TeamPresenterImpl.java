package com.example.leaguessoccer.presenter;

import android.content.Context;

import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.interactors.LeagueInteractorImpl;
import com.example.leaguessoccer.interactors.TeamInteractorImpl;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ILeagueView;
import com.example.leaguessoccer.interfaces.ITeamInteractor;
import com.example.leaguessoccer.interfaces.ITeamPresenter;
import com.example.leaguessoccer.interfaces.ITeamView;
import com.example.leaguessoccer.interfaces.Task;

import java.util.List;
import java.util.concurrent.Callable;

public class TeamPresenterImpl extends BasePresenter implements ITeamPresenter {
    private ITeamView view;
    private ITeamInteractor interactor;

    public TeamPresenterImpl(ITeamView teamView, Context context) {
        view = teamView;
        interactor = new TeamInteractorImpl(this, context);
    }

    @Override
    public void getTeam(String idTeam) {
        initProgressBar();
        executeTask(new Callable<Team>() {
            @Override
            public Team call() throws Exception {
                return interactor.getTeamBd(idTeam);
            }
        }, new Task<Team>() {
            @Override
            public void onComplete(Team result) {
                view.showTeam(result);
                cancelProgressBar();
            }

            @Override
            public void onError(String error) {
                view.showToast(error);
            }
        });
    }

    @Override
    public void showTeam(Team team) {

    }

    @Override
    public void getNextsEvent(String idTeam) {
        //initProgressBar();
        //interactor.getNextsEvent(idTeam);
    }

    @Override
    public void showNextsEvent() {
        view.showNextsEvent();
    }

    @Override
    public void initProgressBar() {
        view.initProgressBar();
    }

    @Override
    public void cancelProgressBar() {
        view.cancelProgressBar();
    }

    @Override
    public void showToast(String message) {
        view.showToast(message);
    }
}
