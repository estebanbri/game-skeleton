package com.entity;

import com.entity.command.impl.DownCommand;
import com.entity.command.impl.LeftCommand;
import com.entity.command.impl.RightCommand;
import com.entity.command.impl.UpCommand;
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

    animation.setFrames(downSprites, 10);
  }


  public void update() {

    if(this.getCurrentCommand() != null){
      // set animation
      if (this.getCurrentCommand().getClass() == DownCommand.class) {
        if (currentAnimation != DOWN) { // esta validacion es para que si la animacion ya esta apuntando para abajo no hacemos que setee de neuvo el set de imagenes
          currentAnimation = DOWN;
          animation.setFrames(downSprites, 10);
        }
      }
      if (this.getCurrentCommand().getClass() == LeftCommand.class) {
        if (currentAnimation != LEFT) {
          currentAnimation = LEFT;
          animation.setFrames(leftSprites, 10);
        }
      }
      if (this.getCurrentCommand().getClass() == RightCommand.class) {
        if (currentAnimation != RIGHT) {
          currentAnimation = RIGHT;
          animation.setFrames(rightSprites, 10);
        }
      }
      if (this.getCurrentCommand().getClass() == UpCommand.class) {
        if (currentAnimation != UP) {
          currentAnimation = UP;
          animation.setFrames(upSprites, 10);
        }
      }
      cleanCurrentCommand();
    }

    // update position
    super.update();  // actualizar movimiento + actualizar imagen de la animacion

  }


}


