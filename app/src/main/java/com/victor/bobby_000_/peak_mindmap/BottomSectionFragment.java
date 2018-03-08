package com.victor.bobby_000_.peak_mindmap;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private int setpos;
    private  ArrayList< Entry> data;
    private RadarDataSet dataset_;
    private  ArrayList<String> labels;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.bottom_layout_fragment,container,false);
        setRadarChart();
        return view;

    }

    public void setshapeoption(int pos){
        //postion of the map to be displayed is here e.g display you would be ==0...dipslay age group ==1 and profession would be equal to ==2
        setpos=pos;
        hasposchanged();
        Log.d("SETPOS1", String.valueOf(+setpos));
    }

    ArrayList<Entry> setdata()
    {
        //return the data for the position selected
        //creating an arraylist that will hold the value of the three different values you,age group and profession and return the one depending on which is clicked
        data= new ArrayList<>();
        if(setpos==0){
            data.add(new Entry(4f,0));
            data.add(new Entry(5f,3));
            data.add(new Entry(2f,2));
            data.add(new Entry(7f,3));
            data.add(new Entry(6f,4));
            data.add(new Entry(5f,3));
            return data;

        }else if(setpos==1)
        {
            data.add(new Entry(4f,0));
            data.add(new Entry(7f,1));
            data.add(new Entry(4f,2));
            data.add(new Entry(6f,3));
            data.add(new Entry(2f,4));
            data.add(new Entry(5f,5));

            return data;

        }else if(setpos==2){

            data.add(new Entry(6f,0));
            data.add(new Entry(3f,1));
            data.add(new Entry(2f,2));
            data.add(new Entry(5f,3));
            data.add(new Entry(1f,4));
            data.add(new Entry(9f,5));

            return data;

        }
       return  null;
    }
    public void setradarcolour(){
        //set different clours for each map
        if(setpos==0){
            dataset_.setColor(Color.CYAN);
        }else if (setpos==1){
            dataset_.setColor(Color.RED);
        }else if (setpos==2){
            dataset_.setColor(Color.GREEN);
        }

    }
    public void setlabels()
    {
        //set the labels of the graph
        labels.add("Peak Brain Score");
        labels.add("Memory");
        labels.add("Problem Solving");
        labels.add("Languages");
        labels.add("Mental Agility");
        labels.add("Focus");
    }
    void setRadarChart()
    {
        //this functions print the radar chart
        //If you want to refresh the data set values use the invalidate() function of Radar Chart
        //mRadarChart.invalidate()
        //if you want to animate the chart run mRadarChart.animate()
        //mRadarChart.animate();
        Log.d("SETPOS2", String.valueOf(+setpos));


        mRadarChart = (RadarChart) view.findViewById(R.id.radarchart);
        labels = new ArrayList<>();
        // the data stored inn here is the corresponding to the pos choice of the chooser
        ArrayList<Entry> datatodisplay = setdata();
       //

        //now need to create an object of radarset and pass entries
        dataset_ =new RadarDataSet(datatodisplay,"");
        setradarcolour(); //set the colour for each map
        //Use setDrawFilled() method of RadarDataSet object to set whether you want to filled the whole start-shaped data set with the specified color or not.
        dataset_.setDrawFilled(true);

        //3.10 Creating an ArrayList to add the DataSet
        ArrayList <RadarDataSet> datasetstore = new ArrayList<>();
        datasetstore.add(dataset_); //data is stored ub datastore
        setlabels(); //labels for the radar chart is set
        //Now create the object of RadarData and pass the data to it anlong with the label
        RadarData data = new RadarData(labels,datasetstore);
        mRadarChart.setTouchEnabled(false); //stop user from being able to click chart

        mRadarChart.setData(data); //the mradar chart now display the data
        Log.d("SETPOS3", String.valueOf(+setpos));


    }
    void hasposchanged(){
        //redraw if pos has changed by checking the current pos vs the old one then redraw chart
        int tmp=0;
        if(tmp!=setpos)
        {
             tmp=setpos;
            setRadarChart();
        }
        if(tmp==setpos)
        {
            //do nothing
        }
    }


}
