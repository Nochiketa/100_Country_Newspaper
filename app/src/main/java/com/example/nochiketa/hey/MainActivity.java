package com.example.nochiketa.hey;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;
    ArrayList<Country> arraylist = new ArrayList<>();
    String[] name;
    Integer[] icon;
    AdView mAdview;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    //ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.ListViewMain);
        mAdview = (AdView) findViewById(R.id.adView);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.Drawerlayout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id == R.id.home)
                {
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                if(id == R.id.nav_contact)
                {
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                if(id == R.id.nav_exit)
                {
                    finish();
                    return true;
                }
                return false;
            }
        });

        name = new String[]{
                "USA", "India", "Bangladesh", "United Kingdom", "Russia", "Australia",
                "Canada", "France", "Germany", "Japan", "China", "South Africa", "Spain",
                "Pakistan", "Italy", "South Korea", "North Korea", "Indonesia", "Switzerland",
                "Argentina", "Turkey", "Vietnam", "Austria", "Nepal", "Sri Lanka", "Portugal",
                "Brazil","Sweden","Denmark","Cuba", "Egypt","Mexico","Iran","Belgium","Saudia Arabia",
                "Sudan","Czech Republic","Bhutan", "United Arab Emirates","Hong Kong","New Zealand",
                "Singapore","Norway","Ukrain","Scotland","Venezuela","Angola","Iraq","Tunisia","Bahrain",
                "Finland","Bulgaria","Algeria","Afghanistan","Cambodia","Latvia","Guine","Jordan","Yemen",
                "Nigeria","Belarus","Colombia","Wales","Ghana","Serbia","Chad","Gabon","Bolivia","Hungary",
                "Poland","Greece","Albania","Croatia","Luxembourg","Thailand","Philippines","Taiwan","Lebanon",
                "Mongolia","Tanzania","Brunei","Ecuador","Hondurus","Slovakia","Chile","Paraguya","Botswana",
                "Liberia","Qatar","Ireland","Romania","Slovenia","Estonia","Jamaica","Moldova","Malaysia","Kuwait",
                "Laos","Uzbekistan","Macau"
        };

        icon = new Integer[]{
                R.drawable.usa, R.drawable.india, R.drawable.bangladesh, R.drawable.uk,R.drawable.russia,
                R.drawable.australia, R.drawable.canada,R.drawable.france, R.drawable.germany, R.drawable.japan,
                R.drawable.china, R.drawable.southafrica, R.drawable.spain, R.drawable.pakistan,
                R.drawable.italy, R.drawable.southkorea, R.drawable.northkorea, R.drawable.indonesia,
                R.drawable.switzerland, R.drawable.argentina, R.drawable.turkey, R.drawable.vietnam, R.drawable.austria,
                R.drawable.nepal, R.drawable.srilanka, R.drawable.portugal, R.drawable.brazil,R.drawable.sweden,
                R.drawable.denmark,R.drawable.cuba,R.drawable.egypt,R.drawable.mexico,R.drawable.iran,R.drawable.belgium,
                R.drawable.saudiarabia,R.drawable.sudan,R.drawable.czech,R.drawable.bhutan,R.drawable.arabemirates,
                R.drawable.hongkong,R.drawable.newzealand,R.drawable.singapore,R.drawable.norway, R.drawable.ukrain,
                R.drawable.scotland,R.drawable.venezuela,R.drawable.angola,R.drawable.iraq,R.drawable.tunisia,
                R.drawable.bahrain,R.drawable.finland,R.drawable.bulgaria,R.drawable.algeria,R.drawable.afghanistan,
                R.drawable.cambodia,R.drawable.latvia,R.drawable.guine,R.drawable.jordan,R.drawable.yemen,R.drawable.nigeria,
                R.drawable.belarus,R.drawable.colombia,R.drawable.wales,R.drawable.ghana,R.drawable.serbia,R.drawable.chad,
                R.drawable.gabon,R.drawable.bolivia,R.drawable.hungary,R.drawable.poland,R.drawable.greece,R.drawable.albania,
                R.drawable.croatia,R.drawable.luxembourg,R.drawable.thailand,R.drawable.philippines,R.drawable.taiwan,
                R.drawable.lebanon,R.drawable.mongolia,R.drawable.tanzania,R.drawable.brunei,R.drawable.ecuador,R.drawable.hondurus,
                R.drawable.slovakia,R.drawable.chile,R.drawable.paraguya,R.drawable.botswana,R.drawable.liberia,R.drawable.qatar,
                R.drawable.ireland,R.drawable.romania,R.drawable.slovenia,R.drawable.estonia,R.drawable.jamaica,R.drawable.moldova,
                R.drawable.malaysia,R.drawable.kuwait,R.drawable.laos,R.drawable.uzbekistan,R.drawable.macau

        };

        for (int i=0; i<name.length; i++) {
            Country con = new Country(icon[i], name[i]);
            arraylist.add(con);
        }

        adapter = new ListViewAdapter(this, arraylist);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem shareItem = (MenuItem) menu.findItem(R.id.menu_item_share);
        ShareActionProvider mShare = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "text to share");
        mShare.setShareIntent(shareIntent);
        return onOptionsItemSelected(shareItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            return true;
        }
        else if (id == R.id.menu_item_search){
            SearchView searchView = (SearchView)item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.filter(newText);
                    return false;
                }
            });
            return true;
        }
        else if (id == R.id.action_rating)
        {
            return true;
        }
        if(id == R.id.menu_item_share)
        {
            return true;
        }
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void info(MenuItem menuItem)
    {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
    public void contact(MenuItem menuItem)
    {
        Intent i = new Intent(this, contactActivity.class);
        startActivity(i);
        mDrawerLayout.closeDrawers();
    }
    public void exit(MenuItem menuItem)
    {
        onBackPressed();
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setIcon(R.drawable.icon1);
        mBuilder.setTitle("100 Country Newspapers");
        mBuilder.setMessage("Do you want to exit?");
        mBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        mBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }
}
