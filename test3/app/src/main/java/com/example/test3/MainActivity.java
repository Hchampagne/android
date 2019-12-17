package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;




public class MainActivity extends AppCompatActivity {

    //def constante variable pour trans entre deux pages
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void sendMessage(View view){
            //Un Intent est un objet qui fournit une liaison d'exécution entre des composants distincts,
            //tels que deux activités. L'Intent représente l'intention d'une application de faire quelque chose.
            //Vous pouvez utiliser des intentions pour une grande variété de tâches, mais dans cette leçon,
            //votre intention démarre une autre activité.
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            // lie variable message à l'edittext edit_message
            EditText edit_message =  findViewById(R.id.edit_message);
            String message = edit_message.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            //lance DisplayMessageActivity
            startActivity(intent);
        }



}

