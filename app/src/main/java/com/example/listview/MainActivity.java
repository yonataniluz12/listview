package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch sw;
    EditText eTN1,eTN2;
    double firstnum;
    double multipliermum;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw = findViewById(R.id.sw);
        eTN1 = findViewById(R.id.eTN1);
        eTN2 = findViewById(R.id.eTN2);
        str = eTN1.getText().toString();
        firstnum = Double.parseDouble(str);
        str = eTN2.getText().toString();
        multipliermum = Double.parseDouble(str);
    }

    public void go(View view) {
        if (sw.isChecked()){
            sw.setText("arithmetical");
            Intent si = new Intent(this,series_list.class);
            si.putExtra("n",firstnum);
            si.putExtra("nn",multipliermum);
            si.putExtra("nnn",true);
        }
    }
}