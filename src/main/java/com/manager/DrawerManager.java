package com.manager;

import com.entity.GameActor;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class DrawerManager {

  private List<GameActor> actors;

  public DrawerManager(){
    this.actors = new ArrayList<>();
  }

  public void draw(Graphics2D g){
    for(GameActor actor : actors){
        actor.draw(g);
    }
  }

  public void addGameActor(GameActor actor){
    this.actors.add(actor);
  }

}
