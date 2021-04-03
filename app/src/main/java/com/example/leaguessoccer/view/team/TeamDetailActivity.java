package com.example.leaguessoccer.view.team;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leaguessoccer.R;
import com.example.leaguessoccer.database.entity.Event;
import com.example.leaguessoccer.database.entity.Team;
import com.example.leaguessoccer.interfaces.ITeamPresenter;
import com.example.leaguessoccer.interfaces.ITeamView;
import com.example.leaguessoccer.presenter.TeamPresenterImpl;
import com.example.leaguessoccer.view.team.adapter.InfoEventAdapter;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamDetailActivity extends AppCompatActivity implements ITeamView {

    private ITeamPresenter presenter;
    private FloatingActionButton btnFacebook, bntTwitter, btnInstagram, btnWebsite;
    private TextView tvDescription, tvName, tvYear;
    private ImageView ivBadge, ivJersey;
    private String idTeam = "";
    private FloatingActionsMenu floatingActionsMenu;
    private LinearLayout content;
    private ProgressDialog progressDialog;
    private RecyclerView rvEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        this.presenter = new TeamPresenterImpl(this, this);
        setupView();
        if (idTeam.isEmpty()) {
            idTeam = getIntent().getExtras().getString("idTeam");
        }
        presenter.getTeam(idTeam);
        presenter.getNextsEvent(idTeam);
    }

    private void setupView() {
        btnFacebook = findViewById(R.id.btn_facebook);
        bntTwitter = findViewById(R.id.btn_twitter);
        btnInstagram = findViewById(R.id.btn_instagram);
        btnWebsite = findViewById(R.id.btn_website);
        tvDescription = findViewById(R.id.tv_description);
        tvName = findViewById(R.id.tv_name);
        tvYear = findViewById(R.id.tv_year);
        ivBadge = findViewById(R.id.iv_badge);
        ivJersey = findViewById(R.id.iv_jersey);
        floatingActionsMenu = findViewById(R.id.menu_fab);
        content = findViewById(R.id.content);
        rvEvents = findViewById(R.id.rv_events);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Cargando...");
    }

    @Override
    public void showTeam(Team team) {
        tvName.setText(team.getStrAlternate());
        if (team.getStrFacebook() != null) {
            btnFacebook.setVisibility(View.VISIBLE);
            setupOnclik(team.getStrFacebook(), btnFacebook);
        } else {
            btnFacebook.setVisibility(View.GONE);
        }
        if (team.getStrTwitter() != null) {
            bntTwitter.setVisibility(View.VISIBLE);
            setupOnclik(team.getStrTwitter(), bntTwitter);
        } else {
            bntTwitter.setVisibility(View.GONE);
        }
        if (team.getStrInstagram() != null) {
            btnInstagram.setVisibility(View.VISIBLE);
            setupOnclik(team.getStrInstagram(), btnInstagram);
        } else {
            btnInstagram.setVisibility(View.GONE);
        }
        if (team.getStrWebsite() != null) {
            btnWebsite.setVisibility(View.VISIBLE);
            setupOnclik(team.getStrWebsite(), btnWebsite);
        } else {
            btnWebsite.setVisibility(View.GONE);
        }
        if (team.getStrDescriptionES() != null) {
            tvDescription.setText(team.getStrDescriptionES());
        } else if (team.getStrDescriptionEN() != null) {
            tvDescription.setText(team.getStrDescriptionEN());
        } else {
            tvDescription.setText("SIN DESCRIPCIÓN.");
        }
        tvYear.setText(team.getIntFormedYear());
        Picasso.get()
                .load(team.getStrTeamBadge())
                .error(R.drawable.imageno).into(ivBadge);
        Picasso.get()
                .load(team.getStrTeamJersey())
                .error(R.drawable.imageno).into(ivJersey);
        floatingActionsMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                content.setVisibility(View.VISIBLE);
            }

            @Override
            public void onMenuCollapsed() {
                content.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showNextsEvent(List<Event> events) {
        InfoEventAdapter adapter = new InfoEventAdapter(events);
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        rvEvents.setAdapter(adapter);
    }

    private void setupOnclik(String url, FloatingActionButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionsMenu.collapseImmediately();
                openBrowser(url);
            }
        });
    }

    private void openBrowser(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")){
            url = "https://" + url;
        }
        Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (openUrlIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openUrlIntent);
        } else {
            showToast("No se encontro un navegador disponible.");
        }
    }

    @Override
    public void initProgressBar() {
        cancelProgressBar();
        progressDialog.show();
    }

    @Override
    public void cancelProgressBar() {
        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    @Override
    public void showToast(String message) {
        cancelProgressBar();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}