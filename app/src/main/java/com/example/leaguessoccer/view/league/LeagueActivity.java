package com.example.leaguessoccer.view.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ILeagueView;
import com.example.leaguessoccer.models.Team;
import com.example.leaguessoccer.presenter.LeaguePresenterImpl;
import com.example.leaguessoccer.view.league.adapter.IOnclickTeam;
import com.example.leaguessoccer.view.league.adapter.InfoTeamAdapter;

import java.util.ArrayList;
import java.util.List;

public class LeagueActivity extends AppCompatActivity implements ILeagueView {

    private ILeaguePresenter presenter;
    private RecyclerView rvTeams;
    private InfoTeamAdapter infoTeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        presenter = new LeaguePresenterImpl(this);
        presenter.getTeams("Spanish La Liga");
        rvTeams = findViewById(R.id.rv_teams);
        infoTeamAdapter = new InfoTeamAdapter(new ArrayList<>(), new IOnclickTeam() {
            @Override
            public void onClickTeam(String idTeam) {
                presenter.getTeam(idTeam);
            }
        });
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        rvTeams.setAdapter(infoTeamAdapter);
    }

    @Override
    public void showTeams(List<Team> teams) {
        infoTeamAdapter.setDataAdapter(teams);
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
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}