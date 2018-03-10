package com.example.alexandramolina.tetris;

import java.util.ArrayList;

/**
 * Created by alexandramolina on 6/3/18.
 */

public class Creador {

    int color;
    ArrayList<int[][]> listaRotacion = new ArrayList();
    int matrizI[][] = {{3,3},{2,2},{1,1},{0,0}};

    public ArrayList<Pieza> Letra_O(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(0,6, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(1,5, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(1,6, color);
        arrayList.add(p4);

        return arrayList;
    }

    public ArrayList<Pieza> Letra_I(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(1,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(2,5, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(3,5, color);
        arrayList.add(p4);

        return arrayList;
    }

    public ArrayList<Pieza> Letra_L(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(1,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(2,5, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(2,6, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_J(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(1,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(2,5, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(2,4, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_S(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(1,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(1,4, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(0,6, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_T(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(0,6, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(0,4, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(1,5, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_Z(){
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(1,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(1,6, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(0,4, color);
        arrayList.add(p4);

        return arrayList;
    }

    public ArrayList<int[][]> obtenerRotacion(){
        listaRotacion.add(matrizI);
        return listaRotacion;
    }
}



