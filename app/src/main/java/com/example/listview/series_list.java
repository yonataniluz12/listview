package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    String[] series = new String[20];
    double firstnum ,sum, multipliermum;
    int seriesType;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        lV = findViewById(R.id.lV);
        Intent gi = getIntent();
        lV.setOnItemClickListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        firstnum = gi.getDoubleExtra("firstnum", -999.0);
        tV1.setText(firstnum + "");
        multipliermum = gi.getDoubleExtra("multipliermum ", -999.0);
        tV2.setText(multipliermum + "");
        seriesType = gi.getIntExtra("seriesType", -999);
        series[0] = firstnum +"";

        if(seriesType==0) {
            for (int i = 1; i < series.length; i++)
                series[i] = (firstnum + multipliermum * (i)) + "";
        }
        else{
            for (int i = 1; i < series.length; i++)
                series[i] = String.format("%s", (firstnum * Math.pow(multipliermum,i)));
        }
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, series);
        lV.setAdapter(adp);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tV3.setText(i + 1+ " ");
        if (seriesType==0){
            sum = ((2*firstnum +i*multipliermum)*(i+1))/2;
        }
        else{
            sum= firstnum* (((Math.pow(multipliermum,i+1))-1)/(multipliermum-1));
        }
        tV4.setText(String.format("%s", sum));
    }

    public void gooo(View view) {
        finish();
    }
}
