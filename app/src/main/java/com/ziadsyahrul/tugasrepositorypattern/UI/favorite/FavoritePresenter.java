package com.ziadsyahrul.tugasrepositorypattern.UI.favorite;

import android.content.Context;

import com.ziadsyahrul.tugasrepositorypattern.data.local.FootballDatabase;

public class FavoritePresenter implements FavoriteContract.Presenter{

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }


    @Override
    public void getDataListUser(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailureMessage("Tidak ada data di favorite");
        }
        view.hideRefresh();
    }
}
