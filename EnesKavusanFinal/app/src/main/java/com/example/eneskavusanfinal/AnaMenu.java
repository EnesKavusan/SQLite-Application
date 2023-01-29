package com.example.eneskavusanfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnaMenu extends AppCompatActivity {
    Button yeniBilgi;
    Button duzenle;
    Button listele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);

        yeniBilgi = findViewById(R.id.button2);
        duzenle = findViewById(R.id.button3);
        listele = findViewById(R.id.button4);

        yeniBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniaktivite=new Intent(AnaMenu.this,YeniBilgi.class);
                startActivity(yeniaktivite);
            }
        });

        duzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniaktivite=new Intent(AnaMenu.this,Duzenle.class);
                startActivity(yeniaktivite);
            }
        });

        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniaktivite=new Intent(AnaMenu.this,ListeleVeSil.class);
                startActivity(yeniaktivite);
            }
        });
    }
}