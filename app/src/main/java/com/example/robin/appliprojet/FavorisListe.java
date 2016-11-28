package com.example.robin.appliprojet;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FavorisListe extends AppCompatActivity {


    public static Intent newIntent(Context context){
        Intent i = new Intent(context, ListActivity.class);
        return i;
    }

    String[] noms_onglets= new String[] {"ABC", "DEF", "GHI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris_liste);

        ListView listview= (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noms_onglets);
        listview.setAdapter(adapter);
    }

}
