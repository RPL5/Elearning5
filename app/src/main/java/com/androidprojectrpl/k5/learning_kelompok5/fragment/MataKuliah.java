package com.androidprojectrpl.k5.learning_kelompok5.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidprojectrpl.k5.learning_kelompok5.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MataKuliah extends Fragment {

    String[] tahun = new String[]{"2011/2012","2012/2013","2013/2014","2014/2015","2015/2016","2016/2017","2017/2018","2018/2019"};


    public MataKuliah() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mata_kuliah, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
