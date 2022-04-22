package com.sher.lifesimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    public static SharedPreferences load_game;

    public static final String zzz = "zzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_1);
        Button buttonStart = (Button)findViewById(R.id.button_nachat);
        getString();
    }

    public static int ndialog = 0;
    public static int proverka = 0;
    public static int zagruzka = 0;
    final String load= "666";
    public static  int nenado = 0; //для того чтобы сообщение вылезло 1 раз

    public static  int zagruzit_now_game = 0;

    public static String netsohr1;

    public String getString() {
        netsohr1 = getResources().getString(R.string.netsohr);
        return netsohr1;
    }

    public void setZagruzka(){
        load_game = getSharedPreferences("save_fucking_game", MODE_MULTI_PROCESS);
        int saved_zagruzka = load_game.getInt(load, 0);
        zagruzka = saved_zagruzka;

        MainActivity.zagrusit_game = getSharedPreferences("zagrusi", MODE_MULTI_PROCESS);
        int zagr = MainActivity.zagrusit_game.getInt(zzz, 0);
        zagruzit_now_game = zagr;
    }

    public void onMyButtonClickNachat(View view) {

        ndialog = 0;
        zagruzka = 1;
        load_game = getSharedPreferences("save_fucking_game",MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = load_game.edit();
        ed.putInt(load,zagruzka);
        ed.apply();

        Intent intent = new Intent(Menu.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        //startActivity(intent);finish();

    }

    public void onMyButtonClickNastroiki(View view){
        Intent intent = new Intent(Menu.this,Options.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);

    }

    public  void onMyButtonClickZagruzit(View view){

        setZagruzka();
        if (zagruzka == 1){
            proverka = 1;
            ndialog = 1;
            if (zagruzit_now_game == 1){
                Intent intent = new Intent(Menu.this,SchoolLife.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
            }

            if (zagruzit_now_game == 2){
                Intent intent = new Intent(Menu.this,StudentLifeE.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
            }

            if (zagruzit_now_game == 3){
                Intent intent = new Intent(Menu.this,OldLifeE.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
            }

        }
        else {
            if (nenado == 0){
                Toast.makeText(this,netsohr1, Toast.LENGTH_SHORT).show();
                nenado = 1;
            }

        }

    }
}