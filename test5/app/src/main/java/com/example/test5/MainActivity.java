package com.example.test5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar poids ;
    private SeekBar taille;

    private TextView affPoids;
    private TextView affTaille;
    private TextView affImc;
    private TextView affMess;

    private Button btn1M;

    private int dPoids;
    private int dTaille;
    private int progress;
    private double resultat ;
    private String mess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poids = findViewById(R.id.seekBarPoids);
        taille = findViewById(R.id.seekBarTaille);

        affPoids = findViewById(R.id.affiche_poids);
        affTaille = findViewById(R.id.affiche_taille);
        affImc = findViewById(R.id.affiche_imc);
        affMess = findViewById(R.id.afficheResult);

        btn1M = findViewById(R.id.btn1Moins);


        poids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                dPoids = progress;
                String p = Integer.toString(progress);
                affPoids.setText(p + " kg");
                calculImc();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        taille.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                dTaille = 50 + progress;
                String t = Integer.toString(dTaille);
                affTaille.setText(t + " cm");
                calculImc();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }
        public void decProgress(){

            progress = poids.getProgress();
            progress -= 1;

            if (progress < 0) {
                progress = 0;
            }
            poids.setProgress(progress);

        }





    public void calculImc(){

        double resultat = (double)dPoids / Math.pow((double)dTaille, 2.0)*10000 ;

        DecimalFormat f = new DecimalFormat("#.###");
        String imc =  f.format(resultat);

        //String essai = Integer.toString(dPoids);
        affImc.setTextSize(25);
        affImc.setText(imc);

        // message
        if ( resultat < 1){ mess = "" ;}
        else if (resultat < 16.5){mess = " Dénutrition ou anorexie";}
        else if ( resultat < 18.5){ mess = " Maigreur" ;}
        else if ( resultat < 25){ mess = "Poids normal" ;}
        else if ( resultat  <30){ mess = "Surpoids" ;}
        else if ( resultat  < 35){ mess = "Obesité modérée" ;}
        else if ( resultat  < 40){ mess = "Obésité sévère" ;}
        else{ mess = "Obésité morbide ou massive";}

        affMess.setTextSize(25);
        affMess.setText(mess);
    }
}
