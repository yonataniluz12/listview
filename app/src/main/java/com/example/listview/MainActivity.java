package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rB1,rB2;
    EditText eTN1,eTN2;
    double firstnum;
    double multipliermum;
    Intent si;
    Button btn1;
    int seriesType = -1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        si = new Intent(this, series_list.class);
        rB1 = findViewById(R.id.rB1);
        rB2 = findViewById(R.id.rB2);
        eTN1 = findViewById(R.id.eTN1);
        eTN2 = findViewById(R.id.eTN2);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            if (rB1.isChecked()) seriesType=0;

            else if(rB2.isChecked()) seriesType=1;

            if (seriesType==-1)
                Toast.makeText(MainActivity.this, "You must chose the series type", Toast.LENGTH_LONG).show();

            else if(inputOk()){
                si.putExtra(" multipliermum", multipliermum);
                si.putExtra("firstnum",firstnum);
                si.putExtra("seriesType", seriesType);
                startActivity(si);
            }
        });

    }
    public boolean inputOk() {
        String st = eTN1.getText().toString();
        if (st.matches("-?\\d+(\\.\\d+)?")) {
            firstnum = Double.parseDouble(st);
            st = eTN2.getText().toString();
            if (st.matches("-?\\d+(\\.\\d+)?")) {
                multipliermum = Double.parseDouble(st);
                return true;
            } else {
                eTN2.setText("");
                Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        else {
            eTN1.setText("");
            Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}