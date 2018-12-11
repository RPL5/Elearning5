package com.androidprojectrpl.k5.learning_kelompok5.fragment;


import android.content.Intent;
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
import android.widget.Toast;

import com.androidprojectrpl.k5.learning_kelompok5.Data.DataPost;
import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.adapter.ItemClickSupport;
import com.androidprojectrpl.k5.learning_kelompok5.adapter.ListAdapter;
import com.androidprojectrpl.k5.learning_kelompok5.view.DetailActivity;
import com.androidprojectrpl.k5.learning_kelompok5.view.PostModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Quiz extends Fragment {
    private RecyclerView rvQuiz;
    private ArrayList<PostModel> list = new ArrayList<>();
    ListAdapter mAdapter;


    public Quiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /// Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);
        rvQuiz = (RecyclerView) v.findViewById(R.id.rv_Quiz);
        //rvCategory.setHasFixedSize(true);


        list.addAll(DataPost.getListDataQuiz());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvQuiz.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvQuiz.setItemAnimator(new DefaultItemAnimator());
        rvQuiz.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        mAdapter=new ListAdapter(getActivity());

        mAdapter.setListDosen(list);
        rvQuiz.setAdapter(mAdapter);


        return v;
    }

    private void showSelectedItem(PostModel postModel){
        Toast.makeText(getActivity(), "Kamu memilih "+ postModel.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(),DetailActivity.class);
        intent.putExtra("name", postModel.getName());
        intent.putExtra("status", postModel.getStatus());
        intent.putExtra("gelar", postModel.getRemarks());
        intent.putExtra("photo", postModel.getPhotos());
        intent.putExtra("title", postModel.getTitle());
        intent.putExtra("time", postModel.getTime());
        getContext().startActivity(intent);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemClickSupport.addTo(rvQuiz).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(list.get(position));
            }
        });
    }
}
