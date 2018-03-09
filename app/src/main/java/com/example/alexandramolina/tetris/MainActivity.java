package com.example.alexandramolina.tetris;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;
import android.support.v7.widget.GridLayout;
import android.widget.TextView;

import java.util.Timer;

import java.util.ArrayList;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {

    //matriz para saber donde hay piezas, 1 significara que tiene una pieza y 0 que esta vacia
    int[][] matriz1 = {{0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0},};

    ImageView[][] lista_views = new ImageView[22][12];

    //random para ver cual color de figura lanzar 1: azul, 2: verde, 3: amarillo, 4: morado, 5: naranja
    int color = (int) (Math.random() * 5) + 1;

    //random para ver cual figura lazar
    int figura = (int) (Math.random() * 7) + 1;

    Timer timer;
    TimerTask timertask;

    int x = 0;
    int y = 6;


    Creador creador = new Creador();

    ArrayList<Pieza> piezaNueva;

    Pieza[][] piezas = new Pieza[22][12];

    int tipo_pieza;

    int choque = 0;

    int crearPieza = 0;

    int choqueIzq = 0;

    int choqueDer = 0;

    int choqueAbj = 0;

    int dificultad = 500;



    public void btnIzqClicked(View view){

        pintar_tablero();

        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
        }
        for(Pieza p: piezaNueva){
            if (p.getY() == 0) {
                choqueIzq = 1;
            }
            else if(piezas[p.getX()][p.getY()-1].getX() != -1) {
                choqueIzq = 1;
            }
        }

        for(Pieza p: piezaNueva){
            if(choqueIzq == 0){
                p.disminuirY();
                piezas[p.getX()][p.getY()] = p;
            }
            else{
                piezas[p.getX()][p.getY()] = p;
            }
        }
        choqueIzq = 0;

    }
    public void btnAbjClicked(View view){
        pintar_tablero();

        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
        }
        for(Pieza p: piezaNueva){
            if (p.getX() == 21) {
                choqueAbj = 1;
            }
            else if(piezas[p.getX()+1][p.getY()].getX() != -1) {
                choqueAbj = 1;
            }
        }

        for(Pieza p: piezaNueva){
            if(choqueAbj == 0){
                p.aumentarX();
                piezas[p.getX()][p.getY()] = p;
            }
            else{
                piezas[p.getX()][p.getY()] = p;
            }
        }
        choqueAbj = 0;
    }
    public void btnDerClicked(View view){
        pintar_tablero();

        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
        }
        for(Pieza p: piezaNueva){
            if (p.getY() == 11) {
                choqueDer = 1;
            }
            else if(piezas[p.getX()][p.getY()+1].getX() != -1) {
                choqueDer = 1;
            }
        }

        for(Pieza p: piezaNueva){
            if(choqueDer == 0){
                p.aumentarY();
                piezas[p.getX()][p.getY()] = p;
            }
            else{
                piezas[p.getX()][p.getY()] = p;
            }
        }
        choqueDer = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imprimir_tablero();
        tipo_pieza = (int) (Math.random() * 7) + 1;
        if (tipo_pieza == 1) {
            piezaNueva = creador.Letra_I();
        } else if (tipo_pieza == 2) {
            piezaNueva = creador.Letra_J();
        } else if (tipo_pieza == 3) {
            piezaNueva = creador.Letra_L();
        } else if (tipo_pieza == 4) {
            piezaNueva = creador.Letra_T();
        } else if (tipo_pieza == 5) {
            piezaNueva = creador.Letra_O();
        } else if (tipo_pieza == 2) {
            piezaNueva = creador.Letra_S();
        } else {
            piezaNueva = creador.Letra_Z();
        }
        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = p;
        }
        iniciar_juego();
    }

    public void imprimir_tablero(){
        int t = 0;
        GridLayout gridlayout = findViewById(R.id.gridl);
        for(int i = 0; i < 24 ; i++){
            for(int j = 0; j < 14; j++){
                ImageView imageView = new ImageView(this);
                //String tag = Integer.toString(i)+"-"+Integer.toString(j);
                int tag = t++;
                imageView.setTag(tag);
                gridlayout.addView(imageView);
                if(i == 0 || i == 23 || j == 0 || j == 13){
                    imageView.setImageResource(R.drawable.cuadrado_grisclaro);
                }
                else {
                    lista_views[i - 1][j - 1] = imageView;
                    piezas[i - 1][j - 1] = new Pieza(-1, -1, 1);
                }
            }
        }

    }
    public void iniciar_juego(){
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                for(Pieza p: piezaNueva){
                                    piezas[p.getX()][p.getY()] = p;
                                }

                                pintar_tablero();

                                for(Pieza p: piezaNueva){
                                    piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
                                }

                                for(Pieza p: piezaNueva) {
                                    //choque piso
                                    if (p.getX() == 21) {
                                        choque = 1;
                                    }
                                    //choque abajo con otra pieza
                                    else if(p.getX() < 21){
                                        if(piezas[p.getX() + 1][p.getY()].getX() != -1) {
                                            choque = 1;
                                        }
                                    }
                                }

                                for(Pieza p: piezaNueva){
                                    tipo_pieza = (int) (Math.random() * 7) + 1;
                                    if(choque == 0){
                                        p.aumentarX();
                                        piezas[p.getX()][p.getY()] = p;
                                    }
                                    else{
                                        crearPieza = 1;
                                        piezas[p.getX()][p.getY()] = p;
                                    }
                                }

                                if(crearPieza == 1){
                                    crearPieza = 0;
                                    choque = 0;
                                    if (tipo_pieza == 1) {
                                        piezaNueva = creador.Letra_I();
                                    } else if (tipo_pieza == 2) {
                                        piezaNueva = creador.Letra_J();
                                    } else if (tipo_pieza == 3) {
                                        piezaNueva = creador.Letra_L();
                                    } else if (tipo_pieza == 4) {
                                        piezaNueva = creador.Letra_T();
                                    } else if (tipo_pieza == 5) {
                                        piezaNueva = creador.Letra_O();
                                    } else if (tipo_pieza == 2) {
                                        piezaNueva = creador.Letra_S();
                                    } else {
                                        piezaNueva = creador.Letra_Z();
                                    }
                                }

                            }

                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

    }
    public void pintar_tablero(){
        for(int i = 0; i < 22; i++){
            for(int j = 0; j < 12; j++){
                if (piezas[i][j].getX() != -1) {
                    if (piezas[i][j].getColor() == 1) {
                        lista_views[i][j].setImageResource(R.drawable.cuadrado_amarillo);
                    } else if (piezas[i][j].getColor() == 2) {
                        lista_views[i][j].setImageResource(R.drawable.cuadrado_azul);
                    } else if (piezas[i][j].getColor() == 3) {
                        lista_views[i][j].setImageResource(R.drawable.cuadrado_verde);
                    } else if (piezas[i][j].getColor() == 4) {
                        lista_views[i][j].setImageResource(R.drawable.cuadrado_naranja);
                    } else{
                        lista_views[i][j].setImageResource(R.drawable.cuadrado_morado);
                    }
                }
                else{
                    lista_views[i][j].setImageResource(R.drawable.cuadrado_gris);
                }
            }
        }
    }
}
