package com.example.alexandramolina.tetris;

import java.util.ArrayList;

/**
 * Created by alexandramolina on 6/3/18.
 */

public class Creador {

    int color;
    ArrayList<int[][]> listaRotacion = new ArrayList();
    int matrizI[][] = {{3,3},{2,2},{1,1},{0,0}};
    int matrizZ[][] = {{0,0},{1,-1},{0,-2},{1,-3}};
    int matrizS[][] = {{0,0},{1,1},{0,2},{1,3}};
    int matrizT1[][] ={{-1,1},{0,0},{1,-1},{-1,-1}};
    int matrizT2[][] ={{1,1},{0,0},{-1,-1},{-1,1}};
    int matrizL1[][] = {{1,-1},{0,0},{-1,1},{-2,0}};
    int matrizL2[][] = {{1,1},{0,0},{-1,-1},{0,-2}};
    int matrizJ1[][] = {{1,1},{0,0},{-1,-1},{-2,0}};
    int matrizJ2[][] = {{1,-1},{0,0},{-1,1},{0,2}};
    int matrizO[][] = {{0,0},{0,0},{0,0},{0,0}};
    int tipo_p = 0;

    public ArrayList<Pieza> Letra_O(){
        tipo_p = 1;
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
        tipo_p = 2;
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
        tipo_p = 3;
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
        tipo_p = 4;
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
        tipo_p = 5;
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,6, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(0,5, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(1,5, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(1,4, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_T(){
        tipo_p = 6;
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(0,6, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(0,7, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(1,6, color);
        arrayList.add(p4);

        return arrayList;
    }
    public ArrayList<Pieza> Letra_Z(){
        tipo_p = 7;
        ArrayList<Pieza> arrayList = new ArrayList<Pieza>();
        color  = (int) (Math.random() * 5) + 1;
        Pieza p1 = new Pieza(0,5, color);
        arrayList.add(p1);
        Pieza p2 = new Pieza(0,6, color);
        arrayList.add(p2);
        Pieza p3 = new Pieza(1,6, color);
        arrayList.add(p3);
        Pieza p4 = new Pieza(1,7, color);
        arrayList.add(p4);

        return arrayList;
    }

    public ArrayList<int[][]> obtenerRotacion(){
        if(tipo_p == 7) {
            listaRotacion.add(matrizZ);
        }
        else if(tipo_p == 2){
            listaRotacion.add(matrizI);
        }
        else if(tipo_p == 5){
            listaRotacion.add(matrizS);
        }
        else if(tipo_p == 6){
            listaRotacion.add(matrizT1);
            listaRotacion.add(matrizT2);
        }
        else if(tipo_p == 3){
            listaRotacion.add(matrizL1);
            listaRotacion.add(matrizL2);
        }
        else if(tipo_p == 4){
            listaRotacion.add(matrizJ1);
            listaRotacion.add(matrizJ2);
        }
        else if(tipo_p == 1){
            listaRotacion.add(matrizO);
        }
        return listaRotacion;
    }
}



