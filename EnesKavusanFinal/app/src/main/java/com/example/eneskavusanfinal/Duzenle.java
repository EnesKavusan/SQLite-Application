package com.example.eneskavusanfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Duzenle extends AppCompatActivity implements View.OnClickListener{

    EditText aiig,bos1,bos2;
    Button ara,degistir,geri;
    SQLite db;
    Integer index;
    ArrayList<String> isimgirarray = new ArrayList<>();
    ArrayList<String> telgirarray = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duzenle);

        aiig = findViewById(R.id.editTextTextPersonName3);
        bos1 = findViewById(R.id.editTextTextPersonName4);
        bos2 = findViewById(R.id.editTextNumber2);
        ara = findViewById(R.id.button7);
        degistir = findViewById(R.id.button8);
        geri = findViewById(R.id.button9);
        db = new SQLite(this);
        ara.setOnClickListener(this);
        degistir.setOnClickListener(this);
        geri.setOnClickListener(this);

        Cursor c = db.rehbergetir();
        if(c.moveToFirst()){
            do {
                isimgirarray.add(c.getString(1));
                telgirarray.add(c.getString(2));
                id.add(c.getInt(0));

            }while (c.moveToNext());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button7:
                if(aiig.getText().toString().equals("")){
                    Toast.makeText(this, "Lütfen aramak istediğiniz ismi giriniz!", Toast.LENGTH_SHORT).show();
                }
                else{
                    for (int i=0;i<isimgirarray.size();i++){
                        if(isimgirarray.get(i).equals(aiig.getText().toString())){
                            bos1.setText(isimgirarray.get(i));
                            bos2.setText(telgirarray.get(i));
                            index = i;
                            break;
                        }
                        else{
                            Toast.makeText(this, "Girdiğiniz isim bulunamamaktadır!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;

            case R.id.button8:
                isimgirarray.set(index,aiig.getText().toString());
                telgirarray.set(index,bos2.getText().toString());
                db.rehberduzenle(id.get(index),bos1.getText().toString(),bos2.getText().toString());
                bos1.setText("");
                bos2.setText("");
                break;

            case R.id.button9:
                Intent yeniaktivite=new Intent(Duzenle.this,AnaMenu.class);
                startActivity(yeniaktivite);
                break;
        }
    }
}