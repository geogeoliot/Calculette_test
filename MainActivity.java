package com.cours.liotg.nombresecret;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //initialisation des attributs de la classe à NULL
    private EditText ed_number1;
    private EditText ed_number2;
    private Button bt_addition;
    private TextView lb_result;
    private Button bt_clear;

    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // instancie les objets

        // initialisation aux objets de l'écran (après setContentView)

        ed_number1= (EditText) findViewById(R.id.ed_number1);      // R. = arborescence de res donc des ed_ etc
        ed_number2= (EditText) findViewById(R.id.ed_number2);
        bt_addition= (Button) findViewById(R.id.bt_addition);
        lb_result= (TextView) findViewById(R.id.lb_result);
        bt_clear= (Button) findViewById(R.id.bt_clear);

        final View.OnClickListener bt_additionListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Log.i("DEBUG","Bouton clické");

                result= Integer.parseInt(String.valueOf(ed_number1.getText())) + Integer.parseInt(String.valueOf(ed_number2.getText()));
                lb_result.setText(String.valueOf(result));
            }
        };

        final View.OnClickListener bt_clearListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed_number1.setText(null);
                ed_number2.setText(null);
                lb_result.setText(null);



            }
        };
        bt_addition.setOnClickListener(bt_additionListener);
        bt_clear.setOnClickListener(bt_clearListener);



        init();






    }
    private void init() {

    }
}
