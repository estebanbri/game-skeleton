package com.manager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AssetManager {

    public static BufferedImage[][] MENUBACKGROUND = load("/HUD/menuscreen.png", 128, 144);
    public static BufferedImage[][] font = load("/HUD/font.png", 8, 8);
    public static BufferedImage[][] PLAYER = load("/Sprites/playersprites.png", 16, 16);

    public static BufferedImage[][] load(String s, int w, int h) {
        BufferedImage[][] ret;
        try {
            BufferedImage spritesheet = ImageIO.read(AssetManager.class.getResourceAsStream(s));
            int width = spritesheet.getWidth() / w;
            int height = spritesheet.getHeight() / h;
            ret = new BufferedImage[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
                }
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading graphics.");
        }
        return null;
    }

    public static void drawString(Graphics2D g, String s, int x, int y) {
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 47) c = 36; // slash
            if (c == 58) c = 37; // colon
            if (c == 32) c = 38; // space
            if (c >= 65 && c <= 90) c -= 65; // letters
            if (c >= 48 && c <= 57) c -= 22; // numbers
            int row = c / font[0].length;
            int col = c % font[0].length;
            g.drawImage(font[row][col], x + 8 * i, y, null);
        }
    }
}
