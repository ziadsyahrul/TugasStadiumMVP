package com.ziadsyahrul.tugasrepositorypattern.UI.teams;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ziadsyahrul.tugasrepositorypattern.R;
import com.ziadsyahrul.tugasrepositorypattern.UI.detail.DetailTeamActivity;
import com.ziadsyahrul.tugasrepositorypattern.Utils.Constant;
import com.ziadsyahrul.tugasrepositorypattern.model.TeamsData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private final Context context;
    private final List<TeamsData> teamsDataList;


    public TeamsAdapter(Context context, List<TeamsData> teamsDataList) {
        this.context = context;
        this.teamsDataList = teamsDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_team, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TeamsData teamsData = teamsDataList.get(i);

        viewHolder.txtNameTeam.setText(teamsData.getStrStadium());
        Glide.with(context).load(teamsData.getStrStadiumThumb()).into(viewHolder.imgLogoTeam);
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp);
        Glide.with(context).load(teamsData.getStrStadiumThumb()).apply(options).into(viewHolder.imgLogoTeam);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailTeamActivity.class).putExtra(Constant.KEY_DATA, teamsData));
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
