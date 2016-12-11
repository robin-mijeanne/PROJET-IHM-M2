/**
 * Projet IHM
 *
 *
 * @description  Classe implémentant l'appovision et la garde en mémoire des données dans l'application
 * @seeheim Implémente la couche modele d interfacage
 * .
 *
 *
 * @version 1.0
 * @author Robin Degironde
 * @author Charles Banquet
 * @class ValuesSingleton
 */

package com.example.robin.appliprojet.data;

import com.example.robin.appliprojet.R;
import com.example.robin.appliprojet.casee.Case;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 09/12/16.
 */

public class ValuesSingleton {
    private static ValuesSingleton ourInstance = new ValuesSingleton();
    private static String TAG = "ValuesSingleton";

    public static ValuesSingleton getInstance() {
        return ourInstance;
    }

    private List<Case> artistes= new ArrayList<Case>();
    private List<Case> salles= new ArrayList<Case>();
    private List<Case> concerts= new ArrayList<Case>();
    private List<Case> favoris= new ArrayList<Case>();
    private List<Case> achats= new ArrayList<Case>();

    private ValuesSingleton()
    {
        this.artistes= new ArrayList<Case>();
        this.salles= new ArrayList<Case>();
        this.concerts= new ArrayList<Case>();
        this.favoris= new ArrayList<Case>();
        this.achats= new ArrayList<Case>();

        String description = new String("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        String avis=new String("consectetur adipiscing elit");

        List<String> liste_avis= new ArrayList<String>();
        liste_avis.add("Jean-Michel: "+avis);
        liste_avis.add("Farid: "+avis);
        liste_avis.add("Momo: "+avis);
        liste_avis.add("Mika: "+avis);

        artistes.add(new Case(R.drawable.yvettehorner, "Yvette Horner", "J\'adrore l\'accordeon", description));
        artistes.add(new Case(R.drawable.didiersuper, "Didier Super", "BouleyLand", description));
        artistes.add(new Case(R.drawable.jeanpaulandre, "Jean Paul Andre", "Golfech magazine", description));
        artistes.add(new Case(R.drawable.mlp, "M.L.P", "BrownieLand", description));

        concerts.add(new Case(R.drawable.yvettehorner, "Yvette Horner", "Le Bikini", description, 45));
        concerts.add(new Case(R.drawable.didiersuper, "Didier Super", "La Dynamo", description, 30));
        concerts.add(new Case(R.drawable.jeanpaulandre, "Jean Paul Andre", "Le Phare", description, 35));
        concerts.add(new Case(R.drawable.mlp, "M.L.P", "Le Bikini", description, 10));


        salles.add(new Case(R.drawable.bikini, "Le Bikini", "Ramonville Saint Agne", description, liste_avis));
        salles.add(new Case(R.drawable.dynamo, "La Dynamo", "Toulouse", description, liste_avis));
        salles.add(new Case(R.drawable.lephare, "Le Phare", "Toulouse", description, liste_avis));

        favoris.add(new Case(R.drawable.didiersuper, "Didier Super", "BouleyLand", description));
        favoris.add(new Case(R.drawable.jeanpaulandre, "Jean Paul Andre", "Golfech magazine", description));

        achats.add(new Case(R.drawable.didiersuper, "Didier Super", "La Dynamo", description, 30));
        achats.add(new Case(R.drawable.didiersuper, "Didier Super", "La Dynamo", description, 30));
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

    public List<Case> getAchats() { return achats; }

    public Case rechercheArtiste(String nom)
    {
        Case ma_case= this.artistes.get(0);

        for (Case tc : this.artistes)
        {
            if (tc.getNom().toLowerCase().equals(nom.toLowerCase()))
            {
                ma_case=tc;
            }
        }

        return ma_case;
    }

    public Case rechercheConcert(String nom)
    {
        Case ma_case= this.concerts.get(0);

        for (Case tc : this.concerts)
        {
            if (tc.getNom().toLowerCase().equals(nom.toLowerCase()))
            {
                ma_case=tc;
            }
        }

        return ma_case;
    }

    public Case rechercheSalle (String nom)
    {
        Case ma_case= this.salles.get(0);

        for (Case tc : this.salles)
        {
            if (tc.getNom().toLowerCase().equals(nom.toLowerCase()))
            {
                ma_case=tc;
            }
        }

        return ma_case;
    }

    public Case rechercheFavoris (String nom)
    {
        Case ma_case= this.favoris.get(0);

        for (Case tc : this.favoris)
        {
            if (tc.getNom().toLowerCase().equals(nom.toLowerCase()))
            {
                ma_case=tc;
            }
        }

        return ma_case;
    }
}
