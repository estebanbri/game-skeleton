package com.state;


import com.entity.command.Command;
import com.manager.StateManager;

import java.awt.*;

public abstract class AbstractGameState {

     protected StateManager gsm;

     public AbstractGameState(StateManager gsm){
          this.gsm = gsm;
     }

     public abstract void init();
     public abstract void update();
     public abstract void draw(Graphics2D g);
     public abstract Command handleInput();
}
