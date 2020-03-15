package com.entity;

import com.manager.Content;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    // sprites
    private BufferedImage[] downSprites;
    private BufferedImage[] leftSprites;
    private BufferedImage[] rightSprites;
    private BufferedImage[] upSprites;

    // animation
    private final int DOWN = 0;
    private final int LEFT = 1;
    private final int RIGHT = 2;
    private final int UP = 3;

    public Player() {
        width = 16;
        heigth = 16;
        cwidth = 12;
        cheigth = 12;

        moveSpeed = 2;

        downSprites = Content.PLAYER[0];
        leftSprites = Content.PLAYER[1];
        rightSprites = Content.PLAYER[2];
        upSprites = Content.PLAYER[3];

        animation.setFrames(downSprites);
        animation.setDelay(10);
    }


    public void update() {

        // set animation
        if(down) {
            if(currentAnimation != DOWN) { // esta validacion es para que si la animacion ya esta apuntando para abajo no hacemos que setee de neuvo el set de imagenes
                currentAnimation = DOWN;
                animation.setFrames(downSprites);
                animation.setDelay(10);
            }
        }
        if(left) {
             if(currentAnimation != LEFT) {
                 currentAnimation = LEFT;
                 animation.setFrames(leftSprites);
                 animation.setDelay(10);
            }
        }
        if(right) {
            if(currentAnimation != RIGHT) {
                currentAnimation = RIGHT;
                animation.setFrames(rightSprites);
                animation.setDelay(10);
            }
        }
        if(up) {
            if(currentAnimation != UP) {
                currentAnimation = UP;
                animation.setFrames(upSprites);
                animation.setDelay(10);
            }
        }

        // update position
        super.update();  // movimiento + seleccionar animacion

    }


    // Draw Player.
    public void draw(Graphics2D g) {
        super.draw(g);
    }
}


