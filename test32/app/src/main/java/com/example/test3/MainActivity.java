package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //def variables
    private EditText mNom;
    private EditText mPrenom;
    private EditText mTaille;
    private EditText mPoids;
    private Button mValide;
    private Button mCalcul;
    private Button mReset;
    //test champs prenom et nom
    private boolean test1 = false;
    private boolean test2 = false;

    public static final String EXTRA_MESSAGE = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Liaisons champs de saisie
        mNom = findViewById(R.id.main_nom);
        mPrenom = findViewById(R.id.main_prenom);
        mTaille = findViewById(R.id.main_taille);
        mPoids = findViewById(R.id.main_poids);

        //Liaison des boutons
        mValide = findViewById(R.id.main_valider);
        mCalcul = findViewById(R.id.main_calcul);
        mReset = findViewById(R.id.main_reset);

        //set disable boutons et champs au démarrage
        //champs
        mTaille.setEnabled(false);
        mPoids.setEnabled(false);
        //boutons
        mValide.setEnabled(false);
        mCalcul.setEnabled(false);

        mNom.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test1 = s.toString().length() > 1;
                mValide.setEnabled(test1 && test2);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                test2 = s.toString().length() > 1;
                mValide.setEnabled(test1 && test2);
            }
        });

    }
    public void setReset(View view){


    }

    public void setValide(View view){
        mTaille.setEnabled(true);
        mPoids.setEnabled(true);
        mCalcul.setEnabled(true);
    }

    public void sendResult(View view) {

        Intent intent = new Intent(this, DisplayResultActivity.class);

        //conversion des variables editText mTaille/mPoids => Taille/Poids double
        double Taille = Double.parseDouble(mTaille.getText().toString());
        double Poids = Double.parseDouble(mPoids.getText().toString());
        //calcul imc
        double result = Poids / Math.pow(Taille, 2.0);
        String imc =  String.valueOf(result);

        intent.putExtra(EXTRA_MESSAGE, imc);
        startActivity(intent);
    }
}

