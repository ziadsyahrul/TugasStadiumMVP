package com.ziadsyahrul.tugasrepositorypattern.UI.favorite;

import android.content.Context;

import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataList(List<TeamsData> teamsDataList);
        void showFailureMessage(String msg);
        void hideRefresh();

    }

    interface Presenter{
        void getDataListUser(Context context);
    }
}
