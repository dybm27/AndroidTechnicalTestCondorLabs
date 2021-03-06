package com.example.leaguessoccer.presenter;

import android.content.Context;

import com.example.leaguessoccer.interactors.LeagueInteractorImpl;
import com.example.leaguessoccer.interfaces.ILeagueInteractor;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ILeagueView;
import com.example.leaguessoccer.interfaces.Task;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;

import java.util.List;
import java.util.concurrent.Callable;

public class LeaguePresenterImpl extends BasePresenter implements ILeaguePresenter {
    private ILeagueView view;
    private ILeagueInteractor interactor;

    public LeaguePresenterImpl(ILeagueView leagueView, Context context) {
        view = leagueView;
        interactor = new LeagueInteractorImpl(this, context);
    }

    @Override
    public void getTeams(String league) {
        initProgressBar();
        executeTask(new Callable<List<Team>>() {
            @Override
            public List<Team> call() throws Exception {
                return interactor.getTeamsBd(league);
            }
        }, new Task<List<Team>>() {
            @Override
            public void onComplete(List<Team> result) {
                if (result != null) {
                    view.showTeams(result);
                    cancelProgressBar();
                } else {
                    interactor.getTeams(league);
                }
            }

            @Override
            public void onError(String error) {
                showToast(error);
            }
        });
    }

    @Override
    public void showTeams(League league) {
        if (!league.getTeams().isEmpty()) {
            view.showTeams(league.getTeams());
        } else {
            showToast("Lista de equipos vacia");
        }
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

    @Override
    public void addLeagueBd(League league) {
        executeTask(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                interactor.addLeagueBd(league);
                return true;
            }
        }, new Task<Boolean>() {
            @Override
            public void onComplete(Boolean result) {
                System.out.println("League add");
            }

            @Override
            public void onError(String error) {
                showToast(error);
            }
        });
    }
}
