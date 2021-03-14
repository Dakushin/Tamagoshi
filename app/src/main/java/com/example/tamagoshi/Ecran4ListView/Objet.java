package com.example.tamagoshi.Ecran4ListView;

import java.util.ArrayList;
import java.util.Random;

public class Objet extends Object {
    private String m_nomobj;
    private int m_point;
    private boolean m_rdm;

    private static ArrayList<Objet> listobj;

    public Objet(String nom, int point, boolean rdm){
        this.m_nomobj = nom;
        this.m_point = point;
        this.m_rdm = rdm;
    }

    public String getNom() {return m_nomobj;}
    public int getPts() {return m_point;}
    public boolean getRdm() {return m_rdm;}

    public static ArrayList<Objet> getListobj(){
        if (listobj == null) {
            listobj = new ArrayList<Objet>();

            Random random = new Random();
            listobj.add(new Objet("Os", 6, false));
            listobj.add(new Objet("Bombe Atomique", -10 -random.nextInt(10), true));
            listobj.add(new Objet("Gameboy", random.nextInt(10), true));
            listobj.add(new Objet("Figurine Pop", random.nextInt(3), true));
            listobj.add(new Objet("Peluche", 5 + random.nextInt(5), false));
            listobj.add(new Objet("Une feuille en papier", 3 - random.nextInt(7), false));


        }
        return listobj;
    }
}

