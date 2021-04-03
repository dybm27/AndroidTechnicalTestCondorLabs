package com.example.leaguessoccer;
import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.interactors.LeagueInteractorImpl;
import com.example.leaguessoccer.interfaces.ILeaguePresenter;
import com.example.leaguessoccer.view.league.LeagueActivity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LeagueInteractorImplTest extends TestCase {

    private LeagueInteractorImpl interactor;

    @Mock
    private ILeaguePresenter presenter;
    @Mock
    private LeagueActivity context;

    @Before
    public void setUp(){
        interactor = new LeagueInteractorImpl(presenter,context);
    }

    @Test
    public void getTeamsBd() {
        assertNotNull(interactor.getDb());
        List<Team> teams = interactor.getTeamsBd("Italian Serie A");
        assertNull(teams);
    }
    @Test
    public void getTeams() {
        interactor.getTeams("Italian Serie A");
        List<Team> teams = interactor.getTeamsBd("Italian Serie A");
        assertEquals(teams.size(),20);
        League league = interactor.getDb().leagueDao().findByName("Italian Serie A");
        interactor.getDb().leagueDao().delete(league);
        League league1 = interactor.getDb().leagueDao().findByName("Italian Serie A");
        assertNull(league1);
    }
    @Test
    public void addLeagueBd() {
        League league = new League();
        league.setName("Culaquier cosa");
        Team team = new Team();
        team.setIdTeam("123");
        league.setTeams(new ArrayList<>());
        interactor.addLeagueBd(league);
        interactor.getDb().leagueDao().delete(league);
    }
}