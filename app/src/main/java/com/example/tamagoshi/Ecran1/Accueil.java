package com.example.tamagoshi.Ecran1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tamagoshi.R;

public class Accueil extends LinearLayout {
    public Button m_buttonE2;
    public Button m_buttonE3;
    public AccueilCtrl m_refC;

    public Accueil(Context context, AccueilCtrl C)
    { super(context);

        m_refC = C;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        inflater.inflate(R.layout.ecran1, this);
        m_buttonE2 = (Button) findViewById(R.id.AllerEcran2);
        m_buttonE3 = (Button) findViewById(R.id.AllerEcran3);
        m_buttonE2.setOnClickListener(m_refC);
        m_buttonE3.setOnClickListener(m_refC);
    }
}
