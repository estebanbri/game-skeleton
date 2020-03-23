package com.state;

import com.component.Position;
import com.entity.GameActor;
import com.entity.Player;
import com.entity.command.Command;
import com.entity.command.impl.DownCommand;
import com.entity.command.impl.LeftCommand;
import com.entity.command.impl.RightCommand;
import com.entity.command.impl.UpCommand;
import com.main.GamePanel;
import com.manager.DrawerManager;
import com.manager.StateManager;
import com.manager.KeyManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


public class PlayState extends AbstractGameState {

    private Player player;
    private Command leftCommand;
    private Command rightCommand;
    private Command upCommand;
    private Command downCommand;

    private DrawerManager drawerManager;

    public PlayState(StateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        player = new Player();
        player.setPosition(new Position(17,17));
        leftCommand = new LeftCommand();
        rightCommand = new RightCommand();
        upCommand = new UpCommand();
        downCommand = new DownCommand();
        drawerManager = new DrawerManager();
        drawerManager.addGameActor(player);
    }

    @Override
    public void update() {
        Command commmand = handleInput();
        if(commmand != null){
            commmand.execute(player);
        }
        player.update(); // actualiza el conjunto de imagenes dependiendo de la tecla pulsada y hace el movimiento
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
        drawerManager.draw(g);
    }

    @Override
    public Command handleInput() {
        if(KeyManager.isDown(KeyManager.LEFT)) return leftCommand;
        if(KeyManager.isDown(KeyManager.RIGHT)) return rightCommand;
        if(KeyManager.isDown(KeyManager.UP)) return upCommand;
        if(KeyManager.isDown(KeyManager.DOWN)) return downCommand;

        // Nothing Pressed
        return null;
    }

}
