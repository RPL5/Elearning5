package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidprojectrpl.k5.learning_kelompok5.fragment.Materi;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.PembimbingAkademik;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Tugas;
import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.adapter.ExpandableListAdapter;
import com.androidprojectrpl.k5.learning_kelompok5.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner Spintahun;
    private Spinner Spinsemester;
    private Spinner Spinmakul;
    private ArrayList<String> thnAjaran;
    private ArrayList<String> matakuliah;
    private ArrayList<String> matakuliah1;
    private ArrayList<String> matakuliah2;
    private ArrayList<String> matakuliah3;
    private ArrayList<String> matakuliah4;
    private ArrayList<String> matakuliah5;
    private ArrayList<String> matakuliah6;
    private ArrayList<String> semester;
    private String tahun,smster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        dataSpinner();
        Spintahun = (Spinner)navigationView.getMenu().findItem(R.id.nav_lang).getActionView();
        Spintahun.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,thnAjaran));
        Spintahun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = new PembimbingAkademik();

                tahun = String.valueOf(Spintahun.getSelectedItem());

                if (fragment != null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();

                    ft.replace(R.id.frame_container, fragment);

                    ft.commit();
                }
                //onBackPressed();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Spinsemester = (Spinner)navigationView.getMenu().findItem(R.id.nav_semester).getActionView();
        Spinmakul = (Spinner)navigationView.getMenu().findItem(R.id.nav_makul).getActionView();
        Spinsemester.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,semester));
        Spinsemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = new PembimbingAkademik();
                matakuliah = new ArrayList<String>();
                smster = String.valueOf(Spinsemester.getSelectedItem());

                if (tahun.contentEquals("2018/2019") && smster.contentEquals("Ganjil")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah1));
                }
                if (tahun.contentEquals("2018/2019") && smster.contentEquals("Genap")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah2));
                }
                if (tahun.contentEquals("2017/2018") && smster.contentEquals("Ganjil")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah3));
                }
                if (tahun.contentEquals("2017/2018") && smster.contentEquals("Genap")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah4));
                }
                if (tahun.contentEquals("2016/2017") && smster.contentEquals("Ganjil")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah5));
                }
                if (tahun.contentEquals("2016/2017") && smster.contentEquals("Genap")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah6));
                }
                if (tahun.contentEquals("2015/2016") && smster.contentEquals("Ganjil")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah4));
                }
                if (tahun.contentEquals("2015/2016") && smster.contentEquals("Genap")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah2));
                }
                if (tahun.contentEquals("2014/2015") && smster.contentEquals("Ganjil")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah5));
                }
                if (tahun.contentEquals("2014/2015") && smster.contentEquals("Genap")){
                    Spinmakul.setAdapter(new ArrayAdapter<String>(NavDrawer.this,android.R.layout.simple_spinner_dropdown_item,matakuliah3));
                }

                if (fragment != null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();

                    ft.replace(R.id.frame_container, fragment);

                    ft.commit();
                }
                //onBackPressed();

                Toast.makeText(NavDrawer.this,semester.get(position),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinmakul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NavDrawer.this,Spinmakul.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void dataSpinner() {
        thnAjaran = new ArrayList<String>();
        thnAjaran.add("2018/2019");
        thnAjaran.add("2017/2018");
        thnAjaran.add("2016/2017");
        thnAjaran.add("2015/2016");
        thnAjaran.add("2014/2015");

        semester = new ArrayList<String>();
        semester.add("Ganjil");
        semester.add("Genap");

        matakuliah1 = new ArrayList<>();
        matakuliah1.add("--pilih--");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");
        matakuliah1.add("KEcerdasan Buatan");

        matakuliah2 = new ArrayList<>();
        matakuliah2.add("--pilih--");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");
        matakuliah2.add("Basis data");

        matakuliah3 = new ArrayList<>();
        matakuliah3.add("--pilih--");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");
        matakuliah3.add("Sistem Informasi Manajemen");

        matakuliah4 = new ArrayList<>();
        matakuliah4.add("--pilih--");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");
        matakuliah4.add("Komputer Masyarakat");

        matakuliah5 = new ArrayList<String>();
        matakuliah5.add("--pilih--");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");
        matakuliah5.add("Metode Numerik");

        matakuliah6 = new ArrayList<String>();
        matakuliah6.add("--pilih--");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");
        matakuliah6.add("pemrograman web");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
            return true;
        //}

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pemAka) {
            // Handle the Pembimbing Akademik button

        } else if (id == R.id.nav_materi) {

        } else if (id == R.id.nav_pengumuman) {

        } else if (id == R.id.nav_tugas) {

        } else if (id == R.id.nav_quiz) {

        } else if (id == R.id.logout) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
