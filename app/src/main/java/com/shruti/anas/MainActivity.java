package com.shruti.anas;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    NavigationView vNV;
    DrawerLayout layDL;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //status bar hide
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        vNV=findViewById(R.id.Sec_vNV);
        layDL=findViewById(R.id.layDL);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SHRUTI");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,layDL,toolbar,R.string.closedrawer,R.string.opendrawer);
        layDL.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null){
            loadFrag(new HomeFrag());
            vNV.setCheckedItem(R.id.item_home);
        }

        nav_itemSelect();
    }

    private void nav_itemSelect() {

        vNV.setNavigationItemSelectedListener(item -> {
            Fragment currFrag=null;
            switch (item.getItemId()){
                case R.id.item_home:
                    currFrag=new HomeFrag();
                    break;
                case R.id.item_search:
                    Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_utilites:
                    Toast.makeText(getApplicationContext(), "Utilities", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_help:
                    Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_profile:
                    Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                    break;
            }

            layDL.closeDrawer(GravityCompat.START);

            if (currFrag!=null){
                loadFrag(currFrag);
            }

            return true;
        });
    }

    private void loadFrag(Fragment currFrag) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layFL,currFrag)
                .commit();
    }

    @Override
    public void onBackPressed() {
        Fragment currFrag = getSupportFragmentManager().findFragmentById(R.id.layFL);

        if (layDL.isDrawerOpen(GravityCompat.START)){
            layDL.closeDrawer(GravityCompat.START);
        }
        else if (currFrag!=new HomeFrag()){
            loadFrag(new HomeFrag());
            vNV.setCheckedItem(R.id.item_home);
        }
        else {
            super.onBackPressed();
        }
    }
}