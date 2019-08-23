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

    private BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addFragment(new HomeFragment(),true,"home_fragment");
                    return true;
                case R.id.navigation_dashboard:
                    addFragment(new HotelFragmentList(),true,"list_fragment");
                    return true;
                case R.id.navigation_notifications:
                    return true;
                default:
                    addFragment(new HomeFragment(),true,"home_fragment");
                    return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                Fragment x = getSupportFragmentManager().findFragmentByTag("home_fragment");
                System.out.println(x);
                if ( x != null && x.isVisible()) {
                    System.out.println("CHANGED TRUE");
                    navView.getMenu().getItem(0).setChecked(true);
                } else {
                    System.out.println("CHANGED FALSE");
                }

                System.out.println("TAGS:");
                for ( Fragment f : getSupportFragmentManager().getFragments() )
                    System.out.println(f.getTag());
                System.out.println("----------");
            }
        });
    }

    //???
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        System.out.println(item.getItemId());
        System.out.println("ON BACK");

        for ( Fragment f : getSupportFragmentManager().getFragments() )
            System.out.println(f.getId());

        FragmentManager fm = getSupportFragmentManager();
        //todo change incons in bottom on change

        fm.popBackStack();

    //        System.out.println(fm.getFragments().isEmpty());
    //        if(fm.getFragments().isEmpty()) {
    //            addFragment(new HomeFragment(), true, "s");
    //        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

//        if (addToBackStack) {
//            ft.addToBackStack(tag);
//        }

        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.frameLayout, fragment, tag);
        ft.addToBackStack(tag);
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
        addFragment(fragment,true,"details_fragment");
    }
}
