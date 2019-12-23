package com.example.test5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar poids ;
    private SeekBar taille;

    private TextView affPoids;
    private TextView affTaille;
    private TextView affImc;

    private int dPoids;
    private int dTaille;
    private double resultat ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poids = findViewById(R.id.seekBarPoids);
        taille = findViewById(R.id.seekBarTaille);

        affPoids = findViewById(R.id.affiche_poids);
        affTaille = findViewById(R.id.affiche_taille);
        affImc = findViewById(R.id.affiche_imc);

        poids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                dPoids = progress;
                String p = Integer.toString(progress);
                affPoids.setText( p + " kg");
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
                affTaille.setText( t + " cm");
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

    public void calculImc(){

        double resultat = (double)dPoids / Math.pow((double)dTaille, 2.0)*10000 ;

        DecimalFormat f = new DecimalFormat("#.###");
        String imc =  f.format(resultat);

        String essai = Integer.toString(dPoids);
        affImc.setText(imc);
    }
}
