package com.example.tamagoshi.Ecran4ListView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.tamagoshi.Manager;
import com.example.tamagoshi.R;

import java.util.ArrayList;

public class ListViewClass extends LinearLayout {
    private ListView m_liste;
    private ObjetAdapter m_adapterobj;
    private CellClicCtrl m_clicCtrl;
    private Manager m_M;

    public ListViewClass(Manager M, Context context, ArrayList<Object> listobj) {
        super(context);
        m_M = M;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        inflater.inflate(R.layout.ecranobjet, this);
        m_adapterobj = new ObjetAdapter(context, R.layout.list_objet, listobj);
        m_liste = findViewById(R.id.list);
        m_liste.setAdapter(m_adapterobj);
        m_clicCtrl = new CellClicCtrl(m_M);
        m_liste.setOnItemClickListener((m_clicCtrl));
    }


}
