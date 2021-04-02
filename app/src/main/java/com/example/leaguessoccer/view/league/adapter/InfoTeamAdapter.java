package com.example.leaguessoccer.view.league.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.models.Team;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoTeamAdapter extends RecyclerView.Adapter<InfoTeamAdapter.ViewHolder> {
    private final List<Team> teams;
    private IOnclickTeam onclickTeam;

    public InfoTeamAdapter(List<Team> teams, IOnclickTeam onclickTeam) {
        this.teams = teams;
        this.onclickTeam = onclickTeam;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextViewName().setText(teams.get(position).getStrAlternate());
        holder.getTextViewStadium().setText(teams.get(position).getStrStadium());
        Picasso.get()
                .load(teams.get(position).getStrTeamBadge())
                .error(R.drawable.imageno).into(holder.getImageViewBadge());
        holder.getCardViewTeam().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickTeam.onClickTeam(teams.get(position).getIdTeam());
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView stadium;
        private final ImageView badge;
        private final MaterialCardView team;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tv_name);
            stadium = view.findViewById(R.id.tv_stadium);
            badge = view.findViewById(R.id.iv_badge);
            team = view.findViewById(R.id.cv_team);
        }

        public TextView getTextViewName() {
            return name;
        }

        public TextView getTextViewStadium() {
            return stadium;
        }

        public ImageView getImageViewBadge() {
            return badge;
        }

        public MaterialCardView getCardViewTeam() {
            return team;
        }
    }

    public void setDataAdapter(List<Team> teams) {
        this.teams.clear();
        this.teams.addAll(teams);
        notifyDataSetChanged();
    }
}
