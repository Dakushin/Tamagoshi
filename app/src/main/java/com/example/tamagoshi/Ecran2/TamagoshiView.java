package com.example.tamagoshi.Ecran2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagoshi.Ecran2.Etat.EtatFaim;
import com.example.tamagoshi.Ecran2.Etat.EtatHeureux;
import com.example.tamagoshi.Ecran2.Etat.EtatMort;
import com.example.tamagoshi.Ecran2.Etat.EtatTriste;
import com.example.tamagoshi.R;
import com.example.tamagoshi.Tamagoshi;

import java.util.Observable;
import java.util.Observer;

public class TamagoshiView extends LinearLayout implements Observer {

    public Button m_buttonE1;
    public Button m_buttonE3;
    public Button m_buttonGF;
    public Button m_buttonGA;
    public Button m_buttonP;
    public ImageView m_imageTama;
    public TextView m_TextHun;
    public TextView m_TextHap;
    public TextView m_TextInfo;
    public Tamagoshi m_refM;
    public Interaction m_refC;

    public TamagoshiView(Context context, Interaction C, Tamagoshi M){
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.ecran2, this);
        m_buttonE1 = (Button)findViewById(R.id.AllerEcran1);
        m_buttonE3 = (Button)findViewById(R.id.AllerEcran3);
        m_buttonGA = (Button)findViewById(R.id.Caresse);
        m_buttonGF = (Button)findViewById(R.id.Nourrir);
        m_buttonP = (Button)findViewById(R.id.Jouer);
        m_TextHap = (TextView)findViewById(R.id.textHappyness);
        m_TextHun = (TextView)findViewById(R.id.textHungry);
        m_TextInfo = (TextView)findViewById(R.id.textMessage);
        m_imageTama = (ImageView)findViewById(R.id.imageView);
        m_imageTama.setImageResource(R.drawable.image3);
        m_refC = C;
        m_refM = M;
        m_TextHap.setText(Integer.toString(m_refM.getHappyness()));
        m_TextHun.setText(Integer.toString(m_refM.getHungry()));
        m_buttonE1.setOnClickListener(C);
        m_buttonE3.setOnClickListener(C);
        m_buttonGA.setOnClickListener(C);
        m_buttonGF.setOnClickListener(C);
        m_buttonP.setOnClickListener(C);
    }

    @Override
    public void update(Observable observable, Object o){
        m_TextHap.setText(Integer.toString(m_refM.getHappyness()));
        m_TextHun.setText(Integer.toString(m_refM.getHungry()));

        if(m_refM.getEtat() instanceof EtatHeureux) {
            m_imageTama.setImageResource(R.drawable.image3);
        }
        if(m_refM.getEtat() instanceof EtatTriste) {
            m_imageTama.setImageResource(R.drawable.image0);
        }
        if(m_refM.getEtat() instanceof EtatFaim) {
            m_imageTama.setImageResource(R.drawable.image1);
        }
        if(m_refM.getEtat() instanceof EtatMort) {
            m_imageTama.setImageResource(R.drawable.image2);
        }
        m_TextInfo.setText(m_refM.getMsg());

        m_refC.getSave().saveData();



    }
}
