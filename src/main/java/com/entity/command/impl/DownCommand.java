package com.entity.command.impl;

import com.component.Position;
import com.entity.GameActor;
import com.entity.command.Command;

public class DownCommand implements Command {
  @Override
  public void execute(GameActor actor) {
    actor.setCurrentCommand(this);
    Position currentPosition = actor.getCurrentPosition();
    int dy = currentPosition.getY() + actor.getMoveSpeed();
    currentPosition.setY(dy);
  }
}
