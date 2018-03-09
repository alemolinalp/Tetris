package com.example.alexandramolina.tetris;

/**
 * Created by alexandramolina on 6/3/18.
 */

public class Pieza {
    int x;
    int y;
    int color;

    Pieza(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void aumentarX(){
        x++;
    }
    public void disminuirY(){
        y--;
    }
    public void aumentarY(){
        y++;
    }
    public void disminuirX(){
        x--;
    }
}


