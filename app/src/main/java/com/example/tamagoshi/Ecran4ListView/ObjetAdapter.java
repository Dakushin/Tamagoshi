package com.example.tamagoshi.Ecran4ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tamagoshi.R;

import java.util.ArrayList;

public class ObjetAdapter extends ArrayAdapter<Object>
{
    Context context;
    private ArrayList<Object> objets;

    public ObjetAdapter(Context context, int layout, ArrayList<Object> obj) {
        super(context, layout, obj);
        this.context = context;
        this.objets = obj;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_objet, null);
        }
        Object o = objets.get(position);
        if (o != null) {
            TextView txt2 = (TextView) v.findViewById(R.id.textDeb);
            TextView txt3 = (TextView) v.findViewById(R.id.textFin);

            if (txt2 != null) {
                if(o instanceof Objet) {
                    txt2.setText(((Objet) o).getNom());
                }
                if(o instanceof Nouriture) {
                    txt2.setText(((Nouriture) o).getNom());
                }
            }
            if (txt3 != null) {
                if(o instanceof Objet) {
                    if (((Objet) o).getRdm()) {
                            txt3.setText("nombre de point : ?");
                    } else if (((Objet) o).getPts() <= 0) {
                        if (((Objet) o).getPts() == -1 || ((Objet) o).getPts() == 0) {
                            txt3.setText("Fait perdre : " + ((Objet) o).getPts() + "point");
                        } else txt3.setText("Fait perdre : " + ((Objet) o).getPts() + "points");
                    } else if (((Objet) o).getPts() == 1) {
                        txt3.setText("Fait gagner : " + ((Objet) o).getPts() + "point");
                    } else txt3.setText("Fait gagner : " + ((Objet) o).getPts() + "points");

                }
                if(o instanceof Nouriture) {
                    if (((Nouriture) o).getPts() <= 0) {
                        if (((Nouriture) o).getPts() == -1 || ((Nouriture) o).getPts() == 0) {
                            txt3.setText("Fait perdre : " + ((Nouriture) o).getPts() + "point");
                        } else txt3.setText("Fait perdre : " + ((Nouriture) o).getPts() + "points");
                    } else if (((Nouriture) o).getPts() == 1) {
                        txt3.setText("Fait gagner : " + ((Nouriture) o).getPts() + "point");
                    } else txt3.setText("Fait gagner : " + ((Nouriture) o).getPts() + "points");

                }
            }
        }
        return v;
    }
}

