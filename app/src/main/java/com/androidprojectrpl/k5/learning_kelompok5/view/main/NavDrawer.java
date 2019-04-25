package com.androidprojectrpl.k5.learning_kelompok5.view.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.MataKuliah;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Materi;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.PembimbingAkademik;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Pengumuman;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Quiz;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Tugas;
import com.androidprojectrpl.k5.learning_kelompok5.model.ClassUser;
import com.androidprojectrpl.k5.learning_kelompok5.model.User;
import com.androidprojectrpl.k5.learning_kelompok5.utils.Constant;
import com.androidprojectrpl.k5.learning_kelompok5.view.login.LoginActivity;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private Spinner Spinmakul;
    private ArrayList<ClassUser> mataKuliah;
    private String pilih;
    private TextView nim, namaMhs;
    private MainPresenter presenter;
    private ImageView profile;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        prefs = getSharedPreferences(Constant.PREFERENCES,MODE_PRIVATE);
        presenter = new MainPresenter(this);
        presenter.getUser(prefs.getString("id",""));
        presenter.getClass(prefs.getString("id",""));
        setNavigationView();
        setFloatActionButton();
    }

    private void setNavigationView(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        @SuppressLint("CutPasteId")
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);

        nim = header.findViewById(R.id.nim);
        namaMhs = header.findViewById(R.id.nama_mhs);
        profile = header.findViewById(R.id.imageView);

        nim.setText(prefs.getString("username",""));
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        Spinmakul = (Spinner)navigationView.getMenu().findItem(R.id.nav_makul).getActionView();
        Spinmakul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilih = String.valueOf(Spinmakul.getSelectedItem());

                if (!pilih.equals("--Pilih--")) {

                    MataKuliah mataKuliah = new MataKuliah();

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    if (fragmentManager != null) {

                        FragmentTransaction ft = fragmentManager.beginTransaction();

                        ft.replace(R.id.frame_container, mataKuliah, MataKuliah.class.getSimpleName());
                        ft.addToBackStack(null);

                        ft.commit();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setFloatActionButton(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pemAka) {
            PembimbingAkademik pembimbingAkademik = new PembimbingAkademik();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null){

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame_container,pembimbingAkademik, PembimbingAkademik.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        } else if (id == R.id.nav_materi) {

            Materi materi = new Materi();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null){

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame_container,materi, Materi.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        } else if (id == R.id.nav_pengumuman) {
            Pengumuman pengumuman = new Pengumuman();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null){

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame_container,pengumuman, Pengumuman.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        } else if (id == R.id.nav_tugas) {
            Tugas tugas = new Tugas();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null){

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame_container,tugas, Tugas.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        } else if (id == R.id.nav_quiz) {
            Quiz quiz = new Quiz();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null){

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame_container,quiz, Quiz.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        } else if (id == R.id.logout) {
            prefs.edit()
                    .clear()
                    .putBoolean("isLogin",false)
                    .apply();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setUserData(@NonNull User data) {
        namaMhs.setText(data.getEmail());
        if (data.getAvatar() != null){
            Glide.with(this)
                    .load(data.getAvatar())
                    .into(profile);
        }
    }

    @Override
    public void setPresenter(@NotNull MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onError(@NonNull String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void setUserClass(@NotNull ArrayList<ClassUser> data) {
        mataKuliah = data;
        Spinmakul.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mataKuliah));
    }
}
