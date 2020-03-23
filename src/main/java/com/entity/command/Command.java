package com.entity.command;

import com.entity.GameActor;

public interface Command {
  void execute(GameActor actor);
}
