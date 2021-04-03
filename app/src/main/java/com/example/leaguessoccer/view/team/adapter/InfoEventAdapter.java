package com.example.leaguessoccer.view.team.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.database.entity.Event;
import com.example.leaguessoccer.database.entity.Team;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoEventAdapter extends RecyclerView.Adapter<InfoEventAdapter.ViewHolder> {
    private final List<Event> events;

    public InfoEventAdapter(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTeams().setText(events.get(position).getStrEvent());
        holder.getLeague().setText(events.get(position).getStrLeague());
        holder.getDate().setText(events.get(position).getDateEvent()+" "+events.get(position).getStrTime());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView teams;
        private final TextView league;
        private final TextView date;

        public ViewHolder(View view) {
            super(view);
            teams = view.findViewById(R.id.tv_teams);
            league = view.findViewById(R.id.tv_league);
            date = view.findViewById(R.id.tv_date);
        }

        public TextView getTeams() {
            return teams;
        }

        public TextView getLeague() {
            return league;
        }

        public TextView getDate() {
            return date;
        }
    }

    public void setDataAdapter(List<Event> events) {
        System.out.println(events.size());
        this.events.clear();
        this.events.addAll(events);
        notifyDataSetChanged();
    }
}
