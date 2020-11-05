package com.nexstacks.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class SideNavigationActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_navigation);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar mToolbar = findViewById(R.id.tl_side_nave);
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.open, R.string.close);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.action_move){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new LogoutFragment())
                            .addToBackStack(null).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String subject = "";
        String user = "";
        String content = "";
        boolean showBack = false;
        if (item.getItemId() == R.id.action_gps) {

//            Intent intent = new Intent(SideNavigationActivity.this, MainActivity.class);
//            startActivity();
            subject = "Hello you have succesfully completed the Android course!";
            user = "Hello Gagan";
            content = "Hello Gagan, You have secured 100 points in the Android Course. Congratulations";

            showBack = false;

        } else if (item.getItemId() == R.id.action_group) {
            subject = "Hello you have succesfully completed the React course!";
            user = "Hello Kunj";
            content = "Hello Kunj, You have secured 100 points in the React Course. Congratulations";
            showBack = false;
        } else {
            subject = "Hello you have succesfully completed the Python course!";
            user = "Hello Sayan";
            content = "Hello Sayan, You have secured 100 points in the Python Course. Congratulations";
            showBack = true;
        }


        ProfileFragment profileFragment = new ProfileFragment();
        Bundle data = new Bundle();
        data.putString("SUBJECT", subject);
        data.putString("USER", user);
        data.putString("CONTENT", content);
        data.putBoolean("BACK", showBack);

        profileFragment.setArguments(data);

        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, profileFragment);
        fm.addToBackStack(null);
        fm.commit();
        return true;
    }
}