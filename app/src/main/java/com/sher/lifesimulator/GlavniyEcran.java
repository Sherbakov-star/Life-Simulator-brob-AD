package com.sher.lifesimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GlavniyEcran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_glavniy_ecran);
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
    }

    public void onMyButtonClick(View view) {
       //Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(GlavniyEcran.this,Menu.class);
        //overridePendingTransitions(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        //startActivity(intent);finish();

    }
}