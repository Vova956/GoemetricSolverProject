package com.example.geometricsolver3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Geometry calculator");


        ImageButton imageButton1 = findViewById(R.id.main_imageButton1);
        imageButton1.setOnClickListener(evt ->{
            Intent intent = new Intent(this, TriangleCalculator1.class);
            startActivity(intent);
        });

        ImageButton imageButton2 = findViewById(R.id.main_imageButton2);
        imageButton2.setOnClickListener(evt ->{
            Intent intent = new Intent(this,TriangleCalculator2.class);
            startActivity(intent);
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;

        switch (id){
            case R.id.aboutAction:
                intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.helpCenterAction:
                intent = new Intent(this,HelpActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}