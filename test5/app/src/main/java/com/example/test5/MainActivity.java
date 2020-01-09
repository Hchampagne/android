package com.example.test5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
    private Button btn1P;
    private Button btn2M;
    private Button btn2P;

    private int dPoids;
    private int dTaille;

    private double result ;
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
        btn1P = findViewById(R.id.btn1Plus);
        btn2M = findViewById(R.id.btn2Moins);
        btn2P = findViewById(R.id.btn2Plus);

        affPoids.setText("0" + " kg");
        affTaille.setText("50" + " cm");


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

        btn1M.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = poids.getProgress();
                a -= 1;
                if (a > 200) a = 200;
                poids.setProgress(a);
            }
        });

        btn1P.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int b = poids.getProgress();
                b += 1;
                if (b > 200) b = 200;
                poids.setProgress(b);
            }
        });

        btn2M.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = taille.getProgress();
                a -= 1;
                if (a > 200) a = 200;
                taille.setProgress(a);
            }
        });

        btn2P.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int b = taille.getProgress();
                b += 1;
                if (b > 200) b = 200;
                taille.setProgress(b);
            }
        });


    }

    public void calculImc(){

        double result = (double)dPoids / Math.pow((double)dTaille, 2.0)*10000 ;

        DecimalFormat f = new DecimalFormat("#.###");
        String imc =  f.format(result);

        //String essay = Integer.toString(dPoids);
        affImc.setTextSize(25);
        affImc.setText(imc);

        // message
        if ( result < 1){ mess = "" ;}
        else if (result < 16.5){mess = " Dénutrition ou anorexie";}
        else if ( result < 18.5){ mess = " Maigreur" ;}
        else if ( result < 25){ mess = "Poids normal" ;}
        else if ( result  <30){ mess = "Surpoids" ;}
        else if ( result  < 35){ mess = "Obesité modérée" ;}
        else if ( result  < 40){ mess = "Obésité sévère" ;}
        else{ mess = "Obésité morbide ou massive";}

        affMess.setTextSize(25);
        affMess.setText(mess);
    }
}
