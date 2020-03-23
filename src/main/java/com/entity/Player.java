package com.entity;

import com.manager.AssetManager;

import java.awt.image.BufferedImage;

public class Player extends GameActor {

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
    collisionWidth = 12;
    collisionHeigth = 12;

    moveSpeed = 2;

    downSprites = AssetManager.PLAYER[DOWN];
    leftSprites = AssetManager.PLAYER[LEFT];
    rightSprites = AssetManager.PLAYER[RIGHT];
    upSprites = AssetManager.PLAYER[UP];

    animation.setFrames(downSprites);
    animation.setDelay(10);
  }


  public void update() {

    // set animation
    if (down) {
      if (currentAnimation != DOWN) { // esta validacion es para que si la animacion ya esta apuntando para abajo no hacemos que setee de neuvo el set de imagenes
        currentAnimation = DOWN;
        setGraphics(downSprites, 10);
      }
    }
    if (left) {
      if (currentAnimation != LEFT) {
        currentAnimation = LEFT;
        setGraphics(leftSprites, 10);
      }
    }
    if (right) {
      if (currentAnimation != RIGHT) {
        currentAnimation = RIGHT;
        setGraphics(rightSprites, 10);
      }
    }
    if (up) {
      if (currentAnimation != UP) {
        currentAnimation = UP;
        setGraphics(upSprites, 10);
      }
    }

    // update position
    super.update();  // actualizar movimiento + actualizar imagen de la animacion

  }

  private void setGraphics(BufferedImage[] frames, int delay){
    animation.setFrames(frames);
    animation.setDelay(delay);
  }

}


