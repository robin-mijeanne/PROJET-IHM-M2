package com.example.robin.appliprojet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.robin.appliprojet.casee.*;

import java.util.ArrayList;
import java.util.List;

public class ResultRecherche extends AppCompatActivity implements OnCaseClickListener {

    ListView myListView;
    private static final String KEY_RECHERCHE = "album_cover";
    private static final String KEY_TYPE = "album_name";
    private static final String KEY_AFFICHAGE = "affichage";

    public static Intent newIntent(String recherche, String type, Context context){
        Intent i = new Intent(context, ResultRecherche.class);
        i.putExtra(KEY_RECHERCHE, recherche);
        i.putExtra (KEY_TYPE, type);
        i.putExtra(KEY_AFFICHAGE,(type.equals("Concert")) ? "Concert: "+recherche : "Salle: " + recherche);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_recherche);
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

        Intent i = getIntent();
        myListView= (ListView) findViewById(R.id.list);
        List<Case> mesCases= genererCases();
        CaseAdapter adapter= new CaseAdapter(ResultRecherche.this, mesCases, this);
        myListView.setAdapter(adapter);

        ((TextView) findViewById(R.id.textView6)).setText(i.getStringExtra(KEY_AFFICHAGE.toString()));

    }

    private List<Case> genererCases()
    {
        List<Case> cases= new ArrayList<Case>();

        cases.add(new Case(R.drawable.yvettehorner, "Yvette Horner", "J\'adrore l\'accordeon"));
        cases.add(new Case(R.drawable.didiersuper, "Didier Super", "BouleyLand"));
        cases.add(new Case(R.drawable.jeanpaulandre, "Jean Paul Andre", "Golfech magazine"));
        cases.add(new Case(R.drawable.mlp, "M.L.P", "BrownieLand"));

        return cases;
    }

    @Override
    public void onCaseClick(Case ma_case) {
        //startActivity(DetailActivity.newIntent(ma_case, this));
    }

}
