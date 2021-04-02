package com.example.leaguessoccer.view.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.interfaces.ILeagueView;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.presenter.LeaguePresenterImpl;
import com.example.leaguessoccer.view.league.adapter.IOnclickTeam;
import com.example.leaguessoccer.view.league.adapter.InfoTeamAdapter;
import com.example.leaguessoccer.view.team.TeamDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class LeagueActivity extends AppCompatActivity implements ILeagueView {

    private ILeaguePresenter presenter;
    private RecyclerView rvTeams;
    private InfoTeamAdapter infoTeamAdapter;
    private Spinner spLeagues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        presenter = new LeaguePresenterImpl(this, this);
        rvTeams = findViewById(R.id.rv_teams);
        spLeagues = findViewById(R.id.sp_leagues);
        infoTeamAdapter = new InfoTeamAdapter(new ArrayList<>(), new IOnclickTeam() {
            @Override
            public void onClickTeam(String idTeam) {
                openActivity(idTeam);
            }
        });
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        rvTeams.setAdapter(infoTeamAdapter);
        setupOnItemSelected();
        filterLeague(spLeagues.getSelectedItemPosition());
    }

    private void setupOnItemSelected() {
        spLeagues.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterLeague(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void filterLeague(int position) {
        System.out.println(position);
        switch (position){
            case 0:
                presenter.getTeams("Spanish La Liga");
                break;
            case 1:
                presenter.getTeams("German Bundesliga");
                break;
            default:
                presenter.getTeams("English Premier League");
        }
    }

    private void openActivity(String idTeam) {
        Intent intent = new Intent(LeagueActivity.this, TeamDetailActivity.class);
        intent.putExtra("idTeam",idTeam);
        startActivity(intent);
    }

    @Override
    public void showTeams(List<Team> teams) {
        infoTeamAdapter.setDataAdapter(teams);
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