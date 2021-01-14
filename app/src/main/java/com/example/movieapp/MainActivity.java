package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Nume;
    private EditText Parola;
    private Button Login;
    private Button Cancel;
    private String user ="a";
    private String parola ="a";
    private Button Register;
    boolean isValid = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Nume=(EditText) findViewById(R.id.etNume);
        Parola=(EditText) findViewById(R.id.etParola);
        Login=(Button)findViewById(R.id.btnLogin);
        Cancel=(Button)findViewById(R.id.btnCancel);
        Register=(Button)findViewById(R.id.btnRegister);


        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inputNume = Nume.getText().toString();
                String inputParola = Parola.getText().toString();

                if (inputNume.isEmpty() || inputParola.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                        "Nu ati completat toate campurile!", Toast.LENGTH_SHORT).show();
                }
                else {
                    isValid=validare(inputNume, inputParola);
                    if(!isValid) {
                        Toast.makeText(MainActivity.this,
                                "Username sau parola incorecte", Toast.LENGTH_SHORT).show();
                    }
                    else {
                    Toast.makeText(MainActivity.this,
                            "V-ati logat cu succes", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(MainActivity.this, Meniu.class));
                    }
                }

            }
        });

        Register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Vizionati cele mai bune filme!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, com.example.movieapp.Autentificare.class));
            }
        });




    }

    private boolean validare(String nume, String pass) {
        if(nume.equals(user) && pass.equals(parola)) {
            return true;
        }
        return false;
    }
}