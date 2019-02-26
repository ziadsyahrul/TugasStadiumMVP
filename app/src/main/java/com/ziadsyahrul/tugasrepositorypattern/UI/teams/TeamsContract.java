package com.ziadsyahrul.tugasrepositorypattern.UI.teams;

import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

import java.util.List;

public interface TeamsContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsData> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListStadium();
    }
}
