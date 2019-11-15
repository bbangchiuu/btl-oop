package sample;

import javafx.scene.canvas.GraphicsContext;

public class BossEnemy extends sample.Enemy {
    final static int blood_first = 100;
    final static int armor_boss = 30;
    final static int speed_boss = 5;
    final static String Boss_Image = "/nameBossImg"; // get name to here

    public BossEnemy()
    {
        super();
        setFirst_Blood(blood_first);
        setArmor(armor_boss);
        setSpeed(speed_boss);
        loadImage(Boss_Image);
        //setPosition() /*** set first pss for bossGame***/
    }


    @Override
    public void Move() {
        /***set to direct in here***/

    }

    @Override
    public void RenderList(GraphicsContext mainGraphic) {

    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void ShowObject(GraphicsContext gc) {

    }

    @Override
    public void Render(GraphicsContext gc) {
        Move();
        gc.drawImage(image, x_pos, y_pos);
    }
}
