package com.victor.bobby_000_.peak_mindmap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bobby_000 on 07/03/2018.
 */

public class ShareSectionFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.share_layout_fragment,container,false);
        return view;
    }
}
