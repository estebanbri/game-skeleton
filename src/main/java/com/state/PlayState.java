package com.state;

import com.component.Position;
import com.entity.Player;
import com.main.GamePanel;
import com.manager.StateManager;
import com.manager.KeyManager;

import java.awt.*;

public class PlayState extends AbstractGameState {

    private Player player;

    public PlayState(StateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        player = new Player();
        player.setPosition(new Position(17,17));
    }

    @Override
    public void update() {
        handleInput();
        player.update(); // actualiza el conjunto de imagenes dependiendo de la tecla pulsada
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
        player.draw(g);
    }

    @Override
    public void handleInput() {
        if(KeyManager.isDown(KeyManager.LEFT)) player.left();
        if(KeyManager.isDown(KeyManager.RIGHT)) player.rigth();
        if(KeyManager.isDown(KeyManager.UP)) player.up();
        if(KeyManager.isDown(KeyManager.DOWN)) player.down();
    }
}
