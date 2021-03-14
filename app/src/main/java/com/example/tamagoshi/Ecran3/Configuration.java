package com.example.tamagoshi.Ecran3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Switch;

import com.example.tamagoshi.R;
import com.example.tamagoshi.Tamagoshi;

import java.util.Observable;
import java.util.Observer;

public class Configuration extends LinearLayout {
    Button m_buttonE1;
    Button m_buttonE2;
    Button m_buttonInit;
    EditText m_ETtama;
    EditText m_ETpers;
    ConfigCtrl m_refC;
    Tamagoshi m_refM;
    Switch m_switch;

    public Configuration(Context context, ConfigCtrl C, Tamagoshi M){
    super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.ecran3, this);
        m_refM = M;
        m_refC = C;
        m_buttonE2 = (Button) findViewById(R.id.AllerEcran2);
        m_buttonE1 = (Button) findViewById(R.id.AllerEcran1);
        m_buttonInit = (Button) findViewById(R.id.Init);
        m_ETtama = (EditText) findViewById(R.id.editTextTama);
        m_ETtama.setText(m_refM.getName());
        m_ETpers = (EditText) findViewById(R.id.editTextPersonName);
        m_ETpers.setText(m_refM.getMasterName());
        m_switch = findViewById(R.id.switch1);
        m_switch.setOnClickListener(m_refC);
        m_refM = M;
        m_refC = C;
        m_buttonE2.setOnClickListener(m_refC);
        m_buttonE1.setOnClickListener(m_refC);
        m_buttonInit.setOnClickListener(m_refC);

    }
}
