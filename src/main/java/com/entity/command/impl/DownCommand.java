package com.entity.command.impl;

import com.entity.GameActor;
import com.entity.command.Command;

public class DownCommand implements Command {
  @Override
  public void execute(GameActor actor) {
    actor.setMoving(true);
    actor.setDown(true);
  }
}
