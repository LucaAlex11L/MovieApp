package com.example.movieapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;

public class Film implements Parcelable {
    private String titlu;
    private int id;
    private String gen;
    private int durata;
    private int anLansare;
    private String regizor;
    private float ratingIMDB;
    private float ratingPersonal;
    public static boolean listaMea;
    private boolean oscar;


    public Film(String titlu, String gen, int durata, int anLansare, String regizor, float ratingIMDB, float ratingPersonal) {
        this.titlu = titlu;
        this.gen = gen;
        this.durata = durata;
        this.anLansare = anLansare;
        this.regizor = regizor;
        this.ratingPersonal = ratingPersonal;
        this.ratingIMDB = ratingIMDB;
        this.listaMea=false;
        this.oscar=false;
    }

    public Film() {
        this.gen = "gen";
        this.titlu = "titlu";
        this.durata = 0;
        this.anLansare = 2000;
        this.regizor = "n/a";
        this.ratingPersonal = 0;
        this.ratingIMDB = 0;
        this.listaMea=false;
        this.oscar=false;
    }

    protected Film(Parcel in) {
        titlu = in.readString();
        gen = in.readString();
        durata = in.readInt();
        anLansare = in.readInt();
        regizor = in.readString();
        ratingIMDB = in.readFloat();
        ratingPersonal = in.readFloat();

    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titlu);
        dest.writeString(gen);
        dest.writeInt(durata);
        dest.writeInt(anLansare);
        dest.writeString(regizor);
        dest.writeFloat(ratingIMDB);
        dest.writeFloat(ratingPersonal);
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public String getRegizor() {
        return regizor;
    }

    public void setRegizor(String regizor) {
        this.regizor = regizor;
    }

    public float getRatingIMDB() {
        return ratingIMDB;
    }

    public void setRatingIMDB(float ratingIMDB) {
        this.ratingIMDB = ratingIMDB;
    }

    public float getRatingPersonal() {
        return ratingPersonal;
    }

    public void setRatingPersonal(float ratingPersonal) {
        this.ratingPersonal = ratingPersonal;
    }


    public boolean isListaMea() {
        return listaMea;
    }

    public void setListaMea(boolean listaMea) {
        this.listaMea = listaMea;
    }

    public boolean isOscar() {
        return oscar;
    }

    public void setOscar(boolean dislike) {
        this.oscar = dislike;
    }


    @Override
    public String toString() {
        return "Film{" +
                "titlu='" + titlu + '\'' +
                ", gen='" + gen + '\'' +
                ", durata=" + durata +
                ", anLansare=" + anLansare +
                ", regizor='" + regizor + '\'' +
                ", ratingIMDB=" + ratingIMDB +
                ", ratingPersonal=" + ratingPersonal +
                ", listaMea=" + listaMea +
                ", dislike=" + oscar +
                '}';
    }
}


