/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.item;

import java.awt.image.BufferedImage;
import oop.gfx.Assets;

/**
 *
 * @author ASUS
 */
public class TowerFrozenItem extends TowerItem{
    
    public TowerFrozenItem(int id) {
        super(Assets.towerFrozen, "TowerFrozen", id, 20);
    }
    
}
