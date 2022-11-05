package com.malek.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.navigation.NavigationView;

import com.malek.app.ui.Home_Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class BottomNavActivity extends AppCompatActivity {
    private DrawerLayout drawer ;
    private AppBarConfiguration mAppBarConfiguration;
    private ImageView actionBarImage , actionBarBackImage ;
    Fragment defaultFragment;
    private TextView actionBarTitle ;
    //navigation header
    private TextView name , department ;
    private TextView badgeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //initial fragment load
        if(savedInstanceState==null){
            defaultFragment = new HomeFragment();
            //changeFragment(new CategoryFragment());
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment,defaultFragment).commit();
        }
        //finding components
        actionBarTitle = findViewById(R.id.actionbar_title_text);
        actionBarTitle.setText("Categories");


        actionBarImage = findViewById(R.id.drawer_logo);
        actionBarBackImage = findViewById(R.id.drawer_back_logo);
        drawer = findViewById(R.id.drawer_layout);

        //Declare navigation view ID (bottomnav_view) in content_main
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){


                }

                //getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment,defaultFragment).commit();
                return true;
            }
        });

        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(3);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        View badge = LayoutInflater.from(this)
                .inflate(R.layout.notification_badge, itemView, true);

        badgeView = badge.findViewById(R.id.notificationsbadge);







        //customize actionbar
        actionBarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        //navigation view finding
        NavigationView navigationView = (NavigationView) findViewById(R.id.custom_nav);
        View header = navigationView.getHeaderView(0);
        //nav header
        name = header.findViewById(R.id.nav_header_name);
        department = header.findViewById(R.id.nav_header_dept);

        //setting header

        //on navigation item select
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_home:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_logout:
                        LogoutDialog();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share:
                        shareApplication();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    default:

                }
                return true;
            }
        });
    }
    private void LogoutDialog(){
        new AlertDialog.Builder(this)
                .setIcon(getResources().getDrawable(R.drawable.ic_baseline_warning_24))
                .setTitle("Logout Alart")
                .setMessage("Are You Sure You Want To LogOut ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
    private void shareApplication() {

    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.search_menu_item){

        }
        return super.onOptionsItemSelected(item);
    }
    private void changeFragment(Fragment parameterNewFragment){
        Fragment newFragment = parameterNewFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}