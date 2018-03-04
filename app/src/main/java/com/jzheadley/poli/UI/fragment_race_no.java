package com.jzheadley.poli.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jzheadley.poli.R;

import java.util.ArrayList;
import java.util.List;


public class fragment_race_no extends AppCompatActivity {

        float rainfall[]= {98.8f, 123.8f, 161.6f, 24.2f, 52f, 58.2f, 35.4f, 13.8f, 78f, 203f, 240.2f, 159.7f};
        String monthNames[]= {"Jan", "Feb", "Mar", "Apr", "May","Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_fragment_race_no);


                 setupPieChart();
                 }

private void setupPieChart() {
    // populating a list of pie entries:
    List<PieEntry> pieEntries = new ArrayList<>();
    for (int i = 0; i < rainfall.length; i++)
    {
        pieEntries.add(new PieEntry(rainfall[i], monthNames[i]));
    }

    PieDataSet dataSet = new PieDataSet(pieEntries, "RainFall for Vancouver");
    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
    PieData data = new PieData(dataSet);

    //get the chart

    PieChart chart = (PieChart) findViewById(R.id.chart);
    chart.setData(data);
    chart.animateY(1000);
    chart.invalidate();

                                }



        }
