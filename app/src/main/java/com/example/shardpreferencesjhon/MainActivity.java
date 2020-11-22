package com.example.shardpreferencesjhon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Window window;

    Button mBtnBlue;
    Button mBtnRed;
    Button mBtnBlack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnBlue = (Button) findViewById(R.id.btn_Blue);
        mBtnRed = (Button) findViewById(R.id.btn_Red);
        mBtnBlack = (Button) findViewById(R.id.btn_Black);

        this.window = getWindow();

        mBtnBlue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark ="#F7F700";
                String primary = "#F7F700";
                String background= "#F7F700";

                cambiarColor(primaryDark,primary,background);
            }
        });
        mBtnRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#00701A";
                String primary = "#00701A";
                String background= "#00701A";
                cambiarColor(primaryDark,primary,background);            }
        });

        mBtnBlack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#716B6C";
                String primary = "#A29396";
                String background= "#6E6063";
                cambiarColor(primaryDark,primary,background);            }
        });
    }

    private void cambiarColor(String primaryDark,String primary,String background){
        //ColorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //ColorPrimary
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //bg
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //Botton navigation
        window.setNavigationBarColor(Color.parseColor(primary));

        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color",Color.parseColor(primaryDark));
        mEditor.apply();

    }
}