package com.example.padtm_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
        ArrayAdapter gatunki = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] {"Pies", "Kot", "Rybki"});
        Spinner gatunek = (Spinner) findViewById(R.id.editGatunek);
        gatunek.setAdapter(gatunki);
    }

    public void wyslij (View view)
    {
        EditText kolor = (EditText) findViewById(R.id.editKolor);
        EditText wielkosc = (EditText) findViewById (R.id.editWielkosc);
        EditText opis = (EditText) findViewById(R.id.editOpis);
        Spinner gatunek = (Spinner) findViewById(R.id.editGatunek);
        Animal zwierze = new Animal(
                gatunek.getSelectedItem().toString(),
                kolor.getText().toString(),
                Float.valueOf(wielkosc.getText().toString()),
                opis.getText().toString()
        );
        Intent intencja = new Intent();
        intencja.putExtra("nowy", zwierze);
        setResult(RESULT_OK, intencja);
        finish();
    }


}
