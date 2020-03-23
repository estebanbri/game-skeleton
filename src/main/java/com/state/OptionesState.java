package com.state;

import com.entity.command.Command;
import com.main.GamePanel;
import com.manager.StateManager;

import java.awt.*;

public class OptionesState extends AbstractGameState {



    public OptionesState(StateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

    @Override
    public Command handleInput() {
        return null;
    }
}

