package com.example.leaguessoccer.apiconfig;

import com.example.leaguessoccer.database.entity.League;
import com.example.leaguessoccer.database.entity.ResponseEvents;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheSportsDBApi {
    @GET("search_all_teams.php")
    Call<League> getTeams(@Query("l") String league);

    @GET("eventslast.php")
    Call<ResponseEvents> getNextsEvents(@Query("id") String idTeam);
}
