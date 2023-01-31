package com.example.normurodnorqulovasari;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UserAdapterAC2.SelectedUser {



    Toolbar toolbar;
    RecyclerView recyclerView;
    List<ModelRcycler> modelRcyclers = new ArrayList<>();
    TextView textViewSelectedChapterName;

    int getChemgeItemPosition;


    ConstraintLayout constraintLayout;
    UserAdapterAC2 userAdapter;
    ImageView imageViewc2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        imageViewc2 = findViewById(R.id.imageViewac2);

        // ruyhatni eloni va sozlanmasi
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



        // tool bar sozlanmasi
//        toolbar = findViewById(R.id.toolBAr);
//        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");
        // tanlangan chapter nomini activity2 da sarlavhaga yozish
        textViewSelectedChapterName = findViewById(R.id.textViewSelectedChapterName);
        getChemgeItemPosition = intent.getIntExtra("swimmers",1);


        //backround uchun liner layoutni aniqlash
        constraintLayout = findViewById(R.id.constraintLayout1);
        constraintLayout.setBackgroundColor(getResources().getColor(R.color.mycolor));


        switch (getChemgeItemPosition){
            case 1: {

                textViewSelectedChapterName.setText("I BOB. Adib hikoyalarida xarakter va milliy ruh");

                modelRcyclers.add(new ModelRcycler("1.1.  Milliylik: xarakter va ruhiyat birligi","https://github.com/asadbekakmedov2001/ustoziga/raw/master/app/src/main/assets/1.1.pdf"));
                modelRcyclers.add(new ModelRcycler("1.2.  Adib hikoyalarida ruhiyat tasviri","https://github.com/asadbekakmedov2001/ustoziga/raw/master/app/src/main/assets/1.2.pdf"));

            }break;
            case 2: {

                textViewSelectedChapterName.setText("II.BOB. Normurod Norqobil asarlarining o‘ziga xos jihatlari");

                modelRcyclers.add(new ModelRcycler("2.1. Adib asarlarida bosh qahramonning individual tabiati talqini","https://github.com/asadbekakmedov2001/ustoziga/raw/master/app/src/main/assets/2.1.pdf"));
                modelRcyclers.add(new ModelRcycler("2.2.  Adib asarlarida tabiat tasviri","https://github.com/asadbekakmedov2001/ustoziga/raw/master/app/src/main/assets/2.2.pdf"));

            }break;



        }

        userAdapter  = new UserAdapterAC2(modelRcyclers,  this);
        recyclerView.setAdapter(userAdapter);



    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id   = item.getItemId();
        if (id == R.id.search_view) return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void selectedUser(ModelRcycler modelRcycler) {
        startActivity(new Intent(MainActivity2.this, MainActivity3.class).putExtra("data",modelRcycler.getLoadUrl()));
    }
}