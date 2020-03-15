package com.entity;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] frames;
    private int currentFrame;
    private int numFrames;

    private int count;
    private int delay;

    private int timesPlayed;

    public Animation() {
        timesPlayed = 0;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 2;
        numFrames = frames.length;
    }

    public void setDelay(int i) { delay = i; }
    public void setFrame(int i) { currentFrame = i; }
    public void setNumFrames(int i) { numFrames = i; }

    public void update() { // finalidad: actualizar al siguiente indice de la siguiente imagen a mostrar

        if(delay == -1) return;

        count++;

        if(count == delay) {
            currentFrame++;  // siguiente imagen index
            count = 0; // resetea count para que pase la misma cantidad de tiempo en cada vuelta
        }
        if(currentFrame == numFrames) {  // si el frame actual es el ultimo frame reseteamos los contadores para que repita la segunda de la animacion
            currentFrame = 0;
            timesPlayed++; // contador de cantidad de veces que se completo las n imagenes de la animacion completa
        }

    }


    public BufferedImage getImage() { return frames[currentFrame]; }

    public int getFrame() { return currentFrame; }
    public int getCount() { return count; }
    public boolean hasPlayedOnce() { return timesPlayed > 0; }
    public boolean hasPlayed(int i) { return timesPlayed == i; }
}
