/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.item;

import oop.gfx.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author ASUS
 */
public class TowerBasicItem extends TowerItem{
    
    public TowerBasicItem(int id) {
        super(Assets.towerBasic, "TowerBasic", id, 10);
    }
    
}
