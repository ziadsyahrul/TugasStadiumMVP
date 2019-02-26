package com.ziadsyahrul.tugasrepositorypattern.data.remote;

import com.ziadsyahrul.tugasrepositorypattern.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<TeamResponse> getAllTeams(
            @Query("l") String l
    );
}
