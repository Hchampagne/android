package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText mNom;
    private EditText mPrenom;
    private EditText mAge;

    private RadioButton mFemme;
    private RadioButton mHomme;
    private RadioGroup mGroupe;

    private Button mValider;

    boolean test = false;
    boolean test1 = false;
    boolean test2 = false;
    boolean test3 = false;
    boolean checked = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNom = findViewById(R.id.main_nom);
        mPrenom = findViewById(R.id.main_prenom);
        mAge = findViewById(R.id.main_age);

        mFemme = findViewById(R.id.main_femme);
        mHomme = findViewById(R.id.main_homme);

        mValider = findViewById(R.id.main_valider);

        mGroupe = findViewById(R.id.main_group);


        // désactive le bouton valider
        mValider.setEnabled(false);

        //champs nom
        mNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test1 = mNom.toString().length() > 1;
                test = test1 && test2 && test3;
                mValider.setEnabled(test);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //champs prénom
        mPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test2 = mPrenom.toString().length() > 1;
                test = test1 && test2 && test3;
                mValider.setEnabled(test);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //champs age
        mAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test3 = mAge.toString().length() > 1;
                test = test1 && test2 && test3;
                mValider.setEnabled(test);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mValider.setEnabled(test && checked);
    }

        public void onRadioButtonClicked(View view){
            // test si rdio maintenant clicked
            checked = ((RadioButton) view).isChecked();

            //




        }





}
