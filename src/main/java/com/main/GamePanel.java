package com.main;

import com.manager.GameStateManager;
import com.manager.KeyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements KeyListener {

    // dimensions
    public static final int WIDTH = 128;
    public static final int HEIGHT = 128;
    public static final int SCALE = 3;

    // game loop stuff
    private Thread thread;
    private boolean running;
    private final int FPS = 30;
    private final int TARGET_TIME = 1000 / FPS;

    // drawing stuff
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    // constructor
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    // hack: ready to display usando este metodo nos aseguramos que el JPanel ya ha sido agregado al JFrame antes de comenzar el juego
    @Override
    public void addNotify() {
        super.addNotify();
        startGame(); // at this point is safe to start the game
    }

    private void startGame(){
        if (thread == null) {
            thread = new Thread() {
                @Override
                public void run() {
                    gameLoop();
                }
            };
            thread.start();
        }
    }

    // run new thread
    private void gameLoop() {

        // Inicializamos las variables necesarias que vamos a usar dentro del gameLoop
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();

        // variables usadas para controlar los tiempos de inicio y fin del gameloop y dormir el thread cuando sea necesario dependienco de los fps
        long start;
        long elapsed;
        long wait;

        // game loop
        while (running) {

            start = System.nanoTime();

            ///////////////// GAME LOOP ////////////
            update();
            draw();
            drawToScreen();
            //////////////////////////////////////

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000;
            if (wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    // updates game
    private void update() {
        gsm.update();
        KeyManager.update();
    }

    // draws game
    private void draw() {
        gsm.draw(g);
    }

    // copy buffer to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        g2.dispose();
    }


    @Override
    public void keyTyped(KeyEvent key) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        KeyManager.updateKeyState(key, true);
    }

    @Override
    public void keyReleased(KeyEvent key) {
        KeyManager.updateKeyState(key, false);
    }

}
