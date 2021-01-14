package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Oscar extends AppCompatActivity {
    private List<Film> oscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oscar);

    }
    public void arataOscar(View view) {
        oscar = new ArrayList<>();
        Film lista1 = new Film("Titanic","rom",120,1999,"Steven",7,5);
        Film lista2 = new Film("The Godfather","action",200 ,1995,"A",9,9);
        oscar.add(lista1);
        oscar.add(lista2);

        ListView listView = findViewById(R.id.listview_filme);

        FilmAdapter adapter = new FilmAdapter(oscar, this);
        listView.setAdapter(adapter);

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
                startActivity(new Intent(Oscar.this, ListaMea.class));
                break;
            case R.id.itemDiscover:
                Toast.makeText(this,"Descoperiti filme", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Oscar.this, FilmeDiscover.class));
                break;
            case R.id.itemFilmeViz:
                Toast.makeText(this,"Filmele pe care le-ati vizionat", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Oscar.this, Vizionate.class));
                break;
            case R.id.itemLogOut:
                Toast.makeText(this,"Pagina de login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Oscar.this, MainActivity.class));
                break;
            case R.id.itemRaporteaza:
                Toast.makeText(this,"Raportati problema pe care o aveti", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Oscar.this, Raporteaza.class));
                break;
            default: return  super.onOptionsItemSelected(item);

        }
        return false;
    }
}