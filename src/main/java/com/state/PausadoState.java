package com.state;

import com.manager.AssetManager;
import com.manager.StateManager;
import com.manager.KeyManager;

import java.awt.*;

public class PausadoState extends AbstractGameState {

    public PausadoState(StateManager gsm){
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
        AssetManager.drawString(g, "paused", 40, 30);

        AssetManager.drawString(g, "arrow", 12, 76);
        AssetManager.drawString(g, "keys", 16, 84);
        AssetManager.drawString(g, ": move", 52, 80);

        AssetManager.drawString(g, "space", 12, 96);
        AssetManager.drawString(g, ": action", 52, 96);

        AssetManager.drawString(g, "F1:", 36, 112);
        AssetManager.drawString(g, "return", 68, 108);
        AssetManager.drawString(g, "to menu", 68, 116);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(false);
            System.out.println("Keys.ESCAPE pressed - despausando juego ");
        }
    }
}
