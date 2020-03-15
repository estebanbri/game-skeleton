package com.state;

import com.manager.Content;
import com.manager.GameStateManager;
import com.manager.KeyManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuState extends GameState {

    private BufferedImage background;
    private int currentOpcion;
    private String[] options = new String[]{
            "START",
            "QUIT"
    };

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        background = Content.MENUBACKGROUND[0][0];
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(background, 0 ,0 , null);
        Content.drawString(g, "JUGAR", 44, 90);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isPressed(KeyManager.DOWN) && (currentOpcion < options.length - 1)){
                currentOpcion++;
        }
        if(KeyManager.isPressed(KeyManager.UP) && (currentOpcion > 0)){
                currentOpcion--;
        }
        if(KeyManager.isPressed(KeyManager.ENTER)){
            selectOption();
        }
    }

    private void selectOption() {
        switch (currentOpcion){
            case 0 : gsm.changeState(GameStateManager.PLAY); break;
            case 1 : System.exit(0); break;
        }
    }
}
