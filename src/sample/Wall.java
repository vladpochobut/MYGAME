package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Wall extends Pane {
    Image blocksImg = new Image(getClass().getResourceAsStream("1.jpg"));
    ImageView block;
    public enum BlockType {
        PLATFORM, BRICK, BONUS, PIPE_TOP, PIPE_BOTTOM, INVISIBLE_BLOCK, STONE
    }
    public Wall(BlockType blockType, int x, int y) {
        block = new ImageView(blocksImg);
        block.setFitWidth(45);
        block.setFitHeight(45);
        setTranslateX(x);
        setTranslateY(y);

        switch (blockType) {
            case PLATFORM:
                block.setViewport(new Rectangle2D(0, 0, 16, 16));
                break;
            case BRICK:
                block.setViewport(new Rectangle2D(16, 0, 16, 16));
                break;
            case BONUS:
                block.setViewport(new Rectangle2D(384, 0, 16, 16));
                break;
            case PIPE_TOP:
                block.setViewport(new Rectangle2D(0, 128, 32, 16));
                block.setFitWidth(45 * 2);
                break;
            case PIPE_BOTTOM:
                block.setViewport(new Rectangle2D(0, 145, 32, 14));
                block.setFitWidth(45 * 2);
                break;
            case INVISIBLE_BLOCK:
                block.setViewport(new Rectangle2D(0, 0, 16, 16));
                block.setOpacity(0);
                break;
            case STONE:
                block.setViewport(new Rectangle2D(0, 16, 16, 16));
                break;
        }
        getChildren().add(block);
    }
}
