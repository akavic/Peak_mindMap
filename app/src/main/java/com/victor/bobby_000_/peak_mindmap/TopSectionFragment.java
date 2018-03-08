package com.victor.bobby_000_.peak_mindmap;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by bobby_000 on 05/03/2018.
 */
// whenever create a class that inherits a fragments  it needs to overide oncreateview; then you need to assign the view to the corresponding xml file in this case it's top_section_fragment

public class TopSectionFragment extends Fragment{

    private View view;
    TopsectionListner mTopsectionListner; //need to instantiate the interface here so i set the implementation of the selectpos method

        //commuincate betwenn activites with interface

    public interface TopsectionListner{
        void selectpos(int pos);
        //pass the value of the the position selected to the mainactivity then it's passed to the second fragment which can then display which map to show

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //this method get's called whenever you attach the fragment to the activity
        try {
            mTopsectionListner =(TopsectionListner) getActivity();


        }catch (ClassCastException  e){
            throw new ClassCastException(getActivity().toString());

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.top_section_fragment,container,false);
        setfont();
        setstate();
        return view;


    }

    void setfont()
    {
        //jsut setting the fonts for the edit tesxt
        Typeface custom_font_gtlight=Typeface.createFromAsset(getActivity().getAssets(),"GothamSSm-Light.ttf");
        Typeface custom_font_gtmedium=Typeface.createFromAsset(getActivity().getAssets(),"GothamSSm-Medium.ttf");
        TextView peak_brainmap=(TextView) view.findViewById(R.id.peak_brainmap);
        TextView review_txt=(TextView) view.findViewById(R.id.review_txt);
        TextView reviewtxt_2=(TextView) view.findViewById(R.id.review_txt_2);
        TextView peak_brainmapscore=(TextView) view.findViewById(R.id.peakbrainscore);
        //being applied here
        peak_brainmap.setTypeface(custom_font_gtmedium);
        review_txt.setTypeface(custom_font_gtlight);
        reviewtxt_2.setTypeface(custom_font_gtlight);
        peak_brainmapscore.setTypeface(custom_font_gtlight);
    }


    void setstate(){
        //this function identifies which ioption has been clicked then the pos number is returned to the mainactvity which then transfers the info to the bottomsection fragment

        MultiStateToggleButton mtsb = (MultiStateToggleButton) view.findViewById(R.id.mstb_multi_id);
        //mtsb.enableMultipleChoice(true);
        mtsb.setColorRes(R.color.toogle,R.color.button_primary_color); //background, text
        mtsb.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
               // Log.d("Value: ", String.valueOf(+ value));

                if(value==0){
                    Toast.makeText(getActivity(),
                            "return 1", Toast.LENGTH_LONG).show();
                    //tell mainactivity that the option on pos 0 has been clicked
                    mTopsectionListner.selectpos(0);

                }else if(value==1){
                    Toast.makeText(getActivity(),
                            "return 2", Toast.LENGTH_LONG).show();
                    //tell mainactivity that the option on pos 1 has been clicked
                    mTopsectionListner.selectpos(1);


                }
                else if(value ==2){
                    Toast.makeText(getActivity(),
                            "return 3", Toast.LENGTH_LONG).show();
                    //tell mainactivity that the option on pos 0 has been clicked
                    mTopsectionListner.selectpos(2);


                }
            }
        });
    }


}
