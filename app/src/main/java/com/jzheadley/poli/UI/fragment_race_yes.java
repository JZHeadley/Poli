package com.jzheadley.poli.UI;

import com.google.gson.Gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jzheadley.poli.R;
import com.jzheadley.poli.base.BaseApplication;
import com.jzheadley.poli.network.PoliApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class fragment_race_yes extends AppCompatActivity {

    @Inject
    PoliApi api;
    @Inject
    Gson gson;
    private ArrayList<Integer> numYes;
    private ArrayList<String> races;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_race_yes);
        ((BaseApplication) getApplication()).getNetComponent().inject(this);
        races = new ArrayList<>();
        numYes = new ArrayList<>();
        getRaceYes("Black or African American");
        getRaceYes("prefer not to say");
        getRaceYes("Native Hawaiian or Other Pacific Islander");
    }

    private void setupPieChart() {
        Timber.v(Arrays.toString(races.toArray()));
        Timber.v(Arrays.toString(numYes.toArray()));
        // populating a list of pie entries:
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < numYes.toArray().length; i++) {
            pieEntries.add(new PieEntry(numYes.get(i), races.get(i)));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Yes percentage by Race");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        //get the chart
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();

    }

    public void getRaceYes(final String race) {
        api.getYesNoByRace(race)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        races.add(race);
                        numYes.add(gson.fromJson(s, yesno.class).yes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "WTF");
                        setupPieChart();

                    }

                    @Override
                    public void onComplete() {
                        Timber.v("Finished");
                        setupPieChart();
                    }
                });

    }


    class yesno {
        int yes;
        int no;
    }
}
