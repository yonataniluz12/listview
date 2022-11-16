package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DecimalFormat;
public class series_list extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lV;
    TextView tV1, tV2, tV3, tV4;
    Intent gi = getIntent();
    String[] series = new String[20];
    double first;
    double multipliermum;
    int tru;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        lV = findViewById(R.id.lV);

        lV.setOnItemClickListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        double first = gi.getDoubleExtra("n", -999);
        tV1.setText(String.valueOf(first));
        double multipliermum = gi.getDoubleExtra("nn", -999);
        tV2.setText(String.valueOf(multipliermum));
        int tru = gi.getIntExtra("nnn", -999);
        series[0] = df.format(first);
        double math = first;
        if (tru == 1) {
            for (int i = 1; i < series.length; i++) {
                int num = 20;
                math = math + multipliermum;
                series[i] = df.format(math);
            }
        }
        else {
            for (int i = 1; i < series.length; i++) {
                double geometric = first * multipliermum;
                series[i] = df.format(geometric);
            }
        }
        ArrayAdapter <String> adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, series);
        lV.setAdapter(adp);
    }

    public static String giomit(double first, double multipliermum, int i) {
        double x = 0;
        for (int j = 1; j < i; j++) {
            x = multipliermum * j;
        }
        x = (first * (x - 1)) / multipliermum - 1;
        return df.format(x);

    }
    public static String invoice(double first, double multipliermum, int i){
        return df.format((multipliermum * (first + i)) / 2);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tV3.setText(i);
        if (tru == 1) {
            tV4.setText(invoice(first,multipliermum,i));
        } else {
            tV4.setText(giomit(first, multipliermum, i));
        }
    }

    public void gooo(View view) {
        finish();
    }
}