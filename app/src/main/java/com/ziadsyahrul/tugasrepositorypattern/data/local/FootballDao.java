package com.ziadsyahrul.tugasrepositorypattern.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

import java.util.List;

@Dao
public interface FootballDao {

    @Insert
    void insertItem(TeamsData teamsData);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    TeamsData selectItem(String id);

    @Delete
    void delete(TeamsData teamsData);

    @Query("SELECT * FROM teams ORDER BY strStadium ASC")
    List<TeamsData> selectFavorite();
}

