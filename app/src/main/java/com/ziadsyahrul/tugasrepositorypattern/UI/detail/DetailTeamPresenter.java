package com.ziadsyahrul.tugasrepositorypattern.UI.detail;

import android.content.Context;
import android.os.Bundle;

import com.ziadsyahrul.tugasrepositorypattern.Utils.Constant;
import com.ziadsyahrul.tugasrepositorypattern.data.local.FootballDatabase;
import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

public class DetailTeamPresenter implements DetailTeamContract.Presenter{

    private final DetailTeamContract.View view;
    private FootballDatabase footballDatabase;

    public DetailTeamPresenter(DetailTeamContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailTeam(Bundle bundle) {
        if (bundle != null){
            TeamsData teamsData = (TeamsData) bundle.getSerializable(Constant.KEY_DATA);
            view.showDetailTeam(teamsData);
        }else {
            view.showFailureMessage("Datanya Kosong Boos");
        }
    }

    @Override
    public void addToFavorite(Context context, TeamsData teamsData) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().insertItem(teamsData);

        view.showSuccessMessage("Tersimpan");
    }

    @Override
    public void removeFavorite(Context context, TeamsData teamsData) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().delete(teamsData);
        view.showSuccessMessage("Terhapus");
    }

    @Override
    public Boolean checkFavorite(Context context, TeamsData teamsData) {
        Boolean bFavorite = false;

        footballDatabase = FootballDatabase.getFootballDatabase(context);
        return bFavorite = footballDatabase.footballDao().selectItem(teamsData.getIdTeam()) != null;
    }
}
