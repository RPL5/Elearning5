package com.androidprojectrpl.k5.learning_kelompok5.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.model.ClassUser;
import com.androidprojectrpl.k5.learning_kelompok5.view.main.segment.PembimbinganAkademikSegment;
import com.androidprojectrpl.k5.learning_kelompok5.view.main.segment.SegmentMainInterface;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PembimbingAkademik extends Fragment implements View.OnClickListener, SegmentMainInterface, PembimbinganAkademikSegment {

    private RecyclerView rvHome;


    public PembimbingAkademik() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pembimbing_akademik, container, false);
        rvHome = v.findViewById(R.id.rv_category);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHome.setItemAnimator(new DefaultItemAnimator());
        rvHome.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setData(@NotNull List<ClassUser> data) {

    }

    @Override
    public void onError(@NonNull String message) {

    }
}
