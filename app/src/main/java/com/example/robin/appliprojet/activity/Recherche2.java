/**
 * Projet IHM
 *
 *
 * @description  Classe implémentant la vue Recherche de l'application
 * @seeheim Implémente la couche présentation et gestion du dialogue
 * .
 *
 *
 * @version 1.0
 * @author Robin Degironde
 * @author Charles Banquet
 * @class Recherche
 */

package com.example.robin.appliprojet.activity;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.robin.appliprojet.R;
import java.util.ArrayList;
import java.util.List;

public class Recherche2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner monSpinner;

    //Couche presentation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche2);
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
        this.setTitle("Recherche");

        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        monSpinner = (Spinner) findViewById(R.id.spinner);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List spinnerList = new ArrayList();
        spinnerList.add("Concert");
        spinnerList.add("Salle");
        spinnerList.add("Artiste");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        monSpinner.setAdapter(adapter);

        final Button bt1 = (Button) findViewById(R.id.button);
        bt1.setEnabled(true);

        final EditText saisie = (EditText) findViewById(R.id.editText2);

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(ResultRecherche2.newIntent(saisie.getText().toString(), monSpinner.getSelectedItem().toString(), bt1.getContext()));
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
        getMenuInflater().inflate(R.menu.recherche2, menu);
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
            Intent i = new Intent(Recherche2.this, Recherche2.class);
            startActivity(i);
        } else if (id == R.id.achats) {
            Intent i = new Intent(Recherche2.this, AchatsListe2.class);
            startActivity(i);

        } else if (id == R.id.favoris) {
            Intent i = new Intent(Recherche2.this, FavorisListe2.class);
            startActivity(i);
        } else if (id == R.id.parametres) {
            Intent i = new Intent(Recherche2.this, Parametres2.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
