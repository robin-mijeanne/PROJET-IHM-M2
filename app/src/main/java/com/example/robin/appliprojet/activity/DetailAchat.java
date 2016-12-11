/**
 * Projet IHM
 *
 *
 * @description  Classe implémentant la vue DetailAchat de l'application
 * @seeheim Implémente la couche présentation et gestion du dialogue
 * .
 *
 *
 * @version 1.0
 * @author Robin Degironde
 * @author Charles Banquet
 * @class DetailAchat
 */


package com.example.robin.appliprojet.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robin.appliprojet.R;
import com.example.robin.appliprojet.casee.Case;
import com.example.robin.appliprojet.data.Base;

public class DetailAchat extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String KEY_NOM = "album_cover";
    private static final String KEY_LIEU = "album_name";


    public static Intent newIntent(Case ma_case, Context context){
        Intent i = new Intent(context, DetailAchat.class);
        i.putExtra(KEY_NOM, ma_case.getNom());
        i.putExtra(KEY_LIEU, ma_case.getText());
        return i;
    }
    @Override
    //Couche presentation
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_achat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Couche gestion du dialogue
        //Fenetre
        this.setTitle("Detail Achat");

        //Boutons
        final Button bt4 = (Button) findViewById(R.id.button4);
        bt4.setEnabled(true);
        final Button bt5 = (Button) findViewById(R.id.button5);
        bt5.setEnabled(true);

        //Recherche case
        Intent i = this.getIntent();
        final Base base=new Base();
        final Case ma_case= base.rechercheConcert(i.getStringExtra(KEY_NOM.toString()));

        //Image
        ((ImageView) findViewById(R.id.img)).setImageResource(ma_case.getImage());

        //Text
        ((TextView) findViewById(R.id.textView8)).setText(ma_case.getDescription());
        ((TextView) findViewById(R.id.textView10)).setText(ma_case.getText());

        bt5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                base.getAchats().remove(0);
                Toast.makeText(bt5.getContext(), "Achat Annulé", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DetailAchat.this, AchatsListe2.class);
                startActivity(i);

            }
        });
        bt4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(ConfirmationDon.newIntent(ma_case, bt4.getContext()));
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_achat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.recherche) {
            Intent i = new Intent(DetailAchat.this, Recherche2.class);
            startActivity(i);
        } else if (id == R.id.achats) {
            Intent i = new Intent(DetailAchat.this, AchatsListe2.class);
            startActivity(i);

        } else if (id == R.id.favoris) {
            Intent i = new Intent(DetailAchat.this, FavorisListe2.class);
            startActivity(i);
        } else if (id == R.id.parametres) {
            Intent i = new Intent(DetailAchat.this, Parametres2.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
