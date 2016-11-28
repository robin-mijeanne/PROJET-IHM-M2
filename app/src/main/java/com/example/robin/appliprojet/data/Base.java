package com.example.robin.appliprojet.data;

import java.util.ArrayList;
import java.util.List;

import com.example.robin.appliprojet.R;
import com.example.robin.appliprojet.casee.Case;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by robin on 28/11/16.
 */

public class Base {
    private List<Case> artistes= new ArrayList<Case>();
    private List<Case> salles= new ArrayList<Case>();
    private List<Case> concerts= new ArrayList<Case>();
    private List<Case> favoris= new ArrayList<Case>();

    public Base()
    {
        this.artistes= new ArrayList<Case>();
        this.salles= new ArrayList<Case>();
        this.concerts= new ArrayList<Case>();
        this.favoris= new ArrayList<Case>();

        artistes.add(new Case(R.drawable.yvettehorner, "Yvette Horner", "J\'adrore l\'accordeon"));
        artistes.add(new Case(R.drawable.didiersuper, "Didier Super", "BouleyLand"));
        artistes.add(new Case(R.drawable.jeanpaulandre, "Jean Paul Andre", "Golfech magazine"));
        artistes.add(new Case(R.drawable.mlp, "M.L.P", "BrownieLand"));
    }

    public List<Case> getArtistes()
    {
        return artistes;
    }

    public List<Case> getConcerts() {
        return concerts;
    }

    public List<Case> getFavoris() {
        return favoris;
    }

    public List<Case> getSalles() {
        return salles;
    }
}
