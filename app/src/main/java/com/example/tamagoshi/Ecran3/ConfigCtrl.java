package com.example.tamagoshi.Ecran3;

import android.media.MediaPlayer;
import android.view.View;

import com.example.tamagoshi.Manager;
import com.example.tamagoshi.R;
import com.example.tamagoshi.Tamagoshi;

public class ConfigCtrl implements View.OnClickListener{

    MediaPlayer player;
    Configuration m_refV;
    Manager m_refMa;
    Tamagoshi m_refMo;

    public ConfigCtrl(Tamagoshi Mo, Manager Ma) {
        m_refMa = Ma;
        m_refMo = Mo;

    }

    public void setRefV(Configuration V) {
        m_refV = V;
        play(V);
    }

    public void onClick(View v) {
        if(v.getId() == m_refV.m_buttonE2.getId()){
            m_refMa.Ecran2();
            m_refMo.setName(m_refV.m_ETtama.getText().toString());
            m_refMo.setMasterName(m_refV.m_ETpers.getText().toString());
        }
        if(v.getId() == m_refV.m_buttonE1.getId()){
            m_refMa.Ecran1();
            m_refMo.setName(m_refV.m_ETtama.getText().toString());
            m_refMo.setMasterName(m_refV.m_ETpers.getText().toString());

        }
        if(v.getId() == m_refV.m_buttonInit.getId()){
            m_refMo.init();
            m_refV.m_ETtama.setText("");
            m_refMo.setName(m_refV.m_ETtama.getText().toString());
            m_refV.m_ETpers.setText("");
            m_refMo.setMasterName(m_refV.m_ETpers.getText().toString());
        }
        if(v.getId() == m_refV.m_switch.getId()){
            boolean switchState = m_refV.m_switch.isChecked();
            if(switchState){
                play(m_refV);
            } else stop(m_refV);
        }
    }

    public void play(View v)
    {
        if (player == null){
            player = MediaPlayer.create(m_refMa.getActivity() , R.raw.song);
            player.setVolume(0.03f,0.03f);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void stop(View v) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
