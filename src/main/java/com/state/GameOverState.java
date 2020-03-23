package com.state;

import com.entity.command.Command;
import com.manager.StateManager;

import java.awt.*;

public class GameOverState extends AbstractGameState {

    public GameOverState(StateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public Command handleInput() {
        return null;
    }
}
