package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Raporteaza extends AppCompatActivity {
    EditText numeT;
    EditText problema;
    Button sendBtn;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raporteaza);

        numeT = findViewById(R.id.editTextTextPersonName2);//numele de user
        problema = findViewById(R.id.editTextTextPersonName3);//problema userului
        sendBtn = findViewById(R.id.button);


        sendBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                sendData();
            }
        });

    }

    public void sendData(){
        String dataFieldText = numeT.getText().toString();
        String dataFieldText1 = problema.getText().toString();
       // String nume =databaseReference.push().getKey();
        if(!TextUtils.isEmpty(dataFieldText))
        {
            //Data data = new Data(nume, dataFieldText);
            databaseReference=db.getReference(dataFieldText);
            databaseReference.child("problema").setValue(dataFieldText1);
//            databaseReference.child("problema").setValue(dataFieldText1);
            Toast.makeText(this, "Datele au fost trimise catre administrator!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Introduceti un mesaj valid!", Toast.LENGTH_SHORT).show();
        }
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
                startActivity(new Intent(Raporteaza.this, ListaMea.class));
                break;
            case R.id.itemDiscover:
                Toast.makeText(this,"Descoperiti filme", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Raporteaza.this, FilmeDiscover.class));
                break;
            case R.id.itemFilmeViz:
                Toast.makeText(this,"Filmele pe care le-ati vizionat", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Raporteaza.this, Vizionate.class));
                break;
            case R.id.itemLogOut:
                Toast.makeText(this,"Pagina de login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Raporteaza.this, MainActivity.class));
                break;
            case R.id.itemRaporteaza:
                Toast.makeText(this,"Raportati problema pe care o aveti", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Raporteaza.this, Raporteaza.class));
                break;
            default: return  super.onOptionsItemSelected(item);

        }
        return false;
    }
}