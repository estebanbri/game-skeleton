package com.state;

import com.main.GamePanel;
import com.manager.GameStateManager;

import java.awt.*;

public class OptionesState extends GameState {



    public OptionesState(GameStateManager gsm) {
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
    public void handleInput() {


    }
}

