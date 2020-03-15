package com.entity;

import java.awt.*;

public abstract class Entity {

    // Dimensiones
    protected int width;
    protected int heigth;
    protected int cwidth;
    protected int cheigth;

    // Posicion
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;

    // Movimientos
    protected  boolean moving;
    protected boolean up;
    protected boolean down;
    protected  boolean left;
    protected boolean right;

    // Atributos
    protected int moveSpeed;

    // Animation
    protected Animation animation;
    protected int currentAnimation;

    public Entity(){
        animation = new Animation();
    }

    public void setPosition(int i1, int i2) {
        x = dx = i1;
        y = dy = i2;
    }

    public void left() {
        moving = true;
        left = true;
    }
    public void rigth() {
        moving = true;
        right = true;
    }
    public void up() {
        moving = true;
        up = true;
    }
    public void down() {
        moving = true;
        down = true;
    }

    public void update() { // movimiento + seleccionar animacion

        if(moving){
            if(left){
                x -= moveSpeed;
                left = false;
            }
            if(right){
                x += moveSpeed;
                right = false;
            }
            if(up){
                y -= moveSpeed;
                up = false;
            }
            if(down){
                y += moveSpeed;
                down = false;
            }
        }

        boolean hasNotMoved = x == dx && y == dy;
        if(hasNotMoved){
            moving = false;
        }

        // update animation
        animation.update(); // finalidad: actualizar al siguiente indice de la siguiente imagen a mostrar

    }

    // Draws the entity.
    public void draw(Graphics2D g) {
        g.drawImage(
                animation.getImage(),      // pinta la imagen actual del set de imaginacion
                x  - width / 2,
                y  - heigth / 2,
                null
        );
    }
}
