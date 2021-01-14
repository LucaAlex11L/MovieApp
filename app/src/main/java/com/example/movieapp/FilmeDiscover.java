package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class FilmeDiscover extends AppCompatActivity {

    private List<Film> filme;
    //private boolean listaMea=Film.listaMea;


    //private CheckBox checkboxListaMea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);
    }
    public void arataListaFilme(View view) {
        filme = new ArrayList<>();
        Film film1 = new Film("Titanic", "rom", 120, 1999, "Steven", 7, 5);
        Film film2 = new Film("The Godfather", "action", 200, 1995, "A", 9, 9);
        filme.add(film1);
        filme.add(film2);


        ListView listView = findViewById(R.id.listview_filme);
        //sa dam click pe un clip video  din liste view si sa facem ceva(afisam un click)


        //punem clipurile in acest listview
        //ne cream un adapter
        FilmAdapter adapter = new FilmAdapter(filme, this);
        listView.setAdapter(adapter);

       /* checkboxListaMea = findViewById(R.id.checkBoxListaMea);
        if (checkboxListaMea.isChecked()) {
            checkboxListaMea.setChecked(true);
        } else {
            checkboxListaMea.setChecked(false);
        }



        /*checkboxListaMea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onCheckboxClicked(View view){
                boolean checked =((CheckBox) view).isChecked();
                if(checked){
                    checkboxListaMea.setChecked(true);
                    listaMea=true;
                }
                else
                    listaMea=false;

            }
        });*/

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
                startActivity(new Intent(FilmeDiscover.this, ListaMea.class));
                break;
            case R.id.itemDiscover:
                Toast.makeText(this,"Descoperiti filme", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FilmeDiscover.this, FilmeDiscover.class));
                break;
            case R.id.itemFilmeViz:
                Toast.makeText(this,"Filmele pe care le-ati vizionat", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FilmeDiscover.this, Vizionate.class));
                break;
            case R.id.itemLogOut:
                Toast.makeText(this,"Pagina de login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FilmeDiscover.this, MainActivity.class));
                break;
            case R.id.itemRaporteaza:
                Toast.makeText(this,"Raportati problema pe care o aveti", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FilmeDiscover.this, Raporteaza.class));
                break;
            default: return  super.onOptionsItemSelected(item);

        }
        return false;
    }

}