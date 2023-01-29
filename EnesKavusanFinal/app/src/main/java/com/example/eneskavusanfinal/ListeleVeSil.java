package com.example.eneskavusanfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeleVeSil extends AppCompatActivity {

    ListView lv;
    Button geridon;
    ArrayAdapter<String> adapter;
    ArrayList<String> listele = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();
    SQLite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele_ve_sil);

        lv = findViewById(R.id.lv);
        geridon = findViewById(R.id.button10);
        db = new SQLite(this);

        Cursor c = db.rehbergetir();
        if(c.moveToFirst()){
            do {
                listele.add(c.getString(1)+ " " + c.getString(2)+ " "+ c.getString(3));
                id.add(c.getInt(0));

            }while (c.moveToNext());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,listele);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listele.remove(i);
                db.rehbersil(id.get(i)+"");
                adapter.notifyDataSetChanged();
            }
        });

        geridon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniaktivite=new Intent(ListeleVeSil.this,AnaMenu.class);
                startActivity(yeniaktivite);
            }
        });
    }
}