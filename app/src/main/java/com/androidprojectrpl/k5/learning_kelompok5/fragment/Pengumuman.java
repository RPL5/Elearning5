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
public class Pengumuman extends Fragment {

    public Pengumuman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /// Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_pengumuman, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
