package com.example.android.android_me.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


/**
 * Created by Darren on 02/09/2017.
 */

public class BodyPartFragment extends Fragment {

    public BodyPartFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View is created and returned to the activity when called by the fragmentManager

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        //set initial view to first head in the headArray
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootView;
    }
}
