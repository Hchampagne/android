package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mtextView;
    private EditText mPrenom;
    private EditText mNom;
    private Button mAction;
    private Button mReset;
    private Button mValide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextView = (TextView) findViewById(R.id.textView);
        mPrenom = (EditText) findViewById(R.id.prenom);
        mNom = (EditText) findViewById(R.id.nom);

        mAction = (Button) findViewById(R.id.action);
        mReset = (Button) findViewById(R.id.reset);
        mValide = (Button) findViewById(R.id.valide);

        mAction.setEnabled(false);
        mReset.setEnabled(false);
        mValide.setEnabled(false);
        //mtextView.setText("");

        mPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mValide.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mValide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAction.setEnabled(true);
            }
        });

        mAction.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //just clic
                mtextView.setTextColor(Color.RED);
                mtextView.setText("Bonjour : "+ mNom.getText() + "  " + mPrenom.getText());
                mAction.setEnabled(false);
                mReset.setEnabled(true);
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrenom.setText("");
                mNom.setText("");
                mtextView.setText("");
                mAction.setEnabled(false);
                mReset.setEnabled(false);
            }
        });

    }
}