package com.example.eneskavusanfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteAbortException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class YeniBilgi extends AppCompatActivity implements View.OnClickListener{

    EditText isimgir,telgir;
    Button artı,geridon;
    Spinner sp;
    Integer spin;

    String[] Akrabalık = {"Akrabalık","Dede","Nene","Anne","Baba","Kardeş","Amca","Dayı","Hala","Teyze","Kuzen"};
    ArrayAdapter<String> adapter;
    SQLite db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_bilgi);

        isimgir = findViewById(R.id.editTextTextPersonName2);
        telgir = findViewById(R.id.editTextNumber);
        artı = findViewById(R.id.button5);
        geridon = findViewById(R.id.button6);
        db = new SQLite(this);
        sp = findViewById(R.id.spinner);
        artı.setOnClickListener(this);
        geridon.setOnClickListener(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Akrabalık);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button5:
                if(Akrabalık[spin].equals("Akrabalık")|| isimgir.getText().toString().equals("") || telgir.getText().toString().equals("")){
                    Toast.makeText(this, "Lütfen gerekli alanları doldurunuz!", Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        db.rehberekle(isimgir.getText().toString().trim(), telgir.getText().toString().trim(),Akrabalık[spin]);
                        Toast.makeText(YeniBilgi.this, "Girmiş olduğunuz bilgiler eklendi!", Toast.LENGTH_SHORT).show();
                    } finally {
                        db.close();
                    }
                }


                break;
            case R.id.button6:
                Intent geri = new Intent(YeniBilgi.this, AnaMenu.class);
                startActivity(geri);
                break;

        }
    }
}
