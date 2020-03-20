package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Hero extends Pane {
    ImageView imageView;
    int columns =12 ;//4   12
    int count = 12;// 4  12
    int offsetX = 0;//0
    int offsetY = 159;// 55  159
    int width = 95;//54  95
    int height = 159;//55 159
    Rectangle removeRect = null;
    SpriteAnimation animation;


    public Hero(ImageView imageView)
        {
            this.imageView = imageView;
            this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
            animation = new SpriteAnimation(imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
            getChildren().addAll(imageView);
        }
        public void moveX(int x)
        {
            boolean right = x > 0?true:false;
            for(int i = 0 ; i < Math.abs(x);i++)
            {
                if(right) this.setTranslateX(this.getTranslateX()+1);
                else this.setTranslateX(this.getTranslateX()-1);

            }
        }
    public void moveY(int y)
    {
        boolean down = y > 0?true:false;
        for(int i = 0 ; i < Math.abs(y);i++)
        {
            if(down) this.setTranslateY(this.getTranslateY()+1);
            else this.setTranslateY(this.getTranslateY()-1);

        }
        Main.root.getChildren().remove(removeRect);
    }
}
