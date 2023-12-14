package com.muhm.upokotha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.muhm.upokotha.Fragment.HomeFragment;
import com.muhm.upokotha.Fragment.ListFragment;
import com.muhm.upokotha.Fragment.SearchFragment;
import com.muhm.upokotha.Fragment.SettingsFragment;

public class Dashboard extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bottomNavigationView=findViewById(R.id.bottom_nav);


          bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  int id=item.getItemId();
                  if(id==R.id.home){
                      loadFrag(new HomeFragment(),0);
                  } else if (id==R.id.search) {
                      loadFrag(new SearchFragment(),1);
                  }else if (id==R.id.my_list) {
                      loadFrag(new ListFragment(),1);
                  }else if (id==R.id.settings) {
                      loadFrag(new SettingsFragment(),1);
                  }
                  return true;
              }
          });


        bottomNavigationView.setSelectedItemId(R.id.home);


    }

    public void loadFrag(Fragment fragment,int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.container,fragment);
        }
        else {
            ft.replace(R.id.container,fragment);
        }
        ft.addToBackStack(null).commit();
    }
}