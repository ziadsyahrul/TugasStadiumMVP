package com.ziadsyahrul.tugasrepositorypattern.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {

    @SerializedName("teams")
    private List<TeamsData> teams;

    public List<TeamsData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsData> teams) {
        this.teams = teams;
    }
}
