package com.example.alexandramolina.tetris;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.GridLayout;
import android.widget.SeekBar;
import java.util.ArrayList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;



public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageView[][] lista_views = new ImageView[22][12];

    Creador creador = new Creador();

    ArrayList<Pieza> piezaNueva;

    Pieza[][] piezas = new Pieza[22][12];

    ArrayList<int[][]> lista = new ArrayList();

    int tipo_pieza;

    int choque = 0;

    int crearPieza = 0;

    int choqueIzq = 0;

    int choqueDer = 0;

    int choqueAbj = 0;

    int dificultad = 1000;

    int v = 0;



    public void btnIzqClicked(View view){

        pintar_tablero();

        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
        }
        for(Pieza p: piezaNueva){
            if (p.getY() == 0) {
                choqueIzq = 1;
            }
            else if(piezas[p.getX()][p.getY()-1].getX() != -1){
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
    public void btn_rotar(View view){
        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = new Pieza(-1,-1,1);
        }
        for(int i = 0; i < 4; i++){
            if(v%2==0) {
                piezaNueva.get(i).sumarX(lista.get(0)[i][0]);
                piezaNueva.get(i).sumarY(lista.get(0)[i][1]);
            }
            else{
                piezaNueva.get(i).restarX(lista.get(0)[i][0]);
                piezaNueva.get(i).restarY(lista.get(0)[i][1]);
            }


        }
        for(Pieza p: piezaNueva){
            piezas[p.getX()][p.getY()] = p;
        }
        aumentarV();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar1);

        imprimir_tablero();

        seekBar.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        seekBar.setMax(1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateDificultad(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tipo_pieza = 1;//(int) (Math.random() * 7) + 1;
        if (tipo_pieza == 1) {

            piezaNueva = creador.Letra_I();

            lista = creador.obtenerRotacion();

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
                        Thread.sleep(dificultad);
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

                                revisar_tablero();

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
    public void updateDificultad(int i){
        dificultad = i;
    }

    public void revisar_tablero(){
        for(int i = 0; i < 22 ; i++){
            boolean a = true;
            for(int j = 0; j < 12; j++){
                if (piezas[i][j].getX() == -1) {
                    a = false;
                }

            }
            if(a) {
                for (int x = 22; x > 0; x--) {
                    if (x == i) {
                        for (int y = 0; y < 12; y++) {
                            piezas[x][y] = new Pieza(-1,-1,-1);
                        }
                    }
                    else if(x < i){
                        for (int y = 0; y < 12; y++) {
                            piezas[x+1][y] = piezas[x][y];
                            piezas[x][y] = new Pieza(-1,-1,-1);
                        }
                    }
                }
            }
        }
    }
    public void aumentarV(){
        v++;
        Log.d("v",Integer.toString(v));
    }
}
