package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calcul_Activity extends AppCompatActivity {

    private EditText cPoids;
    private EditText cTaille;
    private Button cCalcul;
    private TextView cresult;

    private double Taille;
    private  double Poids;
    private double result;

    private String mess;
    private boolean test1 = false;
    private boolean test2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_);
        // intent  de la MainActivity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //affhiche de intent de la MainActivity
        TextView calculIdent = findViewById(R.id.calcul_ident);
        calculIdent.setTextSize(30);
        calculIdent.setText(message);

        // liaison
        cPoids = findViewById(R.id.calcul_poids);
        cTaille = findViewById(R.id.calcul_taille);
        cCalcul = findViewById(R.id.calcul_calcul);

        //disable bouton calcul
        cCalcul.setEnabled(false);

        cPoids.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test1 = cPoids.toString().length() > 1; // 2 caractères mini
                cCalcul.setEnabled(test1 && test2);  // enable bouton calcul
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cTaille.addTextChangedListener(new TextWatcher() { // si modif champs
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test2 = cTaille.toString().length() > 1; // 2 caractères mini
                cCalcul.setEnabled(test1 && test2);  // enable bouton calcul
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

        // Calcul  IMC
        public void  afficheCalcul(View view) {
            //conversion des variables editText mTaille/mPoids => Taille/Poids double
            Taille = Double.parseDouble(cTaille.getText().toString());
            Poids = Double.parseDouble(cPoids.getText().toString());
            //calcul imc
            result = Poids / Math.pow(Taille, 2.0)*10000;

            //formatage de l'IMC et affichage
            DecimalFormat f = new DecimalFormat("#.###");
            String imc =  f.format(result);
            cresult = findViewById(R.id.calcul_r);
            cresult.setTextSize(25);
            cresult.setText(imc);

            // message
            if (result< 16.5){ mess = " Dénutrition ou anorexie" ;  }
            else if ( result< 18.5){ mess = " Maigreur" ;}
            else if ( result < 25){ mess = "Poids normal" ;}
            else if ( result <30){ mess = "Surpoids" ;}
            else if ( result < 35){ mess = "Obesité modérée" ;}
            else if ( result < 40){ mess = "Obésité sévère" ;}
            else{ mess = "Obésité morbide ou massive";}

            //affichage resultat dans textview display_result
            TextView textView = findViewById(R.id.calcul_cat);
            textView.setTextSize(25);
            textView.setText(mess);


        }

}
