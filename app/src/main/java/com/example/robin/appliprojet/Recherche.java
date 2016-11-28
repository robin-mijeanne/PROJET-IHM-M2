package com.example.robin.appliprojet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import com.example.robin.appliprojet.casee.OnCaseClickListener;

public class Recherche extends AppCompatActivity {

    Spinner monSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
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

        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        monSpinner = (Spinner) findViewById(R.id.spinner);

        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List spinnerList = new ArrayList();
        spinnerList.add("Concert");
        spinnerList.add("Salle");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        monSpinner.setAdapter(adapter);

        final Button bt1 = (Button) findViewById(R.id.button);
        bt1.setEnabled(true);


        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(ResultRecherche.newIntent("jean michel", monSpinner.getSelectedItem().toString(), bt1.getContext()));
            }
        });

    }
}
