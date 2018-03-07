package com.victor.bobby_000_.peak_mindmap;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;

import java.util.ArrayList;

/**
 * Created by bobby_000 on 05/03/2018.
 */
//this clas will deal with the radarchart

public class BottomSectionFragment extends Fragment {

    private RadarChart mRadarChart;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.bottom_layout_fragment,container,false);
        setRadarChart();
        return view;

    }

    void setRadarChart()
    {
        mRadarChart = (RadarChart) view.findViewById(R.id.radarchart);

        //creating three arraylist that will hold the value of the three different values you,age group and profession

        ArrayList< Entry> you = new ArrayList<>();
        you.add(new Entry(4f,0));
        you.add(new Entry(5f,3));
        you.add(new Entry(2f,2));
        you.add(new Entry(7f,3));
        you.add(new Entry(6f,4));
        you.add(new Entry(5f,3));

        ArrayList<Entry> age = new ArrayList<>();

        age.add(new Entry(4f,0));
        age.add(new Entry(5f,1));
        age.add(new Entry(6f,2));
        age.add(new Entry(3f,3));
        age.add(new Entry(4f,4));
        age.add(new Entry(8f,5));

        // ArrayList<Entry> profession = new ArrayList<>();

        //now need to create an object of radarset and pass entries as frist arguemnet since we are comparing two datasets we will use two dataset objects

        RadarDataSet dataset_you =new RadarDataSet(you,"YOU");
        RadarDataSet dataset_age =new RadarDataSet(age,"AGE");

        //set different clours for each

        dataset_age.setColor(Color.CYAN);
        dataset_you.setColor(Color.RED);

        //Use setDrawFilled() method of RadarDataSet object to set whether you want to filled the whole start-shaped data set with the specified color or not.

        dataset_age.setDrawFilled(true);
        dataset_you.setDrawFilled(true);

        //3.10 Creating an ArrayList to add the DataSet
        ArrayList <RadarDataSet> datasets = new ArrayList<>();

        datasets.add(dataset_age);
        datasets.add(dataset_you);


       /* ArrayList<Integer> labels = new ArrayList<>();

        labels.add(R.string.peak_brain_score);
        labels.add(R.string.memory);
        labels.add(R.string.problem_solving);
        labels.add(R.string.languages);
        labels.add(R.string.mental_agility);
        labels.add(R.string.focus); */

        ArrayList<String> labels = new ArrayList<>();

        labels.add("Peak Brain Score");
        labels.add("Memory");
        labels.add("Problem Solving");
        labels.add("Languages");
        labels.add("Mental Agility");
        labels.add("Focus");

        //Now create the object of RadarData and pass the comparison feature list and datasets as an argument

        RadarData data = new RadarData(labels,datasets);

        mRadarChart.setData(data); //the mradar chart now display the data
        //If you want to refresh the data set values use the invalidate() function of Radar Chart
        //mRadarChart.invalidate()

        //if you want to animate the chart run mRadarChart.animate()

        //mRadarChart.animate();
    }

}
