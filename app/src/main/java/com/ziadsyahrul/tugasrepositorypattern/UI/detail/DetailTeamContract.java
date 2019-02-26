package com.ziadsyahrul.tugasrepositorypattern.UI.detail;

import android.content.Context;
import android.os.Bundle;

import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

public interface DetailTeamContract {

    interface View{
        void showDetailTeam(TeamsData teamsData);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface Presenter{
        void getDetailTeam(Bundle bundle);
        void addToFavorite(Context context, TeamsData teamsData);
        void removeFavorite(Context context, TeamsData teamsData);
        Boolean checkFavorite(Context context, TeamsData teamsData);
    }
}
