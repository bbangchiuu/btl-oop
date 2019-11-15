package HboxTower;

import HboxTower.HBoxTower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;
import sample.NormalTower;

public class Hbox_NormalTower extends HBoxTower {
    private final Image image_NormalTower = new Image("file:src/Assets/Tower/SniperTower.png",
                                    60 , 60, true, true);
    private final int X_Hbox = 0;
    private final int Y_Hbox = 700;
    public Hbox_NormalTower()
    {
        super();
        imageView_Hbox.setImage(image_NormalTower);
//        this.tower = new NormalTower();
    }

    @Override
    public void Render_Hbox(GraphicsContext gc) {

    }
}
