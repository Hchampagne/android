package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {

    private String resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        // Récupère les infos intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        double imc = Double.parseDouble(message);

        if (imc < 16.5){ resultat = " Dénutrition ou anorexie" ;}
        else if ( imc < 18.5){ resultat = " Maigreur" ;}
        else if ( imc < 25){ resultat = "Poids normal" ;}
        else if ( imc <30){ resultat = "Surpoids" ;}
        else if ( imc < 35){ resultat = "Obesité modérée" ;}
        else if ( imc < 40){ resultat = "Obésité sévère" ;}
        else{ resultat = "Obésité morbide ou massive";}

        //affichage resultat dans textview display_result
        TextView textView = findViewById(R.id.display_result);
        textView.setText(resultat);
    }
}
