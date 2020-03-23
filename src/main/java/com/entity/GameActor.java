package com.entity;

import com.component.Position;
import java.awt.*;

public abstract class GameActor {

  // Dimensiones
  protected int width;
  protected int heigth;
  protected int collisionWidth;
  protected int collisionHeigth;

  // Posicion
  protected Position currentPosition;
  protected Position newPosition;

  // Movimientos
  protected boolean moving;
  protected boolean up;
  protected boolean down;
  protected boolean left;
  protected boolean right;

  // Atributos
  protected int moveSpeed;

  // Animation
  protected Animation animation;
  protected int currentAnimation;

  public GameActor() {
    animation = new Animation();
    currentPosition = new Position();
    newPosition = new Position();
  }

  public void setPosition(Position position) {
    final int x = position.getX();
    final int y = position.getY();
    currentPosition.setX(x);
    currentPosition.setY(y);
    newPosition.setX(x);
    newPosition.setY(y);
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

    if (moving) {
      if (left) {
        int x = currentPosition.getX() - moveSpeed;
        currentPosition.setX(x);
        left = false;
      }
      if (right) {
        int x = currentPosition.getX() + moveSpeed;
        currentPosition.setX(x);
        right = false;
      }
      if (up) {
        int y = currentPosition.getY() - moveSpeed;
        currentPosition.setY(y);
        up = false;
      }
      if (down) {
        int y = currentPosition.getY() + moveSpeed;
        currentPosition.setY(y);
        down = false;
      }
    }

    boolean hasNotMoved = currentPosition.getX() == newPosition.getX() && currentPosition.getY() == newPosition.getY();
    if (hasNotMoved) {
      moving = false;
    }

    // update animation
    animation.update(); // finalidad: actualizar al siguiente indice de la siguiente imagen a mostrar

  }

  // Draws the entity.
  public void draw(Graphics2D g) {
    g.drawImage(
        animation.getCurrentImage(),      // pinta la imagen actual del set de imaginacion
        currentPosition.getX(),
        currentPosition.getY(),
        null
    );
  }

  public boolean isMoving() {
    return moving;
  }

  public void setMoving(boolean moving) {
    this.moving = moving;
  }

  public boolean isUp() {
    return up;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public boolean isDown() {
    return down;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public boolean isLeft() {
    return left;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public boolean isRight() {
    return right;
  }

  public void setRight(boolean right) {
    this.right = right;
  }
}
