package com.victor.bobby_000_.peak_mindmap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

/**
 * Created by bobby_000 on 05/03/2018.
 */
// whenever create a class that inherits a fragments  it needs to overide oncreateview; then you need to assign the view to the corresponding xml file in this case it's top_section_fragment

public class TopSectionFragment extends Fragment{

    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.top_section_fragment,container,false);
        setstate();
        return view;


    }


    void setstate(){

        MultiStateToggleButton mtsb = (MultiStateToggleButton) view.findViewById(R.id.mstb_multi_id);
        //mtsb.enableMultipleChoice(true);
        mtsb.setColorRes(R.color.toogle,R.color.Peak_grey); //background, text
        mtsb.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
               // Log.d("Value: ", String.valueOf(+ value));

                if(value==0){
                    Toast.makeText(getActivity(),
                            "return 1", Toast.LENGTH_LONG).show();

                }else if(value==1){
                    Toast.makeText(getActivity(),
                            "return 2", Toast.LENGTH_LONG).show();

                }
                else if(value ==2){
                    Toast.makeText(getActivity(),
                            "return 3", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
