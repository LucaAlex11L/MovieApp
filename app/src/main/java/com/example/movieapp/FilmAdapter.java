package com.example.movieapp;

import android.content.Context;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class FilmAdapter extends BaseAdapter {

    private List<Film> filme;
    private Context context;

    public FilmAdapter(List<Film> filme, Context context) {
        this.filme = filme;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.filme.size();
        //metoda getCount - imi returneaza nr de obiecte din lista
    }

    @Override
    public Object getItem(int position) {
        if (position >= 0 && position < this.getCount()) {
            return this.filme.get(position);
        } else {
            return new IllegalArgumentException("Parametru incorect");
        }
        //pozitia elementului pe care trebuie sa il returnez
    }

    @Override
    public long getItemId(int position) {
        return 0;
        //id-ul elementului de pe pozitia position - nu l folosim
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        //generarea view-ului - imi creez un view pe baza unui layout - ca sa fac conversia de la layout la view am nevoie de un LayoutInflater
        View generatedView = inflater.inflate(R.layout.item_layout, parent, false);

        Film f = (Film) getItem(position);
        TextView tvDurata = generatedView.findViewById(R.id.tvDurata);
        TextView tvAn = generatedView.findViewById(R.id.tvAn);
        TextView tvTitlu = generatedView.findViewById(R.id.tvTitlu);
        TextView tvGen = generatedView.findViewById(R.id.tvGen);
        TextView tvRegizor = generatedView.findViewById(R.id.tvRegizor);
        TextView tvRatingIMDB=generatedView.findViewById(R.id.tvRatingIMDB);
        CheckBox cbListaMea=generatedView.findViewById(R.id.checkBoxListaMea);

        //checkbox event listener
        if (cbListaMea.isChecked()) {

        }// else {
          //  cbListaMea.setChecked(false);
        //a}

        tvDurata.setText(String.valueOf(f.getDurata()));
        tvAn.setText(String.valueOf(f.getAnLansare()));
        tvTitlu.setText(f.getTitlu());
        tvRatingIMDB.setText(String.valueOf(f.getRatingIMDB()));
        tvGen.setText(f.getGen());
        tvRegizor.setText(f.getRegizor());
        cbListaMea.setActivated(true);
        return generatedView;
    }

}