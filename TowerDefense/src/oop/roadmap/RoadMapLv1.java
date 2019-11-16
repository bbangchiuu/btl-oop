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
public class RoadMapLv1 extends RoadMap {

    protected boolean stage[] = new boolean[100];

    public RoadMapLv1(Monster monster) {
        super(monster);
        stage[0] = true;
    }

    @Override
    public void MonsterMove() {

        if (stage[0]) {
            if (monster.x >= 445) {
                stage[0] = false;
                stage[1] = true;
            } else {
                monster.x += monster.speed;
                monster.xMove = monster.speed;
            }
        } else if (stage[1]) {
            if (monster.y <= 65) {
                stage[1] = false;
                stage[2] = true;
            } else {
                monster.y -= monster.speed;
                monster.yMove = -monster.speed;
            }
        } else if (stage[2]) {
            if (monster.x >= 640) {
                stage[2] = false;
                stage[3] = true;
            } else {
                monster.x += monster.speed;
                monster.xMove = monster.speed;
            }
        } else if (stage[3]) {
            if (monster.y >= 510) {
                stage[3] = false;
                stage[4] = true;
            } else {
                monster.y += monster.speed;
                monster.yMove = monster.speed;
            }
        } else if (stage[4]) {
            if (monster.x >= 830) {
                stage[4] = false;
                stage[5] = true;
            } else {
                monster.x += monster.speed;
                monster.xMove = monster.speed;
            }

        } else if (stage[5]) {
            if (monster.y <= 65) {
                stage[5] = false;
                stage[6] = true;
            } else {
                monster.y -= monster.speed;
                monster.yMove = -monster.speed;
            }
        } else if (stage[6]) {
            if (monster.x >= 1025) {
                stage[6] = false;
                stage[7] = true;
            } else {
                monster.x += monster.speed;
                monster.xMove = monster.speed;
            }
        } else if (stage[7]) {
            if (monster.y >= 510) {
                stage[7] = false;
                stage[8] = true;
            } else {
                monster.y += monster.speed;
                monster.yMove = monster.speed;
            }
        } else if (stage[8]) {
            if (monster.x >= 1100) {
                stage[8] = false;
                monster.StatusFinish = true;
            } else {
                monster.x += monster.speed;
                monster.xMove = monster.speed;
            }
        }
    }

}
