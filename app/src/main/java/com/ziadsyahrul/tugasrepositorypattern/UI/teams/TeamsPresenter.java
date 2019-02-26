package com.ziadsyahrul.tugasrepositorypattern.UI.teams;

import com.ziadsyahrul.tugasrepositorypattern.Utils.Constant;
import com.ziadsyahrul.tugasrepositorypattern.data.remote.ApiClient;
import com.ziadsyahrul.tugasrepositorypattern.data.remote.ApiInterface;
import com.ziadsyahrul.tugasrepositorypattern.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsPresenter implements TeamsContract.Presenter{

    private final TeamsContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public TeamsPresenter(TeamsContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListStadium() {
        view.showProgress();

        Call<TeamResponse> call = apiInterface.getAllTeams(Constant.l);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                view.hideProgress();

                if (response.body() != null){
                    view.showDataList(response.body().getTeams());
                }else {
                    view.showFailureMessage("Data nya Kosong");
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                view.hideProgress();

                view.showFailureMessage(t.getMessage());
            }
        });
    }
}
