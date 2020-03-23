package com.entity.command.impl;

import com.component.Position;
import com.entity.GameActor;
import com.entity.command.Command;

public class RightCommand implements Command {
  @Override
  public void execute(GameActor actor) {
    actor.setCurrentCommand(this);
    Position currentPosition = actor.getCurrentPosition();
    int dx = currentPosition.getX() + actor.getMoveSpeed();
    currentPosition.setX(dx);
  }
}
