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
import android.widget.ExpandableListView;
import android.widget.SearchView;

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

    private String[] mataKuliah;
    private String[] menuList;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

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

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        /*int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData() {

        mataKuliah = new String[]{"Kecerdasan Buatan","Basis Data","pemrograman Web","Multimedia","sistem Informasi","Komputer Masyarakat","Tauhid"};
        List<String> matkul = Arrays.asList(mataKuliah);

        menuList = new String[]{"Pembimbing Akademik","Mata Kuliah","Materi","Tugas","Pengumuman","Quiz","Logout"};
        List<String> menuHead = Arrays.asList(menuList);
        MenuModel menuModel; //Menu of Android Tutorial. No sub menus


        int countGroup=0;
        for (String aMenu : menuList) {
            if (!menuHead.get(countGroup).equals("Mata Kuliah")) {
                menuModel = new MenuModel(menuHead.get(countGroup), true, false, "http://learning.uin-suka.ac.id", ""); //Menu of Android Tutorial. No sub menus
                headerList.add(menuModel);

                if (!menuModel.hasChildren) {
                    childList.put(menuModel, null);
                }
                countGroup++;
            }
            else {
                menuModel = new MenuModel("Mata Kuliah", true, true, "", ""); //Menu of Java Tutorials
                headerList.add(menuModel);
                List<MenuModel> childModelsList = new ArrayList<>();
                int countChild =0;
                for (String aMataKuliah : mataKuliah) {
                    MenuModel childModel = new MenuModel(matkul.get(countChild), false, false, "http://uin-suka.ac.id","");
                    childModelsList.add(childModel);
                    countChild++;
                }
                if (menuModel.hasChildren) {
                    Log.d("API123","here");
                    childList.put(menuModel, childModelsList);
                }
                countGroup++;
            }
        }

    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        /*WebView webView = findViewById(R.id.webView);
                        webView.loadUrl(headerList.get(groupPosition).icon);
                        onBackPressed();*/

                        Fragment fragment = null;

                        switch (headerList.get(groupPosition).menuName){
                            case "Pembimbing Akademik" :
                                fragment = new PembimbingAkademik();
                                break;
                            case "Materi" :
                                fragment = new Materi();
                                break;
                            case "Tugas" :
                                fragment = new Tugas();
                                break;
                        }

                        if (fragment != null){
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();

                            ft.replace(R.id.frame_container, fragment);

                            ft.commit();
                        }
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    /*if (model.icon.length() > 0) {
                        WebView webView = findViewById(R.id.webView);
                        webView.loadUrl(model.icon);
                        onBackPressed();
                    }*/
                }

                return false;
            }
        });
    }
}
