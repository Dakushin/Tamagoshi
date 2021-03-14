package com.example.tamagoshi.Ecran2;

import android.content.SharedPreferences;

import com.example.tamagoshi.Manager;
import com.example.tamagoshi.Tamagoshi;

import static android.content.Context.MODE_PRIVATE;

public class Sauvegarde {

    public static final String SHARED_PREFS = "sharedPrefs";
    private Manager m_Ma;
    private Tamagoshi m_Mo;

    Sauvegarde(Manager Ma, Tamagoshi Mo)
    {
        m_Ma = Ma;
        m_Mo = Mo;
    }
    void saveData(){
        SharedPreferences sharedPreferences = m_Ma.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", m_Mo.getName());
        editor.putString("mastername", m_Mo.getMasterName());
        editor.putInt("happyness", m_Mo.getHappyness());
        editor.putInt("hungry", m_Mo.getHungry());
        editor.putLong("lasttimesave", System.currentTimeMillis());

        editor.apply();
        editor.commit();
    }

    void loadData(){
        SharedPreferences sharedPreferences = m_Ma.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        m_Mo.setName(sharedPreferences.getString("name", " "));
        m_Mo.setMasterName(sharedPreferences.getString("mastername", " "));
        m_Mo.setHappyness(sharedPreferences.getInt("happyness", 100));
        m_Mo.setHungry(sharedPreferences.getInt("hungry", 0));
        m_Mo.setTimeleft(sharedPreferences.getLong("lasttimesave", System.currentTimeMillis()));
    }
}
