package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


/**
 * Created by Darren on 04/09/2017.
 */

public class MasterListFragment extends Fragment {

    //need to have a constructor
    public  MasterListFragment (){

    }

    //must override the onCreateView method
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) root.findViewById(R.id.images_grid_view);// create a reference to gridView
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(adapter);

        return root;

    }
}
