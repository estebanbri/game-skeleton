package com.entity.command.impl;

import com.entity.GameActor;
import com.entity.command.Command;

public class LeftCommand implements Command {
  @Override
  public void execute(GameActor actor) {
    actor.setMoving(true);
    actor.setLeft(true);
  }
}
