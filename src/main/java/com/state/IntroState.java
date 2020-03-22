package com.state;

import com.main.GamePanel;
import com.manager.StateManager;
import com.manager.KeyManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IntroState extends AbstractGameState {

    private BufferedImage logo;

    private int ticks;

    private final int MAX_TICKS = 60;

    public IntroState(StateManager gsm) {
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
        if(ticks > MAX_TICKS ) {
            gsm.changeState(StateManager.MENU);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, Color.WHITE, null);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isPressed(KeyManager.ENTER)) {
            gsm.changeState(StateManager.MENU);
        }
    }
}
