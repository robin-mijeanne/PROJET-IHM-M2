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
import android.widget.ListView;
import android.widget.TextView;

import com.example.robin.appliprojet.MainActivity;
import com.example.robin.appliprojet.R;
import com.example.robin.appliprojet.ResultRecherche;
import com.example.robin.appliprojet.casee.Case;
import com.example.robin.appliprojet.casee.CaseAdapter;
import com.example.robin.appliprojet.casee.OnCaseClickListener;
import com.example.robin.appliprojet.data.Base;

import java.util.List;

public class ResultRecherche2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnCaseClickListener {

    ListView myListView;
    private static final String KEY_RECHERCHE = "album_cover";
    private static final String KEY_TYPE = "album_name";
    private static final String KEY_AFFICHAGE = "affichage";


    public static Intent newIntent(String recherche, String type, Context context){
        Intent i = new Intent(context, ResultRecherche2.class);
        i.putExtra(KEY_RECHERCHE, recherche);
        i.putExtra (KEY_TYPE, type);
        i.putExtra(KEY_AFFICHAGE,("Mots clés: "+recherche));;
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_recherche2);
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

        Intent i = getIntent();
        String type= new String(i.getStringExtra(KEY_TYPE.toString()));
        type=type.toLowerCase();

        this.setTitle("Recherche "+type+"s");

        myListView = (ListView) findViewById(R.id.list);
        List<Case> mesCases;
        if (type.equals("concert"))
        {
            mesCases = new Base().getConcerts();
        }
        else
        {
            if (type.equals("salle"))
            {
                mesCases = new Base().getSalles();
            }
            else
            {
                mesCases= new Base().getArtistes();
            }
        }
        CaseAdapter adapter = new CaseAdapter(ResultRecherche2.this, mesCases, this);
        myListView.setAdapter(adapter);

        ((TextView) findViewById(R.id.textView6)).setText(i.getStringExtra(KEY_AFFICHAGE.toString()));
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
        getMenuInflater().inflate(R.menu.result_recherche2, menu);
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
            Intent i = new Intent(ResultRecherche2.this, Recherche2.class);
            startActivity(i);
        } else if (id == R.id.achats) {
            Intent i = new Intent(ResultRecherche2.this, AchatsListe2.class);
            startActivity(i);

        } else if (id == R.id.favoris) {
            Intent i = new Intent(ResultRecherche2.this, FavorisListe2.class);
            startActivity(i);
        } else if (id == R.id.parametres) {
            Intent i = new Intent(ResultRecherche2.this, Parametres2.class);
            startActivity(i);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onCaseClick(Case ma_case) {
        Intent i = getIntent();
        if (i.getStringExtra(KEY_TYPE.toString()).toLowerCase().equals("concert"))
        {

        }
        else
        {
            if (i.getStringExtra(KEY_TYPE.toString()).toLowerCase().equals("artiste"))
            {
                startActivity(DetailArtiste.newIntent(ma_case, this));
            }
            else
            {
                startActivity(DetailSalle.newIntent(ma_case, this));
            }
        }
    }
}
