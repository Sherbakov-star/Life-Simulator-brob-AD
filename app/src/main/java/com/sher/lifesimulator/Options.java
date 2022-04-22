package com.sher.lifesimulator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Options extends AppCompatActivity {

    public static SharedPreferences saved_nastroiki;
    public static SharedPreferences saved_t;
    public static  final String save_vibro = "333";
    public static int saved_vibro = 0;
    final String save_text = "222";
    public static String vkl = "";
    public static String vikl = "";
    public static String text_now = "";

    public static String s = "";
    public static String t = "С";
    public static final String save_tema = "111";
    public static String text_now2 = "";
    final String save_tema_text = "000";
   // public static int saved_temm = 0;

    public static String vibro_vkl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.options);
        getString();
        init_nastroiki();

    }
    public String getString() {
        s = getResources().getString(R.string.temnaya_tema);
        t = getResources().getString(R.string.svetlaya_tema);
        vkl = getResources().getString(R.string.vibro_vkl);
        vikl = getResources().getString(R.string.vibro_vikl);
        return s;
    }
    public void init_nastroiki(){
        Button button =(Button)findViewById(R.id.music);
        String text = button.getText().toString();
        saved_nastroiki = getSharedPreferences("Save_options",0);
        String vbr = saved_nastroiki.getString(save_text,vkl);
        text_now = vbr;
        button.setText(text_now);

        saved_t = getSharedPreferences("saved_t",0);
        Button b = findViewById(R.id.tem);
        String temm = saved_t.getString(save_tema_text,t);
        text_now2 = temm;
        b.setText(text_now2);



    }
    public void vibro(View view){
        Button button =(Button)view;
        String text = button.getText().toString();
        //Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

        if (text.equals(vkl)){
            saved_vibro = 1;
            saved_nastroiki = getSharedPreferences("Save_options", MODE_MULTI_PROCESS);
            SharedPreferences.Editor ed = saved_nastroiki.edit();
            ed.putInt(save_vibro,saved_vibro);
            text_now = vikl;
            ed.putString(save_text,text_now);
            ed.apply();
            button.setText(text_now);

        }

        if (text.equals(vikl)){
            saved_vibro = 0;
            saved_nastroiki = getSharedPreferences("Save_options", MODE_MULTI_PROCESS);
            SharedPreferences.Editor ed = saved_nastroiki.edit();
            ed.putInt(save_vibro,saved_vibro);
            text_now = vkl;
            ed.putString(save_text,text_now);
            ed.apply();
            button.setText(text_now);

        }

    }

    public void smenit_tema(View view){
        Button b = findViewById(R.id.tem);
        String text1 = b.getText().toString();
        if (text1.equals(t)){
            b.setText(s);
            SchoolLife.smena_tema = 1;//Смена темы на темную
           // saved_temm = 1;
            saved_t = getSharedPreferences("saved_t", MODE_MULTI_PROCESS);
            SharedPreferences.Editor ed = saved_t.edit();
            ed.putInt(save_tema,SchoolLife.smena_tema);
            text_now2 = s;
            ed.putString(save_tema_text,text_now2);
            ed.apply();
        }

        if (text1.equals(s)){
            b.setText(t);
            SchoolLife.smena_tema = 0;
            //saved_temm = 0;
            saved_t = getSharedPreferences("saved_t", MODE_MULTI_PROCESS);
            SharedPreferences.Editor ed = saved_t.edit();
            ed.putInt(save_tema,SchoolLife.smena_tema);
            text_now2 = t;
            ed.putString(save_tema_text,text_now2);
            ed.apply();
        }

    }

}