package com.main;

import javax.swing.*;

public class Main {

    private static final int FPS = 60;


    public static void main(String[] args) {
        JFrame window = new JFrame("Game Skeleton");

        window.add(new GamePanel());

        window.setResizable(false);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
