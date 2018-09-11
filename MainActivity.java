package com.example.ryad.nombresecret;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_1;
    private TextView tv1;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private boolean update = false;
    private boolean clicOperateur = false;
    private String operateur = "";
    private double chiffre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt_result);
        ed_1 = findViewById(R.id.ed_1);
        bt4 = findViewById(R.id.bt_4);


        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("10");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });




    }

    public void chiffreClick(String str) {
        if (update) {
            update = false;
        } else {
            if (!ed_1.getText().equals("0"))
                str = ed_1.getText() + str;
        }
        ed_1.setText(str);
    }

    public void divClick() {
        if (clicOperateur) {
            calcul();
            ed_1.setText(String.valueOf(bt1));
        } else {
            chiffre1 = Double.valueOf(ed_1.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    private void calcul() {
        if (operateur.equals("/")) {
            try {
                chiffre1 = chiffre1 / Double.valueOf(ed_1.getText().toString()).doubleValue();
                ed_1.setText(String.valueOf(chiffre1));
            } catch (ArithmeticException e) {
                ed_1.setText("0");
            }
        }
    }
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }
}


