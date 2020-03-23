package com.entity;

import com.component.Position;
import com.entity.command.Command;
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
  protected Command currentCommand;

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

  public void update() { // seleccionar animacion
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

  // Getters & Setters

  public Command getCurrentCommand() { return currentCommand; }
  public void setCurrentCommand(Command command) { this.currentCommand = command; }
  public void cleanCurrentCommand(){
    this.currentCommand = null;
  }
  public Position getCurrentPosition() { return currentPosition; }
  public void setCurrentPosition(Position currentPosition) { this.currentPosition = currentPosition; }
  public int getMoveSpeed() { return moveSpeed; }
}
