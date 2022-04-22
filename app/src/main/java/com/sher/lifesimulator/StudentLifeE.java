package com.sher.lifesimulator;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

public class StudentLifeE extends AppCompatActivity {

    Dialog dialog;
    public static SharedPreferences pref;

    private TextView money1;
    private TextView vozrast1;
    private TextView hp1;
    private TextView eat1;
    private TextView mood1;
    private TextView respect1;
    private TextView study1;
    private TextView car1;
    private TextView apartment1;

    private final String save_vozrast = "save_vozrast";
    private final String save_money = "save_money";
    private final String save_hp = "save_hp";
    private final String save_eat = "save_eat";
    private final String save_mood = "save_mood";
    private final String save_respect = "save_respect";
    private final String save_study = "save_study";
    private final String save_car = "save_car";
    private final String save_apartment = "save_apartment";
    private final String block_arenda = "block_arenda";
    final String SAVE = "777";
    final String save_zagruzka = "666";
    final String save_rabota_prog = "555";
    final String save_rabota_biz = "444";
    final String save_dlyap = "p";
    final String save_dlyab = "b";
    final String save_schetchik = "sch";

    private LinearLayout linearLayout;//Для смены темы
    public static int smena_tema = 0;//Для смены темы
    private ConstraintLayout constraintLayout;//Для смены темы

    public static String alert = "";
    public static String scoroplat = "";
    public static String scoroplat2 = "";
    public static String scoroplat3 = "";
    public static String scoroplat4 = "";
    public static String scoroplat5 = "";
    public static String kur1 = "";
    public static String biz1 = "";
    public static String glicin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.student_life_e);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        tema();
        getString1();
        maindialog();//метод для определения показывать повторно диалог или нет
        init();//загрузить сохранения
        block();//метод блокирующий кнопки
        cvet();//метод дающий цвет цифрам
    }

    int schetchik = 0;//для того чтобы увеличивался возраст
    int skill = 0;//для разблокировки профессии программиста
    int buzines = 0;//для разблокировки бизнеса
    int dlyap = 0;//для лучшей работы вывода диалогового окна разблокировки программирования и бизнеса
    int dlyab = 0;//для лучшей работы вывода диалогового окна разблокировки программирования и бизнеса
    String transport = "";//для возможности зарабатывать больше денег курьером после покупки транспорта
    int delivery = 0;//для возможности увеличить количество прибыли курьера в 2 раза
    int arenda = 0;//для аренды жилья
    int vibro = 0;

    public String getString1() {
        alert = getResources().getString(R.string.alert);//недостаточно средств
        scoroplat = getResources().getString(R.string.scoroplat);
        scoroplat2 = getResources().getString(R.string.scoroplat2);//Плата за аренду:8000
        scoroplat3 = getResources().getString(R.string.scoroplat3);
        scoroplat4 = getResources().getString(R.string.scoroplat4);
        scoroplat5 = getResources().getString(R.string.scoroplat5);
        kur1 = getResources().getString(R.string.kur1);
        biz1 =getResources().getString(R.string.biz1);

        glicin = getResources().getString(R.string.gliсin);

        return alert;

    }
    public void tema(){
        Options.saved_t = getSharedPreferences("saved_t",0);
        int smntm = Options.saved_t.getInt(Options.save_tema,0);
        smena_tema = smntm;

        if (smena_tema == 1){
            linearLayout = findViewById(R.id.bac);
            int colorb = Color.rgb(0,0,0);
            linearLayout.setBackgroundColor(colorb);
            constraintLayout = findViewById(R.id.bac1);
            constraintLayout.setBackgroundColor(colorb);
            int colorWhite = Color.rgb(255,255,255);
            //Смена цвета кнопок и текста кнопок начало
            Button btn1 = findViewById(R.id.button1);
            btn1.setBackgroundColor(colorb);
            btn1.setTextColor(colorWhite);

            Button btn2 = findViewById(R.id.button2);
            btn2.setBackgroundColor(colorb);
            btn2.setTextColor(colorWhite);

            Button btn3 = findViewById(R.id.button3);
            btn3.setBackgroundColor(colorb);
            btn3.setTextColor(colorWhite);

            Button btn4 = findViewById(R.id.button4);
            btn4.setBackgroundColor(colorb);
            btn4.setTextColor(colorWhite);

            Button btn5 = findViewById(R.id.button5);
            btn5.setBackgroundColor(colorb);
            btn5.setTextColor(colorWhite);

            Button btn6 = findViewById(R.id.button6);
            btn6.setBackgroundColor(colorb);
            btn6.setTextColor(colorWhite);

            Button btn7 = findViewById(R.id.button7);
            btn7.setBackgroundColor(colorb);
            btn7.setTextColor(colorWhite);

            Button btn8 = findViewById(R.id.button1_2);
            btn8.setBackgroundColor(colorb);
            btn8.setTextColor(colorWhite);

            Button btn9 = findViewById(R.id.button2_2);
            btn9.setBackgroundColor(colorb);
            btn9.setTextColor(colorWhite);

            Button btn10 = findViewById(R.id.button3_2);
            btn10.setBackgroundColor(colorb);
            btn10.setTextColor(colorWhite);

            Button btn11 = findViewById(R.id.button4_2);
            btn11.setBackgroundColor(colorb);
            btn11.setTextColor(colorWhite);

            Button btn12 = findViewById(R.id.button5_2);
            btn12.setBackgroundColor(colorb);
            btn12.setTextColor(colorWhite);

            Button btn13 = findViewById(R.id.button6_2);
            btn13.setBackgroundColor(colorb);
            btn13.setTextColor(colorWhite);

            Button btn14 = findViewById(R.id.button7_2);
            btn14.setBackgroundColor(colorb);
            btn14.setTextColor(colorWhite);

            Button btn15 = findViewById(R.id.button1_3);
            btn15.setBackgroundColor(colorb);
            btn15.setTextColor(colorWhite);

            Button btn16 = findViewById(R.id.button2_3);
            btn16.setBackgroundColor(colorb);
            btn16.setTextColor(colorWhite);

            Button btn17 = findViewById(R.id.button3_3);
            btn17.setBackgroundColor(colorb);
            btn17.setTextColor(colorWhite);

            Button btn18 = findViewById(R.id.button4_3);
            btn18.setBackgroundColor(colorb);
            btn18.setTextColor(colorWhite);

            Button btn19 = findViewById(R.id.button5_3);
            btn19.setBackgroundColor(colorb);
            btn19.setTextColor(colorWhite);

            Button btn20 = findViewById(R.id.button6_3);
            btn20.setBackgroundColor(colorb);
            btn20.setTextColor(colorWhite);

            Button btn21 = findViewById(R.id.button7_3);
            btn21.setBackgroundColor(colorb);
            btn21.setTextColor(colorWhite);

            Button btn22 = findViewById(R.id.button1_4);
            btn22.setBackgroundColor(colorb);
            btn22.setTextColor(colorWhite);

            Button btn23 = findViewById(R.id.button2_4);
            btn23.setBackgroundColor(colorb);
            btn23.setTextColor(colorWhite);

            Button btn24 = findViewById(R.id.button3_4);
            btn24.setBackgroundColor(colorb);
            btn24.setTextColor(colorWhite);

            Button btn25 = findViewById(R.id.button4_4);
            btn25.setBackgroundColor(colorb);
            btn25.setTextColor(colorWhite);

            Button btn26 = findViewById(R.id.button5_4);
            btn26.setBackgroundColor(colorb);
            btn26.setTextColor(colorWhite);

            Button btn27 = findViewById(R.id.button6_4);
            btn27.setBackgroundColor(colorb);
            btn27.setTextColor(colorWhite);

            Button btn28 = findViewById(R.id.button7_4);
            btn28.setBackgroundColor(colorb);
            btn28.setTextColor(colorWhite);

            Button btn29 = findViewById(R.id.button1_5);
            btn29.setBackgroundColor(colorb);
            btn29.setTextColor(colorWhite);

            Button btn30 = findViewById(R.id.button2_5);
            btn30.setBackgroundColor(colorb);
            btn30.setTextColor(colorWhite);

            Button btn31 = findViewById(R.id.button3_5);
            btn31.setBackgroundColor(colorb);
            btn31.setTextColor(colorWhite);

            Button btn32 = findViewById(R.id.button4_5);
            btn32.setBackgroundColor(colorb);
            btn32.setTextColor(colorWhite);

            Button btn33 = findViewById(R.id.button5_5);
            btn33.setBackgroundColor(colorb);
            btn33.setTextColor(colorWhite);

            Button btn34 = findViewById(R.id.button6_5);
            btn34.setBackgroundColor(colorb);
            btn34.setTextColor(colorWhite);

            Button btn35 = findViewById(R.id.button7_5);
            btn35.setBackgroundColor(colorb);
            btn35.setTextColor(colorWhite);

            Button btn36 = findViewById(R.id.button1_6);
            btn36.setBackgroundColor(colorb);
            btn36.setTextColor(colorWhite);

            Button btn37 = findViewById(R.id.button2_6);
            btn37.setBackgroundColor(colorb);
            btn37.setTextColor(colorWhite);

            Button btn38 = findViewById(R.id.button3_6);
            btn38.setBackgroundColor(colorb);
            btn38.setTextColor(colorWhite);

            Button btn39 = findViewById(R.id.button4_6);
            btn39.setBackgroundColor(colorb);
            btn39.setTextColor(colorWhite);

            Button btn40 = findViewById(R.id.button5_6);
            btn40.setBackgroundColor(colorb);
            btn40.setTextColor(colorWhite);

            Button btn41 = findViewById(R.id.button6_6);
            btn41.setBackgroundColor(colorb);
            btn41.setTextColor(colorWhite);

            Button btn42 = findViewById(R.id.button7_6);
            btn42.setBackgroundColor(colorb);
            btn42.setTextColor(colorWhite);

            Button btn43 = findViewById(R.id.button1_7);
            btn43.setBackgroundColor(colorb);
            btn43.setTextColor(colorWhite);

            Button btn44 = findViewById(R.id.button2_7);
            btn44.setBackgroundColor(colorb);
            btn44.setTextColor(colorWhite);

            Button btn45 = findViewById(R.id.button3_7);
            btn45.setBackgroundColor(colorb);
            btn45.setTextColor(colorWhite);

            Button btn46 = findViewById(R.id.button4_7);
            btn46.setBackgroundColor(colorb);
            btn46.setTextColor(colorWhite);

            Button btn47 = findViewById(R.id.button5_7);
            btn47.setBackgroundColor(colorb);
            btn47.setTextColor(colorWhite);

            Button btn48 = findViewById(R.id.button6_7);
            btn48.setBackgroundColor(colorb);
            btn48.setTextColor(colorWhite);

            Button btn49 = findViewById(R.id.button7_7);
            btn49.setBackgroundColor(colorb);
            btn49.setTextColor(colorWhite);
            //Смена цвета кнопок и текста кнопок конец

            //Смена цвета текста состояния начало
            TextView vozrast = findViewById(R.id.textView2);
            vozrast.setTextColor(colorWhite);

            TextView v = findViewById(R.id.vozrast);
            v.setTextColor(colorWhite);

            TextView money = findViewById(R.id.textView6);
            money.setTextColor(colorWhite);

            TextView m = findViewById(R.id.money);
            m.setTextColor(colorWhite);

            TextView zdor = findViewById(R.id.textView7);
            zdor.setTextColor(colorWhite);

            TextView z = findViewById(R.id.health);
            z.setTextColor(colorWhite);

            TextView eat = findViewById(R.id.textView8);
            eat.setTextColor(colorWhite);

            TextView e = findViewById(R.id.eat);
            e.setTextColor(colorWhite);

            TextView mood = findViewById(R.id.textView9);
            mood.setTextColor(colorWhite);

            TextView mo = findViewById(R.id.mood);
            mo.setTextColor(colorWhite);

            TextView respect = findViewById(R.id.textView10);
            respect.setTextColor(colorWhite);

            TextView resp = findViewById(R.id.respect);
            resp.setTextColor(colorWhite);

            TextView study = findViewById(R.id.textView12);
            study.setTextColor(colorWhite);

            TextView st = findViewById(R.id.study);
            st.setTextColor(colorWhite);

            TextView car = findViewById(R.id.textView13);
            car.setTextColor(colorWhite);

            TextView cr = findViewById(R.id.car);
            cr.setTextColor(colorWhite);

            TextView apartment = findViewById(R.id.textView14);
            apartment.setTextColor(colorWhite);

            TextView apar = findViewById(R.id.apartment);
            apar.setTextColor(colorWhite);
            //Смена цвета текста состояния конец

            //Смена цвета остаточного текста начало
            TextView food = findViewById(R.id.foodfeed);
            food.setTextColor(colorWhite);

            TextView zarab = findViewById(R.id.zarabotat);
            zarab.setTextColor(colorWhite);

            TextView uch = findViewById(R.id.study_1);
            uch.setTextColor(colorWhite);

            TextView zz = findViewById(R.id.zdorovie);
            zz.setTextColor(colorWhite);

            TextView nastr = findViewById(R.id.nastroenie);
            nastr.setTextColor(colorWhite);

            TextView transp = findViewById(R.id.transport);
            transp.setTextColor(colorWhite);

            TextView kvar = findViewById(R.id.kvartira);
            kvar.setTextColor(colorWhite);
            //Смена цвета остаточного текста конец
        }
    }

    private void init(){
        String peshkom = getResources().getString(R.string.peshkom);
        String obshaga = getResources().getString(R.string.obshaga);
        pref = getSharedPreferences("Save",MODE_PRIVATE);

        pref = getSharedPreferences("Save", MODE_MULTI_PROCESS);
        int saved_arenda = pref.getInt(SAVE, 0);
        arenda = saved_arenda;

        int saved_schetchik = pref.getInt(save_schetchik,0);
        schetchik = saved_schetchik;


        Options.saved_nastroiki = getSharedPreferences("Save_options",0);
        int vbr = Options.saved_nastroiki.getInt(Options.save_vibro,0);
        vibro = vbr;


        int saved_skill = pref.getInt(save_rabota_prog,0);
        skill = saved_skill;

        int saved_buziness = pref.getInt(save_rabota_biz,0);
        buzines = saved_buziness;

        int saved_dlyap = pref.getInt(save_dlyap,0);
        dlyap = saved_dlyap;

        int saved_dlyab = pref.getInt(save_dlyab,0);
        dlyab = saved_dlyab;

        money1 = findViewById(R.id.money);
        money1.setText(pref.getString(save_money, String.valueOf(300)));

        vozrast1 = findViewById(R.id.vozrast);
        vozrast1.setText(pref.getString(save_vozrast, String.valueOf(20)));

        hp1 = findViewById(R.id.health);
        hp1.setText(pref.getString(save_hp, String.valueOf(50)));

        eat1 = findViewById(R.id.eat);
        eat1.setText(pref.getString(save_eat, String.valueOf(30)));

        mood1 = findViewById(R.id.mood);
        mood1.setText(pref.getString(save_mood, String.valueOf(50)));

        respect1 = findViewById(R.id.respect);
        respect1.setText(pref.getString(save_respect, String.valueOf(50)));

        study1 = findViewById(R.id.study);
        study1.setText(pref.getString(save_study, String.valueOf(50)));

        car1 = findViewById(R.id.car);
        car1.setText(pref.getString(save_car,peshkom));

        apartment1 = findViewById(R.id.apartment);
        apartment1.setText(pref.getString(save_apartment,obshaga));


    }


    public void save(){
        SharedPreferences.Editor edit = pref.edit();
        pref = getSharedPreferences("Save",MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = pref.edit();
        ed.putInt(SAVE,arenda);
        ed.putInt(save_rabota_prog,skill);
        ed.putInt(save_rabota_biz,buzines);
        ed.putInt(save_dlyap,dlyap);
        ed.putInt(save_dlyab,dlyab);
        ed.putInt(save_schetchik,schetchik);
        ed.apply();

        edit.putString(save_money,money1.getText().toString());
        edit.putString(save_vozrast,vozrast1.getText().toString());
        edit.putString(save_hp,hp1.getText().toString());
        edit.putString(save_eat,eat1.getText().toString());
        edit.putString(save_mood,mood1.getText().toString());
        edit.putString(save_respect,respect1.getText().toString());
        edit.putString(save_study,study1.getText().toString());
        edit.putString(save_car,car1.getText().toString());
        edit.putString(save_apartment,apartment1.getText().toString());
        edit.apply();

    }
    public void maindialog(){
        if (Menu.ndialog == 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.previewdialog2);
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
            Menu.ndialog = 1;
        }
        else{

        }
    }

    public void arend(){
        if (arenda == 15){
            Button button = (Button) findViewById(R.id.button2_7);
            button.setEnabled(false);
            if (schetchik % 25 == 0){
                Toast.makeText(this, scoroplat, Toast.LENGTH_LONG).show();
            }

            if (schetchik % 50 == 0){
                TextView work = (TextView)findViewById(R.id.money);
                int num4 = Integer.parseInt(work.getText().toString());
                if (num4 >= 8000){
                    int d = num4 - 8000;
                    work.setText(Integer.toString(d));
                    Toast.makeText(this, scoroplat2, Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(this,scoroplat3, Toast.LENGTH_LONG).show();
                    TextView g = (TextView)findViewById(R.id.apartment);
                    String s = "";
                    g.setText(s);
                    arenda = 0;
                    button.setEnabled(true);
                }
            }
        }

        if (arenda == 3){
            Button button = (Button) findViewById(R.id.button3_7);
            button.setEnabled(false);
            if (schetchik % 25 == 0){
                Toast.makeText(this, scoroplat, Toast.LENGTH_LONG).show();
            }

            if (schetchik % 50 == 0){
                TextView work = (TextView)findViewById(R.id.money);
                int num4 = Integer.parseInt(work.getText().toString());
                if (num4 >= 15000){
                    int d = num4 - 15000;
                    work.setText(Integer.toString(d));
                    Toast.makeText(this, scoroplat4, Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(this,scoroplat5, Toast.LENGTH_LONG).show();
                    TextView g = (TextView)findViewById(R.id.apartment);
                    String s = "";
                    g.setText(s);
                    arenda = 0;
                    button.setEnabled(true);
                }
            }
        }

    }
    public void kurtransp(){
        if (transport == "bike" || transport == "car" || transport == "electrosamokat"){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialogtransport);
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
            delivery = 1;
            Button p1_button = (Button)findViewById(R.id.button3_2);
            p1_button.setText(kur1);
        }
    }
    public void block(){
        if (skill < 240){
            Button button = (Button) findViewById(R.id.button6_2);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button6_2);
            button.setEnabled(true);
        }

        if (skill >= 240 && dlyap == 0){
            dlyap++;
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.congratsprog);
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

        if (buzines < 250 && skill < 240){
            Button button2 = (Button) findViewById(R.id.button7_2);
            button2.setEnabled(false);
        }
        else{
            Button button2 = (Button) findViewById(R.id.button7_2);
            button2.setEnabled(true);
            button2.setText(biz1);
        }

        if (buzines >= 250 && dlyab == 0){
            dlyab++;
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.congratsbuzines);
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

        if (arenda < 1){
            Button button = (Button) findViewById(R.id.button3_2);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button3_2);
            button.setEnabled(true);
        }

        if (arenda < 2){
            Button button = (Button) findViewById(R.id.button4_2);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button4_2);
            button.setEnabled(true);
        }

        if (arenda < 3){
            Button button = (Button) findViewById(R.id.button5_2);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button5_2);
            button.setEnabled(true);
        }

        if(arenda == 1){
            Button button = (Button) findViewById(R.id.button1_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button1_7);
            button.setEnabled(true);
        }

        if(arenda == 2){
            Button button = (Button) findViewById(R.id.button2_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button2_7);
            button.setEnabled(true);
        }

        if(arenda == 3){
            Button button = (Button) findViewById(R.id.button3_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button3_7);
            button.setEnabled(true);
        }

        if(arenda == 4){
            Button button = (Button) findViewById(R.id.button4_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button4_7);
            button.setEnabled(true);
        }

        if(arenda == 5){
            Button button = (Button) findViewById(R.id.button5_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button5_7);
            button.setEnabled(true);
        }

        if(arenda == 6){
            Button button = (Button) findViewById(R.id.button6_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button6_7);
            button.setEnabled(true);
        }

        if(arenda == 7){
            Button button = (Button) findViewById(R.id.button7_7);
            button.setEnabled(false);
        }
        else{
            Button button = (Button) findViewById(R.id.button7_7);
            button.setEnabled(true);
        }

    }
    public void endgame(){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView resp = (TextView)findViewById(R.id.respect);
        TextView stud = (TextView)findViewById(R.id.study);

        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int num3 = Integer.parseInt(m.getText().toString());
        int num4 = Integer.parseInt(resp.getText().toString());
        int num5 = Integer.parseInt(stud.getText().toString());
        if (num1 <= 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.gameoverdialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
            dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
            //Кнопка которая закрывает диалоговое окно начало
            TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(StudentLifeE.this,GlavniyEcran.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    SharedPreferences preferences = getSharedPreferences("Save",0);
                    preferences.edit().clear().apply();

                    SharedPreferences zagr = getSharedPreferences("save_fucking_game",0);
                    zagr.edit().clear().apply();
                }
            });
            //Кнопка которая закрывает диалоговое окно конец
            dialog.show();

        }
        if (num2 <= 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.gameoverdialogeda);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
            dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
            //Кнопка которая закрывает диалоговое окно начало
            TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(StudentLifeE.this,GlavniyEcran.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    SharedPreferences preferences = getSharedPreferences("Save",0);
                    preferences.edit().clear().apply();

                    SharedPreferences zagr = getSharedPreferences("save_fucking_game",0);
                    zagr.edit().clear().apply();

                }
            });
            //Кнопка которая закрывает диалоговое окно конец
            dialog.show();

        }
        if (num3 <= 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.gameoverdialogmood);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
            dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
            //Кнопка которая закрывает диалоговое окно начало
            TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(StudentLifeE.this,GlavniyEcran.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    SharedPreferences preferences = getSharedPreferences("Save",0);
                    preferences.edit().clear().apply();

                    SharedPreferences zagr = getSharedPreferences("save_fucking_game",0);
                    zagr.edit().clear().apply();
                }
            });
            //Кнопка которая закрывает диалоговое окно конец
            dialog.show();

        }
        if (num4 <= 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.gameoverdialogrespect);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
            dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
            //Кнопка которая закрывает диалоговое окно начало
            TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(StudentLifeE.this,GlavniyEcran.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    SharedPreferences preferences = getSharedPreferences("Save",0);
                    preferences.edit().clear().apply();

                    SharedPreferences zagr = getSharedPreferences("save_fucking_game",0);
                    zagr.edit().clear().apply();
                }
            });
            //Кнопка которая закрывает диалоговое окно конец
            dialog.show();

        }
        if (num5 <= 0){
            dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.gameoverdialogstudy);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
            dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
            //Кнопка которая закрывает диалоговое окно начало
            TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(StudentLifeE.this,GlavniyEcran.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    SharedPreferences preferences = getSharedPreferences("Save",0);
                    preferences.edit().clear().apply();

                    SharedPreferences zagr = getSharedPreferences("save_fucking_game",0);
                    zagr.edit().clear().apply();
                }
            });
            //Кнопка которая закрывает диалоговое окно конец
            dialog.show();
        }

    }
   public void cvet(){
       TextView zdor = (TextView)findViewById(R.id.health);
       int num1 = Integer.parseInt(zdor.getText().toString());
       String c = "#eb9c00";
       if (num1 >= 40 && num1 <= 70){
           c = "#eb9c00";
           zdor.setTextColor(Color.parseColor(c));
       }
       else if (num1 > 70){
           c = "#32cd32";
           zdor.setTextColor(Color.parseColor(c));
       }
       else if (num1 < 40){
           c = "#8b0000";
           zdor.setTextColor(Color.parseColor(c));
       }

       TextView eda = (TextView)findViewById(R.id.eat);
       int num2 = Integer.parseInt(eda.getText().toString());
       String a = "#eb9c00";
       if (num2 >= 40 && num2 <= 70){
           a = "#eb9c00";
           eda.setTextColor(Color.parseColor(a));
       }
       else if (num2 > 70){
           a = "#32cd32";
           eda.setTextColor(Color.parseColor(a));
       }
       else if (num2 < 40){
           a = "#8b0000";
           eda.setTextColor(Color.parseColor(a));
       }

       TextView m = (TextView)findViewById(R.id.mood);
       int num3 = Integer.parseInt(m.getText().toString());
       String b = "#eb9c00";
       if (num3 >= 40 && num3 <= 70){
           b = "#eb9c00";
           m.setTextColor(Color.parseColor(b));
       }
       else if (num3 > 70){
           b = "#32cd32";
           m.setTextColor(Color.parseColor(b));
       }
       else if (num3 < 40){
           b = "#8b0000";
           m.setTextColor(Color.parseColor(b));
       }

       TextView resp = (TextView)findViewById(R.id.respect);
       int num4 = Integer.parseInt(resp.getText().toString());
       String d = "#eb9c00";
       if (num4 >= 40 && num4 <= 70){
           d = "#eb9c00";
           resp.setTextColor(Color.parseColor(d));
       }
       else if (num4 > 70){
           d = "#32cd32";
           resp.setTextColor(Color.parseColor(d));
       }
       else if (num4 < 40){
           d = "#8b0000";
           resp.setTextColor(Color.parseColor(d));
       }

       TextView stud = (TextView)findViewById(R.id.study);
       int num5 = Integer.parseInt(stud.getText().toString());
       String e = "#eb9c00";
       if (num5 >= 40 && num5 <= 70){
           e = "#eb9c00";
           stud.setTextColor(Color.parseColor(e));
       }
       else if (num5 > 70){
           e = "#32cd32";
           stud.setTextColor(Color.parseColor(e));
       }
       else if (num5 < 40){
           e = "#8b0000";
           stud.setTextColor(Color.parseColor(e));
       }
       arend();
   }

    public void Doest_ostatki_v_stolovke(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }

        TextView eda = (TextView)findViewById(R.id.eat);
        TextView resp = (TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(eda.getText().toString());
        int num2 = Integer.parseInt(resp.getText().toString());
        int a = num1 +20;
        int b = num2 - 10;

        if (a <= 100){
            eda.setText(Integer.toString(a));
        }
        if (a > 100){
            int q = a % 10;//5
            int x = a - q;//110
            int l = (x / 10) % 10;
            int g = x - (l * 10);
            eda.setText(Integer.toString(g));
        }


        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            resp.setText(Integer.toString(g));
        }
        else
            {
                resp.setText(Integer.toString(b));
            }


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        cvet();
        endgame();
        save();
    }
    int tost = 0;
    public void Salat_is_ovoce(View v){

        TextView eda = (TextView)findViewById(R.id.eat);
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());

        if (num3 >= 30){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 30;
            work.setText(Integer.toString(c));

            int num1 = Integer.parseInt(eda.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +10;
            int b = num2 + 5;

            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }

            if (b <= 100 ){
                zdor.setText(Integer.toString(b));
            }
            else{
                int q = b % 10;
                int w = b - q;
                zdor.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }
       if (num3 < 30){
           tost++;
           if (tost <=3){
               Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
           }
       }
       else{
           tost = 0;
       }

        cvet();
        endgame();
        save();
    }

    public void doshik(View v){

        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());
        if (num3 >= 45){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 45;
            work.setText(Integer.toString(c));
            TextView eda = (TextView)findViewById(R.id.eat);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(eda.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +20;
            int b = num2 - 5;
            eda.setText(Integer.toString(a));
            zdor.setText(Integer.toString(b));

            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }

            if(b <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(b));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 45){
            tost++;
            if (tost <=3){
                Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }

    public void pokushat_v_stolovke(View v){
        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());

        if (num3 >= 100){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 100;
            work.setText(Integer.toString(c));
            TextView eda = (TextView)findViewById(R.id.eat);
            int num1 = Integer.parseInt(eda.getText().toString());
            int a = num1 +40;

            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 100){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void eat_shaurma(View v){
        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());

        if (num3 >= 150){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 150;
            work.setText(Integer.toString(c));
            TextView eda = (TextView)findViewById(R.id.eat);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(eda.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +50;
            int b = num2 - 5;


            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }


            if(b <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(b));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 150){
            tost++;
            if (tost <=3){
                Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }

    public void gora(View v){
        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());

        if (num3 >= 700){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 700;
            work.setText(Integer.toString(c));
            TextView eda = (TextView)findViewById(R.id.eat);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(eda.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +70;
            int b = num2 - 15;


            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }

            if(b <= 0){
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(b));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 700){
            tost++;
            if (tost <=3){
                Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void restourant(View v){
        TextView work = (TextView)findViewById(R.id.money);
        int num3 = Integer.parseInt(work.getText().toString());

        if (num3 >= 1500){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }

            int c = num3 - 1500;
            work.setText(Integer.toString(c));
            TextView eda = (TextView)findViewById(R.id.eat);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(eda.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +90;
            int b = num2 + 20;

            if (a <= 100){
                eda.setText(Integer.toString(a));
            }
            if (a > 100){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                eda.setText(Integer.toString(g));
            }

            if (b <= 100){
                zdor.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = b % 10;//5
                int x = b - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                zdor.setText(Integer.toString(g));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 1500){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
        //Работа
    public void fontan(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }

        TextView work = (TextView)findViewById(R.id.money);
        TextView authoritet =(TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(work.getText().toString());
        int num2 = Integer.parseInt(authoritet.getText().toString());
        int a = num1 + 10;
        int b = num2 - 2;
        work.setText(Integer.toString(a));


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }

        TextView eda = (TextView)findViewById(R.id.eat);
        int num3 = Integer.parseInt(eda.getText().toString());
        int c = num3 - 5;
        eda.setText(Integer.toString(c));

        TextView stud =(TextView)findViewById(R.id.study);
        int num4 = Integer.parseInt(stud.getText().toString());
        int d = num4 - 5;

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            authoritet.setText(Integer.toString(g));
        }
        else
        {
            authoritet.setText(Integer.toString(b));
        }

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }

        if(d <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            stud.setText(Integer.toString(g));
        }
        else
        {
            stud.setText(Integer.toString(d));
        }
        cvet();
        endgame();
        save();
    }
    public void listovki(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }

        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(work.getText().toString());
        int a = num1 + 50;
        work.setText(Integer.toString(a));

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        TextView eda = (TextView)findViewById(R.id.eat);
        int num3 = Integer.parseInt(eda.getText().toString());
        int c = num3 - 5;

        TextView stud =(TextView)findViewById(R.id.study);
        int num4 = Integer.parseInt(stud.getText().toString());
        int d = num4 - 5;

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }

        if(d <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            stud.setText(Integer.toString(g));
        }
        else
        {
            stud.setText(Integer.toString(d));
        }
        cvet();
        endgame();
        save();
    }
    public void kura(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }

        if (delivery == 1){
            TextView work = (TextView)findViewById(R.id.money);
            int num1 = Integer.parseInt(work.getText().toString());
            int a = num1 + 200;
            work.setText(Integer.toString(a));

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            TextView eda = (TextView)findViewById(R.id.eat);
            int num3 = Integer.parseInt(eda.getText().toString());
            int c = num3 - 5;


            TextView stud =(TextView)findViewById(R.id.study);
            int num4 = Integer.parseInt(stud.getText().toString());
            int d = num4 - 5;

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            if(d <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                stud.setText(Integer.toString(g));
            }
            else
            {
                stud.setText(Integer.toString(d));
            }
            cvet();
            endgame();
            save();
        }
        else{
            TextView work = (TextView)findViewById(R.id.money);
            int num1 = Integer.parseInt(work.getText().toString());
            int a = num1 + 100;
            work.setText(Integer.toString(a));

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            TextView eda = (TextView)findViewById(R.id.eat);
            int num3 = Integer.parseInt(eda.getText().toString());
            int c = num3 - 5;


            TextView stud =(TextView)findViewById(R.id.study);
            int num4 = Integer.parseInt(stud.getText().toString());
            int d = num4 - 5;

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            if(d <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                stud.setText(Integer.toString(g));
            }
            else
            {
                stud.setText(Integer.toString(d));
            }
            cvet();
            endgame();
            save();
        }

    }
    public void otobrat(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        TextView work = (TextView)findViewById(R.id.money);
        TextView authoritet =(TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(work.getText().toString());
        int num2 = Integer.parseInt(authoritet.getText().toString());
        int a = num1 + 200;
        int b = num2 - 30;
        work.setText(Integer.toString(a));


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }

        TextView eda = (TextView)findViewById(R.id.eat);
        int num3 = Integer.parseInt(eda.getText().toString());
        int c = num3 - 10;


        TextView stud =(TextView)findViewById(R.id.study);
        int num4 = Integer.parseInt(stud.getText().toString());
        int d = num4 - 10;

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            authoritet.setText(Integer.toString(g));
        }
        else
        {
            authoritet.setText(Integer.toString(b));
        }


        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }

        if(d <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            stud.setText(Integer.toString(g));
        }
        else
        {
            stud.setText(Integer.toString(d));
        }
        cvet();
        endgame();
        save();
    }

    public void ograbit(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        TextView work = (TextView)findViewById(R.id.money);
        TextView authoritet =(TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(work.getText().toString());
        int num2 = Integer.parseInt(authoritet.getText().toString());
        int a = num1 + 5000;
        int b = num2 - 30;
        work.setText(Integer.toString(a));

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }

        TextView eda = (TextView)findViewById(R.id.eat);
        int num3 = Integer.parseInt(eda.getText().toString());
        int c = num3 - 30;


        TextView stud =(TextView)findViewById(R.id.study);
        int num4 = Integer.parseInt(stud.getText().toString());
        int d = num4 - 30;

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            authoritet.setText(Integer.toString(g));
        }
        else
        {
            authoritet.setText(Integer.toString(b));
        }


        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }

        if(d <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            stud.setText(Integer.toString(g));
        }
        else
        {
            stud.setText(Integer.toString(d));
        }
        cvet();
        endgame();
        save();
    }
    public void programm(View v){

        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
            TextView work = (TextView)findViewById(R.id.money);
            int num1 = Integer.parseInt(work.getText().toString());
            int a = num1 + 10000;
            work.setText(Integer.toString(a));

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }

            TextView eda = (TextView)findViewById(R.id.eat);
            int num3 = Integer.parseInt(eda.getText().toString());
            int c = num3 - 20;

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }
            cvet();
            endgame();
            save();

    }
    public void business(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(work.getText().toString());
        int a = num1 + 100000;
        work.setText(Integer.toString(a));

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }

        TextView eda = (TextView)findViewById(R.id.eat);
        int num3 = Integer.parseInt(eda.getText().toString());
        int c = num3 - 20;


        TextView stud =(TextView)findViewById(R.id.study);
        int num4 = Integer.parseInt(stud.getText().toString());
        int d = num4 - 20;

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }

        if(d <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            stud.setText(Integer.toString(g));
        }
        else
        {
            stud.setText(Integer.toString(d));
        }
        cvet();
        endgame();
        save();
    }
    int c = 0;//Для витаминок
    public void vitamin(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = c + 1;
        if (c < 4){
            TextView stud = (TextView)findViewById(R.id.study);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(stud.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            int a = num1 +5;
            int b = num2 + 5;

            if (a <= 100){
                stud.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    stud.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    stud.setText(Integer.toString(w));
                }
            }

            if (b <= 100 ){
                zdor.setText(Integer.toString(b));
            }
            else{
                int q = b % 10;
                int w = b - q;
                zdor.setText(Integer.toString(w));
            }
        }
        if(c == 4) {
            TextView stud = (TextView)findViewById(R.id.study);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(stud.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());
            Toast.makeText(this,glicin, Toast.LENGTH_SHORT).show();
            int d = num1 - 5;
            stud.setText(Integer.toString(d));
            int g = num2 - 40;
            zdor.setText(Integer.toString(g));
        }
        if (c > 4){
            TextView stud = (TextView)findViewById(R.id.study);
            TextView zdor = (TextView)findViewById(R.id.health);
            int num1 = Integer.parseInt(stud.getText().toString());
            int num2 = Integer.parseInt(zdor.getText().toString());

            int d = num1 - 5;
            int u = num2 - 5;
            if(d <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                stud.setText(Integer.toString(g));
            }
            else{
                stud.setText(Integer.toString(u));
            }

            if(u <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(u));
            }

        }

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }

        cvet();
        endgame();
        save();
    }
    public void domashka(View v){
        skill++;

        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int a = num1 +10;
        int b = num2 - 5;
        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        block();
        cvet();
        endgame();
        save();
    }
    public void inyz(View v){
        skill = skill + 1;
        buzines = buzines + 1;
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView m = (TextView)findViewById(R.id.mood);
        int num3 = Integer.parseInt(m.getText().toString());
        int c = num3 + 10;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int a = num1 + 20;
        int b = num2 - 10;

        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }
        if (c <= 100){
            m.setText(Integer.toString(c));
        }
        if (c > 100){
            if (c % 10 != 0){
                int q = c % 10;//5
                int x = c - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                m.setText(Integer.toString(g));
            }
            else{
                int q = (c/10) % 10 * 10;
                int w = c - q;
                m.setText(Integer.toString(w));
            }
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        block();
        cvet();
        endgame();
        save();
    }
    public void math(View v){
        buzines = buzines + 1;
        skill = skill + 2;
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView m = (TextView)findViewById(R.id.mood);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int num3 = Integer.parseInt(m.getText().toString());
        int a = num1 +40;
        int b = num2 - 15;
        int c = num3 - 20;


        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            m.setText(Integer.toString(g));
        }
        else
        {
            m.setText(Integer.toString(c));
        }



        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        block();
        cvet();
        endgame();
        save();
    }
    public void podlizat(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView ath = (TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int num3 = Integer.parseInt(ath.getText().toString());
        int a = num1 + 40;
        int b = num2 - 10;
        int c = num3 - 40;

        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            ath.setText(Integer.toString(g));
        }
        else
        {
            ath.setText(Integer.toString(c));
        }


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        cvet();
        endgame();
        save();
    }
    public void book(View v){
        buzines = buzines + 2;
        skill = skill + 1;
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView m = (TextView)findViewById(R.id.mood);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int num3 = Integer.parseInt(m.getText().toString());
        int a = num1 + 60;
        int b = num2 - 40;
        int c = num3 + 20;

        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }
        if (c <= 100){
            m.setText(Integer.toString(c));
        }
        if (c > 100){
            int q = c % 10;//5
            int x = c - q;//110
            int l = (x / 10) % 10;
            int g = x - (l * 10);
            m.setText(Integer.toString(g));
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        block();
        cvet();
        endgame();
        save();
    }
    public void uchitprogramm(View v){
        buzines = buzines + 1;
        skill = skill + 3;
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        c = 0;
        TextView stud = (TextView)findViewById(R.id.study);
        TextView eda = (TextView)findViewById(R.id.eat);
        int num1 = Integer.parseInt(stud.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());
        int a = num1 +90;
        int b = num2 - 60;

        if (a <= 100){
            stud.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                stud.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                stud.setText(Integer.toString(w));
            }
        }
        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        block();
        cvet();
        endgame();
        save();
    }
    public void rest(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int a = num1 + 10;
        int b = num2 + 5;
        int c = num3 - 20;


        if (a <= 100){
            zdor.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                zdor.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                zdor.setText(Integer.toString(w));
            }
        }

        if (b <= 100){
            m.setText(Integer.toString(b));
        }
        if (b > 100){
            int q = b % 10;
            int w = b - q;
            m.setText(Integer.toString(w));
        }

        if(c <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(c));
        }


        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        cvet();
        endgame();
        save();
    }
    public void romachka(View v){
        TextView work = (TextView)findViewById(R.id.money);
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(work.getText().toString());
        if (num3 >= 50){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 20;
            int b = num2 + 5;
            int c = num3 - 50;

            work.setText(Integer.toString(c));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = b % 10;
                int w = b - q;
                m.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 50){
            tost++;
            if (tost <=3){
                Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void pill(View v){
        TextView work = (TextView)findViewById(R.id.money);
        TextView zdor = (TextView)findViewById(R.id.health);
        int num3 = Integer.parseInt(work.getText().toString());
        int num1 = Integer.parseInt(zdor.getText().toString());
        if (num3 >= 100){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int c = num3 - 100;
            int a = num1 + 30;
            work.setText(Integer.toString(c));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 100){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void gosp(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView work = (TextView)findViewById(R.id.money);
        TextView m = (TextView)findViewById(R.id.mood);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(work.getText().toString());
        int num3 = Integer.parseInt(m.getText().toString());
        if (num2 >=1000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 50;
            int b = num2 - 1000;
            int c = num3 - 20;
            work.setText(Integer.toString(b));


            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                m.setText(Integer.toString(g));
            }
            else
            {
                m.setText(Integer.toString(c));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num2 < 1000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void lichvrach(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(work.getText().toString());
        if (num3 >= 5000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 60;
            int b = num2 + 10;
            int c = num3 - 5000;

            work.setText(Integer.toString(c));
            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = (b/10) % 10 * 10;
                int w = b - q;
                m.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num3 < 5000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void sanatoriy(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 30000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 80;
            int b = num2 + 20;
            int c = num3 + 20;
            int d = num4 - 30000;
            work.setText(Integer.toString(d));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = (b/10) % 10 * 10;
                int w = b - q;
                m.setText(Integer.toString(w));
            }

            if (c <= 100){
                eda.setText(Integer.toString(c));
            }
            if (c > 100){
                int q = (c/10) % 10 * 10;
                int w = c - q;
                eda.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 30000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void gospvip(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 700000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 90;
            int b = num2 + 50;
            int c = num3 + 50;
            int d = num4 - 700000;

            work.setText(Integer.toString(d));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = (b/10) % 10 * 10;
                int w = b - q;
                m.setText(Integer.toString(w));
            }

            if (c <= 100){
                eda.setText(Integer.toString(c));
            }
            if (c > 100){
                int q = (c/10) % 10 * 10;
                int w = c - q;
                eda.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 700000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void medit(View v){
        if (vibro == 0){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        int num1 = Integer.parseInt(m.getText().toString());
        int num2 = Integer.parseInt(eda.getText().toString());

        int a = num1 + 10;
        int b = num2 - 10;

        if (a <= 100){
            m.setText(Integer.toString(a));
        }
        if (a > 100){
            if (a % 10 != 0){
                int q = a % 10;//5
                int x = a - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);
                m.setText(Integer.toString(g));
            }
            else{
                int q = (a/10) % 10 * 10;
                int w = a - q;
                m.setText(Integer.toString(w));
            }
        }

        if(b <= 0){
            //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
            int g = 0;
            eda.setText(Integer.toString(g));
        }
        else
        {
            eda.setText(Integer.toString(b));
        }

        schetchik = schetchik + 1;
        if (schetchik % 100 == 0){
            TextView vozrast = (TextView)findViewById(R.id.vozrast);
            int age = Integer.parseInt(vozrast.getText().toString());
            age++;
            vozrast.setText(Integer.toString(age));
        }
        cvet();
        endgame();
        save();
    }
    public void zoo(View v){
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 50){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int b = num2 + 20;
            int c = num3 - 10;
            int d = num4 - 50;
            work.setText(Integer.toString(d));

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                if (b % 10 != 0){
                    int q = b % 10;//5
                    int x = b - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (b/10) % 10 * 10;
                    int w = b - q;
                    m.setText(Integer.toString(w));
                }
            }

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 50){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void computer(View v){
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 100){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int b = num2 + 40;
            int c = num3 - 10;
            int d = num4 - 100;
            work.setText(Integer.toString(d));

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                if (b % 10 != 0){
                    int q = b % 10;//5
                    int x = b - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (b/10) % 10 * 10;
                    int w = b - q;
                    m.setText(Integer.toString(w));
                }
            }
            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 100){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void govno(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        TextView auth = (TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        int num5 = Integer.parseInt(auth.getText().toString());
        if (num4 >= 200){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 - 50;
            int b = num2 + 40;
            int c = num3 - 40;
            int d = num4 - 200;
            int i = num5 - 50;
            work.setText(Integer.toString(d));

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                if (b % 10 != 0){
                    int q = b % 10;//5
                    int x = b - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (b/10) % 10 * 10;
                    int w = b - q;
                    m.setText(Integer.toString(w));
                }
            }

            if(a <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(a));
            }

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            if(i <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                auth.setText(Integer.toString(g));
            }
            else
            {
                auth.setText(Integer.toString(i));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 200){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void gym(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        TextView auth = (TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        int num5 = Integer.parseInt(auth.getText().toString());
        if (num4 >= 500){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 20;
            int b = num2 + 50;
            int c = num3 - 30;
            int d = num4 - 500;
            int i = num5 + 30;
            work.setText(Integer.toString(d));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    zdor.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    zdor.setText(Integer.toString(w));
                }
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                if (b % 10 != 0){
                    int q = b % 10;//5
                    int x = b - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (b/10) % 10 * 10;
                    int w = b - q;
                    m.setText(Integer.toString(w));
                }
            }

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            if (i > 100){
                if (i % 10 != 0){
                    int q = i % 10;//5
                    int x = i - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    auth.setText(Integer.toString(g));
                }
                else{
                    int q = (i/10) % 10 * 10;
                    int w = i - q;
                    auth.setText(Integer.toString(w));
                }
            }
            else{
                auth.setText(Integer.toString(i));
            }
            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 500){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void club(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        TextView auth = (TextView)findViewById(R.id.respect);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        int num5 = Integer.parseInt(auth.getText().toString());
        if (num4 >= 3000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 - 20;
            int b = num2 + 50;
            int c = num3 - 20;
            int d = num4 - 3000;
            int i = num5 - 20;
            work.setText(Integer.toString(d));

            if(a <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                zdor.setText(Integer.toString(g));
            }
            else
            {
                zdor.setText(Integer.toString(a));
            }

            if(c <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                eda.setText(Integer.toString(g));
            }
            else
            {
                eda.setText(Integer.toString(c));
            }

            if(i <= 0){
                //Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT).show();
                int g = 0;
                auth.setText(Integer.toString(g));
            }
            else
            {
                auth.setText(Integer.toString(i));
            }

            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                if (b % 10 != 0){
                    int q = b % 10;//5
                    int x = b - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (b/10) % 10 * 10;
                    int w = b - q;
                    m.setText(Integer.toString(w));
                }
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 3000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void more(View v){
        TextView zdor = (TextView)findViewById(R.id.health);
        TextView m = (TextView)findViewById(R.id.mood);
        TextView eda = (TextView)findViewById(R.id.eat);
        TextView work = (TextView)findViewById(R.id.money);
        int num1 = Integer.parseInt(zdor.getText().toString());
        int num2 = Integer.parseInt(m.getText().toString());
        int num3 = Integer.parseInt(eda.getText().toString());
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 50000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int a = num1 + 10;
            int b = num2 + 90;
            int c = num3 + 10;
            int d = num4 - 50000;

            work.setText(Integer.toString(d));

            if (a <= 100){
                zdor.setText(Integer.toString(a));
            }
            if (a > 100){
                if (a % 10 != 0){
                    int q = a % 10;//5
                    int x = a - q;//110
                    int l = (x / 10) % 10;
                    int g = x - (l * 10);
                    m.setText(Integer.toString(g));
                }
                else{
                    int q = (a/10) % 10 * 10;
                    int w = a - q;
                    m.setText(Integer.toString(w));
                }
            }


            if (b <= 100){
                m.setText(Integer.toString(b));
            }
            if (b > 100){
                int q = b % 10;//5
                int x = b - q;//110
                int l = (x / 10) % 10;
                int g = x - (l * 10);

                m.setText(Integer.toString(g));
            }

            if (c <= 100){
                eda.setText(Integer.toString(c));
            }
            if (c > 100){
                int q = (c/10) % 10 * 10;
                int w = c - q;
                eda.setText(Integer.toString(w));
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 50000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        cvet();
        endgame();
        save();
    }
    public void roliki(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car1);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 1000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 1000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button1_6);
            button.setEnabled(false);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 1000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        save();

    }
    public void samokat(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car2);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 5000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 5000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button2_6);
            button.setEnabled(false);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 5000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void bike(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car3);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 10000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 10000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button3_6);
            button.setEnabled(false);

            if (transport == ""){
                transport = "bike";
                kurtransp();
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 10000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void electrosamokat(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car4);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 30000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 30000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button4_6);
            button.setEnabled(false);

            if (transport == ""){
                transport = "electrosamokat";
                kurtransp();
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 30000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void goldroliki(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car5);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 100000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 100000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button5_6);
            button.setEnabled(false);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 100000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void machina(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car6);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 300000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 300000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button6_6);
            button.setEnabled(false);

            if (transport == ""){
                transport = "car";
                kurtransp();
            }

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 300000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void vert(View v){
        TextView t = (TextView)findViewById(R.id.car);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_car7);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 10000000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 10000000;
            work.setText(Integer.toString(d));
            t.setText(s);

            Button button = (Button) findViewById(R.id.button7_6);
            button.setEnabled(false);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 10000000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        save();
    }
    public void bigpalat(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_apart1);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 5000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 5000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            arenda = 1;
        }

        if (num4 < 5000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        block();
        save();
    }
    public void kompan(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_apart2);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 8000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 8000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;

            arenda = 2;

            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }

        }

        if (num4 < 8000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        arend();
        block();
        save();
    }
    public void kvarkomuns(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s =getResources().getString(R.string.t_student_apart3);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 15000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 15000;
            work.setText(Integer.toString(d));
            g.setText(s);

            arenda = 3;

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
        }

        if (num4 < 15000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }
        arend();
        block();
        save();
    }
    public void kompansvoi(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_apart4);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 50000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 50000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            arenda = 4;
        }

        if (num4 < 50000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        block();
        save();
    }
    public void kvark(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_apart5);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 3000000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 3000000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            arenda = 5;
        }

        if (num4 < 3000000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        block();
        save();
    }
    public void dom(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s =getResources().getString(R.string.t_student_apart5);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 10000000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 10000000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            arenda = 6;
        }

        if (num4 < 10000000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        block();
        save();

    }
    public void villa(View v){
        TextView g = (TextView)findViewById(R.id.apartment);
        TextView work = (TextView)findViewById(R.id.money);
        String s = getResources().getString(R.string.t_student_apart7);
        int num4 = Integer.parseInt(work.getText().toString());
        if (num4 >= 100000000){
            if (vibro == 0){
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(100);
                }
            }
            int d = num4 - 100000000;
            work.setText(Integer.toString(d));
            g.setText(s);

            schetchik = schetchik + 1;
            if (schetchik % 100 == 0){
                TextView vozrast = (TextView)findViewById(R.id.vozrast);
                int age = Integer.parseInt(vozrast.getText().toString());
                age++;
                vozrast.setText(Integer.toString(age));
            }
            arenda = 7;
        }

        if (num4 < 100000000){
            tost++;
            if (tost <=3){
                Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            tost = 0;
        }

        block();
        save();
    }



}