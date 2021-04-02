package com.example.leaguessoccer.view.team.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.database.entity.Team;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoEventAdapter extends RecyclerView.Adapter<InfoEventAdapter.ViewHolder> {
    private final List<Team> teams;

    public InfoEventAdapter(List<Team> teams) {
        this.teams = teams;
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
        System.out.println(teams.size());
        this.teams.clear();
        this.teams.addAll(teams);
        notifyDataSetChanged();
    }
}
