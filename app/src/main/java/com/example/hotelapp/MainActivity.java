package com.example.hotelapp;


import android.app.ActionBar;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hotelapp.fragments.HomeFragment;
import com.example.hotelapp.fragments.HotelDetailsFragment;
import com.example.hotelapp.fragments.HotelFragmentList;
import com.example.hotelapp.model.Hotel;

public class MainActivity extends AppCompatActivity
        implements HomeFragment.OnFragmentInteractionListener,
        HotelFragmentList.OnListFragmentInteractionListener,
        HotelDetailsFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addFragment(new HomeFragment(),false,"s");
                    return true;
                case R.id.navigation_dashboard:
                    addFragment(new HotelFragmentList(),false,"s");
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //???
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
        System.out.println("ON BACK");

        for ( Fragment f : getSupportFragmentManager().getFragments() )
            System.out.println(f.getId());

        FragmentManager fm = getSupportFragmentManager();
        //todo add animation + change incons in bottom on change
        fm.popBackStack();

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }

        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.frameLayout, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();

        System.out.println("ADDING TO BACKSTACK");
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Hotel item) {
        System.out.println(item);
        Bundle bundle = new Bundle();
        bundle.putSerializable("hotel", item);
        HotelDetailsFragment fragment = new HotelDetailsFragment();
        fragment.setArguments(bundle);
        System.out.println("SENT");
        addFragment(fragment,false,"s");
    }
}
