package com.example.eneskavusanfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText kadi,sifre;
    Button giris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kadi = findViewById(R.id.editTextTextPersonName);
        sifre = findViewById(R.id.editTextTextPassword);
        giris = findViewById(R.id.button);

       giris.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (kadi.getText().toString().equals("enes") && sifre.getText().toString().equals("19000113")){
                   Intent yeniaktivite=new Intent(MainActivity.this,AnaMenu.class);
                   startActivity(yeniaktivite);
               }
               else{
                   Toast.makeText(MainActivity.this, "Kullanıcı adınız ve şifreniz uyuşmamaktadır!", Toast.LENGTH_SHORT).show();
               }

              
           }
       });
    }

}