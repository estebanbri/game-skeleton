package com.state;

import com.main.GamePanel;
import com.manager.GameStateManager;
import com.manager.KeyManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IntroState extends GameState {

    private BufferedImage logo;

    private int ticks;

    private final int LENGTH = 60;



    public IntroState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        ticks = 0;
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/Logo/logo.gif"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        handleInput();
        ticks++;
        if(ticks > LENGTH ) {
            gsm.changeState(GameStateManager.MENU);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, Color.WHITE, null);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isPressed(KeyManager.ENTER)) {
            gsm.changeState(GameStateManager.MENU);
        }
    }
}
