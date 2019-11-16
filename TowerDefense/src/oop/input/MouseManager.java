/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.input;

import oop.entities.Player;
import oop.item.TowerItem;
import oop.ui.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author BangNguyen
 */
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPress, rightPress;
    private int mouseX, mouseY;
    private UIManager uiManager;
    boolean gamestart = false;

    Player player;

    public MouseManager() {

    }

    public void setBuyTower(Player player) {
        gamestart = true;
        this.player = player;

    }

    public void setUIManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gamestart) {

            if (mouseX >= player.getMenu().getX() + 70 && mouseX <= player.getMenu().getX() + 70 + TowerItem.ITEMWIDTH
                    && mouseY >= player.getMenu().getY() + 25 && mouseY <= player.getMenu().getY()+ 25 + TowerItem.ITEMHEIGHT + 10) {
                player.hand = 1;
                player.clickTower = true;
                player.typeItem = 0;
            }
            
            if (mouseX >= player.getMenu().getX() + 70 + TowerItem.ITEMWIDTH + 20 && mouseX <= player.getMenu().getX() + 70 + TowerItem.ITEMWIDTH*2 + 30
                    && mouseY >= player.getMenu().getY() + 25 && mouseY <= player.getMenu().getY()+ 25 + TowerItem.ITEMHEIGHT + 10) {
                player.hand = 1;
                player.clickTower = true;
                player.typeItem = 1;
            }
            
            if(mouseX >= 0 && mouseX <= 1200 && mouseY >= 0 && mouseY <= 700){
                player.clickTower = false;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("ban vua an chuot trai");
            leftPress = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("ban vua an chuot phai");
            rightPress = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("ban vua nhả chuột trái");
            leftPress = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("ban vua nhả chuột phải");
            rightPress = false;
        }

        if (uiManager != null) {
            //System.out.println("khac null");
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if (uiManager != null) {
            uiManager.onMouseMove(e);
        }
    }

    //GETTERS
    public boolean isLeftPress() {
        return leftPress;
    }

    public boolean isRightPress() {
        return rightPress;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

}
