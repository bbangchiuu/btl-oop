/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import oop.Handler;
import oop.gfx.Assets;

/**
 *
 * @author ASUS
 */
public class UIImageButton_NewGame {

    private ClickListener clicker;
    protected boolean hovering = false;
    Handler handler;
    public UIImageButton_NewGame(Handler handler, ClickListener clicker) {
        this.handler = handler;
        this.clicker = clicker;
    }

    public void onMouseMove(MouseEvent e) {
        //System.out.println("(" + e.getX() + "," + e.getY() + ")");
        if(e.getX() >= handler.getWidth()/2 - 143 && e.getX() <= handler.getWidth()/2 - 143 + 286 
                && e.getY() >= handler.getHeight()/2 - 100 && e.getY() <= handler.getHeight()/2 - 100 + 56){
            hovering = true;
        }else{
            hovering = false;
        }
    }

    public void onMouseRelease(MouseEvent e) {
        if (hovering) {
            onClick();
        }
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.drawImage(Assets.NewGame, handler.getWidth()/2 - 143, handler.getHeight()/2 - 100, null);   
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        if (hovering) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.YELLOW);
        }
        
        g.drawString("New Game", handler.getWidth()/2 - 75, handler.getHeight()/2 - 65);
    }

    public void onClick() {
        clicker.onClick();
    }
}
