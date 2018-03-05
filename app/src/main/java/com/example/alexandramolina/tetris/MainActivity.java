package com.example.alexandramolina.tetris;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;
import android.support.v7.widget.GridLayout;
import java.util.Timer;

import java.util.ArrayList;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //matriz para saber donde hay piezas, 1 significara que tiene una pieza y 0 que esta vacia
    int[][] matriz = {{0,0,0,0,0,0,0,0,0,0,0,0},
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

    ArrayList<ImageView> lista_views = new ArrayList<ImageView>();

    //random para ver cual color de figura lanzar 1: azul, 2: verde, 3: amarillo, 4: morado, 5: naranja
    int color;
    //random para ver cual figura lazar
    int figura = (int) (Math.random() * 7) + 1;

    Timer timer;
    TimerTask timertask;

    int x = 6;

    public void btnIzqClicked(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imprimir_tablero();
        iniciar_juego();
    }

    public void imprimir_tablero(){
        int t = 0;
        GridLayout gridlayout = findViewById(R.id.gridl);

        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 19; j++){
                color = (int) (Math.random() * 5) + 1;
                ImageView imageView = new ImageView(this);
                //String tag = Integer.toString(i)+Integer.toString(j);
                int tag = t++;
                imageView.setTag(tag);
                lista_views.add(imageView);
                imageView.setImageResource(R.drawable.cuadrado_gris);
                /*if(color == 1) {
                    imageView.setImageResource(R.drawable.cuadrado_azul);
                }
                else if(color == 2){
                    imageView.setImageResource(R.drawable.cuadrado_verde);
                }
                else if(color == 3){
                    imageView.setImageResource(R.drawable.cuadrado_amarillo);
                }
                else if(color == 4){
                    imageView.setImageResource(R.drawable.cuadrado_morado);
                }
                else{
                    imageView.setImageResource(R.drawable.cuadrado_naranja);
                }*/
                gridlayout.addView(imageView);
            }
        }

    }
    public void iniciar_juego(){
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(x < 14*19) {
                                    for (ImageView i : lista_views) {
                                        //Log.d("tag",i.getTag().toString()); para imprimir los tags
                                        if ((int)i.getTag() == x) {
                                            Log.d("tag",i.getTag().toString());
                                            i.setImageResource(R.drawable.cuadrado_amarillo);
                                        }
                                        if ((int)i.getTag() == x-14) {
                                            i.setImageResource(R.drawable.cuadrado_gris);
                                        }
                                    }
                                    x+=14;
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
        /*timer = new Timer();
        timertask = new TimerTask() {
            @Override
            public void run() {
                if(x < 19) {
                    for (ImageView i : lista_views) {
                        //Log.d("tag",i.getTag().toString()); para imprimir los tags
                        if (i.getTag().toString().equals(Integer.toString(x) + Integer.toString(y))) {
                            Log.d("tag",Integer.toString(x) + Integer.toString(y));
                            //i.setImageResource(R.drawable.cuadrado_amarillo);
                        }
                    }
                    x++;
                }
            }
        };
        timer.schedule(timertask,1000, 1000);*/
    }
}
