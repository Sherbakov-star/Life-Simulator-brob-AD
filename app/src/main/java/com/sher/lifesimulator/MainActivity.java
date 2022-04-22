package com.sher.lifesimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static SharedPreferences zagrusit_game;


    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        getString();

    }

    public static String v_school = "";
    public static String v_student = "";
    public static String v_old = "";

    public String getString() {
        v_school = getResources().getString(R.string.v_school);
        v_student = getResources().getString(R.string.v_student);
        v_old = getResources().getString(R.string.v_old);

        return v_school;
    }

    public void p(View view){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.podskaski);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
        //Кнопка которая закрывает диалоговое окно начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //Кнопка которая закрывает диалоговое окно конец
        dialog.show();
    }

    public void choice_school(View view) {

        try {
            Menu.zagruzit_now_game = 1;
            SharedPreferences.Editor ed = zagrusit_game.edit();
            ed.putInt(Menu.zzz,Menu.zagruzit_now_game);
            ed.apply();

            SharedPreferences preferences = getSharedPreferences("Save",0);
            preferences.edit().clear().apply();
            /*SharedPreferences.Editor edit = SchoolLife.pref.edit();
            edit.clear();
            edit.apply();*/
            Toast.makeText(this,v_school, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SchoolLife.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }
        catch (Exception ex){
            Menu.zagruzit_now_game = 1;


            Toast.makeText(this,v_school, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SchoolLife.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }

    }

    public void choice_student(View view) {

        try {
            Menu.zagruzit_now_game = 2;
            SharedPreferences.Editor ed = zagrusit_game.edit();
            ed.putInt(Menu.zzz,Menu.zagruzit_now_game);
            ed.apply();

            SharedPreferences preferences = getSharedPreferences("Save",0);
            preferences.edit().clear().apply();
            /*SharedPreferences.Editor edit = SchoolLife.pref.edit();
            edit.clear();
            edit.apply();*/
            Toast.makeText(this, v_student, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,StudentLifeE.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }
        catch (Exception ex){
            Menu.zagruzit_now_game = 2;

            Toast.makeText(this,v_student, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,StudentLifeE.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }

        //startActivity(intent);finish();
    }

    public void choice_old(View view) {

        try {
            Menu.zagruzit_now_game = 3;
            SharedPreferences.Editor ed = zagrusit_game.edit();
            ed.putInt(Menu.zzz,Menu.zagruzit_now_game);
            ed.apply();

            SharedPreferences preferences = getSharedPreferences("Save",0);
            preferences.edit().clear().apply();
            /*SharedPreferences.Editor edit = SchoolLife.pref.edit();
            edit.clear();
            edit.apply();*/
            Toast.makeText(this,v_old, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,OldLifeE.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }
        catch (Exception ex){
            Menu.zagruzit_now_game = 3;

            Toast.makeText(this,v_old, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,OldLifeE.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0);
        }
        //startActivity(intent);finish();
    }
}