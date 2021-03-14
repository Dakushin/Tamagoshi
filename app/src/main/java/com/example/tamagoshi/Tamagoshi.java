package com.example.tamagoshi;

import android.content.SharedPreferences;

import com.example.tamagoshi.Ecran2.Etat.Etat;
import com.example.tamagoshi.Ecran2.Etat.EtatFaim;
import com.example.tamagoshi.Ecran2.Etat.EtatHeureux;
import com.example.tamagoshi.Ecran2.Etat.EtatMort;
import com.example.tamagoshi.Ecran2.Etat.EtatTriste;

import java.util.Observable;
import java.util.Random;

public class Tamagoshi extends Observable {

    int m_hungry;
    int m_happyness;
    String m_name;
    String m_mastername;
    String m_msg;
    Etat m_etat;
    long timeleft;

    public Tamagoshi(){

        m_hungry = 0;
        m_happyness = 100;
        m_name = "";
        m_mastername = "";
        m_etat = new EtatHeureux();
    }

    public int getHungry(){
        return m_hungry;
    }

    public int getHappyness(){
        return m_happyness;
    }

    public void init(){
        m_hungry = 0;
        m_happyness = 100;
        m_name = "";
        m_mastername = "";
        m_etat = new EtatHeureux();
        setMsg("Vous avez bien réinitialisé votre Tamagoshi !");
        setChanged();
        notifyObservers();
    }

    public void GiveAffection() {
        Random random = new Random();
        int nb;
        nb = 1 + random.nextInt(4);
        m_happyness += nb;
        if(m_happyness > 100)
            m_happyness = 100;
        String s = "";
        switch(nb) {
            case 2: s = "Il lève la pâtes pour vous remerciez !"; break;
            case 3: s = "Il ronronne !"; break;
            case 4: s = "Il sourit !"; break;
            case 5: s = "Il vous regarde comme ça : *_*"; break;
        }
        setMsg(getMasterName() + " à caresser " + getName() + ". " + s);
        CheckEtat();
        setChanged();
        notifyObservers();

    }

    public void setName(String s){
        if(s.length() > 9)
        {
            setMsg("le noms de votre tamagoshi doit faire moins de 9 caractères");
        }else m_name = s;
    }
    public String getName() {return m_name;}
    public void setMasterName(String s) {
        if(s.length() > 9)
        {
            setMsg("le noms de votre tamagoshi doit faire moins de 9 caractères");
        }else m_mastername = s;
    }
    public String getMasterName() {return m_mastername;}

    public void setTimeleft(long tl) {timeleft = tl; }
    public long getTimeleft() {return timeleft;}
    public void setMsg(String x) {
        m_msg = x;
        setChanged();
        notifyObservers();}
    public String getMsg() {return m_msg;}
    public Etat getEtat() {return m_etat;}

    public void CheckEtat() {m_etat.etatsuivant(this);}
    public void ChangeEtat(String s){
        switch (s){
            case "Heureux": m_etat = new EtatHeureux(); break;
            case "Triste" : m_etat = new EtatTriste(); break;
            case "Faim" : m_etat = new EtatFaim(); break;
            case "Mort" : m_etat = new EtatMort(); break;
        }
        setChanged();
        notifyObservers();
    }

    public void setHungry(int hungry) {
        m_hungry = hungry;
        if(m_hungry < 0)
            m_hungry = 0;
        CheckEtat();
        setChanged();
        notifyObservers();
    }
    public void setHappyness(int happyness) {
        m_happyness = happyness;
        if(m_happyness > 100)
            m_happyness = 100;
        CheckEtat();
        setChanged();
        notifyObservers();
    }

}
