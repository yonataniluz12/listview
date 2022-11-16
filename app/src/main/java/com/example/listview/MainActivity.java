package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch sw;
    EditText eTN1,eTN2;
    double firstnum;
    double multipliermum;
    String str;
    Intent si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw = findViewById(R.id.sw);
        eTN1 = findViewById(R.id.eTN1);
        eTN2 = findViewById(R.id.eTN2);
        str = eTN1.getText().toString();
        while (str == ""){
            Toast.makeText(this,"Enter a first number", Toast.LENGTH_LONG);
        }
        firstnum = Double.parseDouble(str);
        str = eTN2.getText().toString();
        while (str == " "){
            Toast.makeText(this,"Enter a first number", Toast.LENGTH_LONG);
        }
        multipliermum = Double.parseDouble(str);
    }

    public void go(View view) {
        if (sw.isChecked()){
            sw.setText("arithmetical");
            si = new Intent(this,series_list.class);
            si.putExtra("n",firstnum);
            si.putExtra("nn",multipliermum);
            si.putExtra("nnn",1);
            startActivity(si);
        }
        else{
            sw.setText("geumtri");
            si = new Intent(this,series_list.class);
            si.putExtra("n",firstnum);
            si.putExtra("nn",multipliermum);
            si.putExtra("nnn",0);
            startActivity(si);
        }
    }

    public void next_activity(View view) {
        startActivity(si);
    }
}