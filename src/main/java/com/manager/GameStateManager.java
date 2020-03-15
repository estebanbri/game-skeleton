package com.manager;

import com.state.*;

import java.awt.*;

public class GameStateManager {

    private boolean paused;
    private PausadoState pauseState;

    private GameState[] gameStates;
    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 5;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PLAY = 2;
    public static final int GAMEOVER = 3;
    public static final int OPCIONES = 4;

    public GameStateManager() {

        paused = false;
        pauseState = new PausadoState(this);

        gameStates = new GameState[NUM_STATES];
        changeState(INTRO);

    }

    public void changeState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        switch (i){
            case INTRO :
                gameStates[i] = new IntroState(this);
                gameStates[i].init();
                break;
            case MENU :
                gameStates[i] = new MenuState(this);
                gameStates[i].init();
                break;
            case PLAY :
                gameStates[i] = new PlayState(this);
                gameStates[i].init();
                break;
            case GAMEOVER :
                gameStates[i] = new GameOverState(this);
                gameStates[i].init();
                break;
            case OPCIONES :
                gameStates[i] = new OptionesState(this);
                gameStates[i].init();
                break;
            default: throw new IllegalArgumentException("Couldnt find state [" + i + "] in GameStateManager");
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void setPaused(boolean b) {
        paused = b;
    }

    public void update() {
        if(paused) {
            pauseState.update();
        }
        else if(gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    public void draw(Graphics2D g) {
        if(paused) {
            pauseState.draw(g);
        }
        else if(gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
        }
    }


}
