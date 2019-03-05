package com.androidprojectrpl.k5.learning_kelompok5.view.main;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

import com.androidprojectrpl.k5.learning_kelompok5.Data.DataMatkul;
import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.MataKuliah;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Materi;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.PembimbingAkademik;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Pengumuman;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Quiz;
import com.androidprojectrpl.k5.learning_kelompok5.fragment.Tugas;
import com.androidprojectrpl.k5.learning_kelompok5.model.User;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private Spinner Spintahun;
    private Spinner Spinsemester;
    private Spinner Spinmakul;
    private ArrayList<String> thnAjaran;
    private ArrayList<String> semester;
    private ArrayList<String> pilihan;
    private String tahun,smster,pilih;
    private String[] list;
    private TextView nim, namaMhs;
    private MainPresenter presenter;
    private ImageView profile;
    private SharedPreferences prefs;

    private static final String PREFERENCES = "SharedLearning";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prefs = getSharedPreferences(PREFERENCES,MODE_PRIVATE);
        presenter = new MainPresenter(this);

        NavigationView navView = findViewById(R.id.nav_view);
        View header = navView.getHeaderView(0);

        nim = header.findViewById(R.id.nim);
        namaMhs = header.findViewById(R.id.nama_mhs);
        profile = header.findViewById(R.id.imageView);

        nim.setText(prefs.getString("username",""));

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
        Spintahun.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thnAjaran));
        Spintahun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tahun = String.valueOf(Spintahun.getSelectedItem());

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Spinsemester = (Spinner)navigationView.getMenu().findItem(R.id.nav_semester).getActionView();
        Spinmakul = (Spinner)navigationView.getMenu().findItem(R.id.nav_makul).getActionView();
        Spinsemester.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, semester));
        Spinsemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Fragment fragment = new PembimbingAkademik();
                smster = String.valueOf(Spinsemester.getSelectedItem());

                if (tahun.contentEquals("2018/2019") && smster.contentEquals("Ganjil")){
                    list = DataMatkul.semester5;
                }
                if (tahun.contentEquals("2018/2019") && smster.contentEquals("Genap")){
                    list = DataMatkul.semester6;
                }
                if (tahun.contentEquals("2017/2018") && smster.contentEquals("Ganjil")){
                    list = DataMatkul.semester3;
                }
                if (tahun.contentEquals("2017/2018") && smster.contentEquals("Genap")){
                    list = DataMatkul.semester4;
                }
                if (tahun.contentEquals("2016/2017") && smster.contentEquals("Ganjil")){
                    list = DataMatkul.semester1;
                }
                if (tahun.contentEquals("2016/2017") && smster.contentEquals("Genap")){
                    list = DataMatkul.semester2;
                }
                if (tahun.contentEquals("2015/2016") && smster.contentEquals("Ganjil")){
                    list = DataMatkul.semester2;
                }
                if (tahun.contentEquals("2015/2016") && smster.contentEquals("Genap")){
                    list = DataMatkul.semester7;
                }
                if (tahun.contentEquals("2014/2015") && smster.contentEquals("Ganjil")){
                    list = DataMatkul.semester8;
                }
                if (tahun.contentEquals("2014/2015") && smster.contentEquals("Genap")){
                    list = DataMatkul.semester6;
                }
                Spinmakul.setAdapter(new ArrayAdapter<>(NavDrawer.this, android.R.layout.simple_spinner_dropdown_item, list));

                PembimbingAkademik pembimbingAkademik = new PembimbingAkademik();

                Bundle bundle = new Bundle();
                pilihan = new ArrayList<>();
                pilihan.add(tahun);
                pilihan.add(smster);
                bundle.putStringArrayList(PembimbingAkademik.TAHUN_PILIHAN,pilihan);

                pembimbingAkademik.setArguments(bundle);

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (fragmentManager != null){

                    FragmentTransaction ft = fragmentManager.beginTransaction();

                    ft.replace(R.id.frame_container,pembimbingAkademik, PembimbingAkademik.class.getSimpleName());
                    ft.addToBackStack(null);

                    ft.commit();
                }

                Toast.makeText(NavDrawer.this,semester.get(position),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinmakul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilih = String.valueOf(Spinmakul.getSelectedItem());

                if (pilih.equals("--Pilih--")){
                    Toast.makeText(NavDrawer.this,Spinmakul.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }else {

                    MataKuliah mataKuliah = new MataKuliah();

                    Bundle fBundle = new Bundle();
                    fBundle.putString(MataKuliah.MAKUL_PILIHAN, pilih);

                    mataKuliah.setArguments(fBundle);

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    if (fragmentManager != null) {

                        FragmentTransaction ft = fragmentManager.beginTransaction();

                        ft.replace(R.id.frame_container, mataKuliah, MataKuliah.class.getSimpleName());
                        ft.addToBackStack(null);

                        ft.commit();
                    }


                    Toast.makeText(NavDrawer.this, Spinmakul.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void dataSpinner() {
        thnAjaran = new ArrayList<>();
        thnAjaran.add("2018/2019");
        thnAjaran.add("2017/2018");
        thnAjaran.add("2016/2017");
        thnAjaran.add("2015/2016");
        thnAjaran.add("2014/2015");

        semester = new ArrayList<>();
        semester.add("Ganjil");
        semester.add("Genap");

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
        presenter.getUser(prefs.getString("id",""));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pemAka) {
            PembimbingAkademik pembimbingAkademik = new PembimbingAkademik();

            Bundle bundle = new Bundle();
            pilihan = new ArrayList<>();
            pilihan.add(tahun);
            pilihan.add(smster);
            bundle.putStringArrayList(PembimbingAkademik.TAHUN_PILIHAN,pilihan);

            pembimbingAkademik.setArguments(bundle);

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
}
