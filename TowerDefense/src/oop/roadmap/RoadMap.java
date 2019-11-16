/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.roadmap;

import oop.entities.monster.Monster;

/**
 *
 * @author ASUS
 */
public abstract class RoadMap {
    Monster monster;

    public RoadMap(Monster monster) {
        this.monster = monster;
    }
    
    public abstract void MonsterMove();
}
