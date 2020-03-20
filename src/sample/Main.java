package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class Main extends Application {
  /*  private final Image IMAGE = new Image(getClass().getResourceAsStream("3.png"));
    private static final int COLUMNS = 12;
    private static final int COUNT = 12;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 159;
    private static final int WIDTH = 95;
    private static final int HEIGHT = 159;
*/
private HashMap<KeyCode,Boolean> keys = new HashMap<>();
    Image image = new Image(getClass().getResourceAsStream("3.png"));
    ImageView imageView = new ImageView(image);
    Hero player = new Hero (imageView);
    static Pane root = new Pane();


public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(476);//166
            player.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);//110
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(317);//0
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(159);//55
            player.moveX(-2);
        }
        else{
            player.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
 /*
        Pane root = new Pane();
        Image image = new Image(getClass().getResourceAsStream("1.jpg"));
        ImageView map = new ImageView(image);
        map.setFitHeight(600);
        map.setFitWidth(600);
        root.getChildren().add(map);

        Scene scene = new Scene (root, 1200,1200);

        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(500),
                COUNT,COLUMNS,
                OFFSET_X,OFFSET_Y,
                WIDTH,HEIGHT
        );

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        primaryStage.setScene(new Scene(new Group(imageView),600,600));
 //       primaryStage.setTitle("Pause");
 //       primaryStage.setScene(scene);
        primaryStage.show();*/
 root.setPrefSize(600,600);

        root.getChildren().addAll(player);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}
