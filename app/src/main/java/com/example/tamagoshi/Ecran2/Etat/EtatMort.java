package com.example.tamagoshi.Ecran2.Etat;

import com.example.tamagoshi.Tamagoshi;

public class EtatMort extends Etat{


    @Override
    public void etatsuivant(Tamagoshi M) {
        if(M.getHungry() > 50){
            M.ChangeEtat("Faim");
            M.setMsg(M.getName() + " commence à avoir faim");
        } else if(M.getHappyness() < 50) {
            M.setMsg(M.getName() + " est devenus triste");
            M.ChangeEtat("Triste");
        } else if(M.getHungry() >= 100 || M.getHappyness() <= 0){
            M.ChangeEtat("Mort");
        } else {M.ChangeEtat("Heureux");
        M.setMsg(M.getName() + " est devenus heureux");}

    }
}
