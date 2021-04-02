package com.example.leaguessoccer.apiconfig;

import com.example.leaguessoccer.models.League;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheSportsDBApi {
    @GET("search_all_teams.php")
    Call<League> getTeams(@Query("l") String league);
}
