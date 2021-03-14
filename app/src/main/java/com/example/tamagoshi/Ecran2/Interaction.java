package com.example.tamagoshi.Ecran2;

import android.os.Handler;
import android.view.View;

import com.example.tamagoshi.Manager;
import com.example.tamagoshi.Tamagoshi;


public class Interaction implements View.OnClickListener {

    private Handler m_Handler = new Handler();
    private Sauvegarde m_save;
    private TamagoshiView m_refV;
    private Tamagoshi m_refMo;
    private Manager m_refMa;

    public Interaction(Tamagoshi Mo, Manager Ma){
    m_refMo = Mo;
    m_refMa = Ma;
    m_save = new Sauvegarde(Ma, Mo);
    m_save.loadData();
    m_Handler.postDelayed(mToastRunnable, 1000);
    Calcultimeleft();
    }
    public void setRefV(TamagoshiView V){m_refV = V; }

    public void onClick(View v) {
        if(v.getId() == m_refV.m_buttonE1.getId()){
            m_refMa.Ecran1();
        }
        if(v.getId() == m_refV.m_buttonE3.getId()){
            m_refMa.Ecran3();
        }
        if(v.getId() == m_refV.m_buttonP.getId()){
            m_refMa.EcranObjet();
        }
        if(v.getId() == m_refV.m_buttonGA.getId()){
            m_refMo.GiveAffection();
        }
        if(v.getId() == m_refV.m_buttonGF.getId()){
            m_refMa.EcranBouffe();
        }
    }

    void Calcultimeleft(){
        long time = System.currentTimeMillis() - m_refMo.getTimeleft();
        int heure = (int) (time / 3600000);
        if(heure > 0){
            m_refMo.setMsg("Tu es partie " + heure + "h ," + m_refMo.getName() + " il s'est ennuyé et son appetit se creuse" );
            m_refMo.setHungry(m_refMo.getHungry() + heure);
            m_refMo.setHappyness(m_refMo.getHappyness() - heure);
        }
    }

    public Sauvegarde getSave() {return m_save;}

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            int hungry = m_refMo.getHungry();
            int happyness = m_refMo.getHappyness();
            m_refMo.setHungry(hungry + 1);
            m_refMo.setHappyness(happyness - 1);
            m_Handler.postDelayed(this, 30000);
        }
    };


}
