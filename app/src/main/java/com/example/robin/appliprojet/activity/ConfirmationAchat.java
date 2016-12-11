/**
 * Projet IHM
 *
 *
 * @description  Classe implémentant la vue confirmation achats
 * @seeheim Implémente la couche présentation et gestion du dialogue
 * .
 *
 *
 * @version 1.0
 * @author Robin Degironde
 * @author Charles Banquet
 * @class accueil
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robin.appliprojet.R;
import com.example.robin.appliprojet.casee.Case;
import com.example.robin.appliprojet.data.Base;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationAchat extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String KEY_NOM = "album_cover";
    private static final String KEY_LIEU = "album_name";


    public static Intent newIntent(Case ma_case, Context context){
        Intent i = new Intent(context, ConfirmationAchat.class);
        i.putExtra(KEY_NOM, ma_case.getNom());
        i.putExtra(KEY_LIEU, ma_case.getText());
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Couche présentation

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_achat);
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

        //Generer fenetre
        this.setTitle("Confirmation achat");

        //Bouton
        final Button bt6 = (Button) findViewById(R.id.button6);
        bt6.setEnabled(true);

        //Recherche case
        Intent i = this.getIntent();
        final Case ma_case= new Base().rechercheConcert(i.getStringExtra(KEY_NOM.toString()));

        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        final Spinner monSpinner = (Spinner) findViewById(R.id.spinner);
        monSpinner.setEnabled(true);
        List spinnerList = new ArrayList();
        for (int c=1; c<=10; c++)
            spinnerList.add(c);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(adapter);

        //Image
        ((ImageView) findViewById(R.id.img)).setImageResource(ma_case.getImage());

        //Text
        ((TextView) findViewById(R.id.textView8)).setText(ma_case.getDescription());
        ((TextView) findViewById(R.id.textView12)).setText("Total: "+Integer.toString(ma_case.getPrix())+" €");

       monSpinner.setOnItemSelectedListener(
               new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                       ((TextView) findViewById(R.id.textView12)).setText("Total: "+ma_case.getPrix()*(Integer.parseInt(monSpinner.getSelectedItem().toString()))+" €");
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> adapterView) {

                   }
               }

       );

        bt6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Toast.makeText(bt6.getContext(), "Paiement de "+ma_case.getPrix()*(Integer.parseInt(monSpinner.getSelectedItem().toString()))+"€ OK", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.confirmation_achat, menu);
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
            Intent i = new Intent(ConfirmationAchat.this, Recherche2.class);
            startActivity(i);
        } else if (id == R.id.achats) {
            Intent i = new Intent(ConfirmationAchat.this, AchatsListe2.class);
            startActivity(i);

        } else if (id == R.id.favoris) {
            Intent i = new Intent(ConfirmationAchat.this, FavorisListe2.class);
            startActivity(i);
        } else if (id == R.id.parametres) {
            Intent i = new Intent(ConfirmationAchat.this, Parametres2.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
