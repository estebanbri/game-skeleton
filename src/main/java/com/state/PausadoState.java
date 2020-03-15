package com.state;

import com.manager.Content;
import com.manager.GameStateManager;
import com.manager.KeyManager;

import java.awt.*;

public class PausadoState extends GameState {

    public PausadoState(GameStateManager gsm){
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
        Content.drawString(g, "paused", 40, 30);

        Content.drawString(g, "arrow", 12, 76);
        Content.drawString(g, "keys", 16, 84);
        Content.drawString(g, ": move", 52, 80);

        Content.drawString(g, "space", 12, 96);
        Content.drawString(g, ": action", 52, 96);

        Content.drawString(g, "F1:", 36, 112);
        Content.drawString(g, "return", 68, 108);
        Content.drawString(g, "to menu", 68, 116);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(false);
            System.out.println("Keys.ESCAPE pressed - despausando juego ");
        }
    }
}
