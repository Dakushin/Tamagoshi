package com.example.tamagoshi.Ecran4ListView;

import java.util.ArrayList;

public class Nouriture extends Object {
    private String m_nomnour;
    private int m_point;

    private static ArrayList<Nouriture> listobj;

    public Nouriture(String nom, int point){
        this.m_nomnour = nom;
        this.m_point = point;
    }

    public String getNom() {return m_nomnour;}
    public int getPts() {return m_point;}

    public static ArrayList<Nouriture> getListnrt(){
        if (listobj == null) {
            listobj = new ArrayList<Nouriture>();

            listobj.add(new Nouriture("Patés pour Tamagoshi", 6));
            listobj.add(new Nouriture("Un gros Tacos", 10));
	        listobj.add(new Nouriture("Glace", 8));
	        listobj.add(new Nouriture("Pate carbonara", 7));
	        listobj.add(new Nouriture("Pancakes", 6));
	        listobj.add(new Nouriture("Salade", 4));
	        listobj.add(new Nouriture("Pizza", 9));
	        listobj.add(new Nouriture("Lasagne", 12));
	        listobj.add(new Nouriture("Raclette", 15));
	        listobj.add(new Nouriture("Cacahuète", 1));
	        listobj.add(new Nouriture("Chips", 2));
	        listobj.add(new Nouriture("Hamburger", 8));
	        listobj.add(new Nouriture("Galette des rois", 13));
        }
        return listobj;
    }
}