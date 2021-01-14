package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class Meniu extends AppCompatActivity {
    private Button Filme;
    private Button Lista;
    private Button Vizionate;
    private Button Oscar;
    private Button Statistici;
    private Switch switchTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);
        Filme =(Button)findViewById(R.id.btnFilme);
        Lista=(Button)findViewById(R.id.btnLista);
        Vizionate=(Button)findViewById(R.id.btnVizionate);
        Oscar=(Button)findViewById(R.id.btnOscar);
        Statistici=(Button)findViewById(R.id.btnStatistici);
        switchTheme=(Switch)findViewById(R.id.switchTheme);



        Filme.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View view) {
                                         Toast.makeText(Meniu.this, "Vizionati cele mai bune filme!", Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(Meniu.this, FilmeDiscover.class));
                                     }
                                 }

        );
        Lista.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View view) {
                                         Toast.makeText(Meniu.this, "Filmele pe care doriti sa le vizionati", Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(Meniu.this, ListaMea.class));
                                     }
                                 }

        );
        Vizionate.setOnClickListener(new View.OnClickListener()
                                     {
                                         public void onClick(View view) {
                                             Toast.makeText(Meniu.this, "Filmele pe care le-ati vizionat", Toast.LENGTH_SHORT).show();
                                             startActivity(new Intent(Meniu.this, com.example.movieapp.Vizionate.class));
                                         }
                                     }

        );
        Oscar.setOnClickListener(new View.OnClickListener()
                                     {
                                         public void onClick(View view) {
                                             Toast.makeText(Meniu.this, "Filmele premiate cu Oscar", Toast.LENGTH_SHORT).show();
                                             startActivity(new Intent(Meniu.this, com.example.movieapp.Oscar.class));
                                         }
                                     }

        );

        Statistici.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View view) {
                                         Toast.makeText(Meniu.this, "Statistici filme", Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(Meniu.this, com.example.movieapp.Statistici.class));
                                     }
                                 }

        );

         //switchTheme.setOnClickListener(view.onClickListener{
            // it:view!
            //movieapp.
        //});




    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meniu2, m);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemListaMea:
                Toast.makeText(this,"Filmele pe care doriti sa le vizionati", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Meniu.this, ListaMea.class));
                break;
            case R.id.itemDiscover:
                Toast.makeText(this,"Descoperiti filme", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Meniu.this, FilmeDiscover.class));
                break;
            case R.id.itemFilmeViz:
                Toast.makeText(this,"Filmele pe care le-ati vizionat", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Meniu.this, Vizionate.class));
                break;
            case R.id.itemLogOut:
                Toast.makeText(this,"Pagina de login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Meniu.this, MainActivity.class));
                break;
            case R.id.itemRaporteaza:
                Toast.makeText(this,"Raportati problema pe care o aveti", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Meniu.this, Raporteaza.class));
                break;
            default: return  super.onOptionsItemSelected(item);

        }
        return false;
    }



}