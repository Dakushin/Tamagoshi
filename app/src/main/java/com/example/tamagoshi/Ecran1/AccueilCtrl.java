package com.example.tamagoshi.Ecran1;

import android.view.View;

import com.example.tamagoshi.Manager;

public class AccueilCtrl implements View.OnClickListener{

    public Accueil m_refV;
    private Manager m_refM;
    public void setRefV(Accueil V){m_refV = V;}
    public AccueilCtrl(Manager M){
        m_refM = M;
    }

    @Override
    public void onClick(View v){
        if(v.getId() == m_refV.m_buttonE2.getId()){
            m_refM.Ecran2();
        }
        if(v.getId() == m_refV.m_buttonE3.getId()){
            m_refM.Ecran3();
        }
    }

}
