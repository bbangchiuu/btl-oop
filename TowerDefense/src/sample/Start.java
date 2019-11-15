package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.TranslateTransition;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.KeyCode;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start {

    private int width = 1200, height = 720;
    private static final Font FONT = Font.font("", FontWeight.BOLD, 18);
    private static Font font;
    private MenuBox menu;
    private GameStage gameStage = new GameStage();

    public Start() throws FileNotFoundException, InterruptedException {
    }

    private Scene createGame() throws FileNotFoundException, InterruptedException {
        return gameStage.getMainScene();
    }
    private Scene createCredit() {

        StackPane root = new StackPane();
        root.setPrefSize(width,height);
        Rectangle bg = new Rectangle(width,height);
        bg.setOpacity(0.6);
        try (InputStream is = Files.newInputStream(Paths.get("src/Assets/bg2.jpg"));
             InputStream fontStream = Files.newInputStream(Paths.get("src/Assets/Font/cod_font.ttf"))) {
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(width);
            img.setFitHeight(height);

            root.getChildren().add(img);

            font = Font.loadFont(fontStream, 30);
        } catch (IOException e) {
            System.out.println("Couldn't load image or font");
        }
        Text credit = new Text("Tower Defense\n" +
                "by\n" +
                "Dai, Hao, Tiep\n" +
                "Source: https://github.com/Hajuha/TowerDefense2019");
        credit.setTextAlignment(TextAlignment.CENTER);
        credit.setFill(Color.WHITE);
        credit.setLineSpacing(2);
        credit.setFont(FONT);
        credit.setOpacity(1);
        root.getChildren().addAll(bg, credit);
        StackPane.setAlignment(credit, Pos.CENTER);
        Scene scene = new Scene(root);
        return scene;
    }


    public Stage createContent() throws FileNotFoundException, InterruptedException {
        Stage createContent = new Stage();
        Scene creditsScene = createCredit();
        Scene gameScene = createGame();
        Pane root = new Pane();
        root.setPrefSize(width,height);

        try (InputStream is = Files.newInputStream(Paths.get("src/Assets/bg2.jpg"));
             InputStream fontStream = Files.newInputStream(Paths.get("src/Assets/Font/cod_font.ttf"))) {
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(width);
            img.setFitHeight(height);

            root.getChildren().add(img);

            font = Font.loadFont(fontStream, 30);
        } catch (IOException e) {
            System.out.println("Couldn't load image or font");
        }
        Stage startStage = new Stage();
        startStage.setScene(createCredit());
        MenuItem itemQuit = new MenuItem("QUIT");
        itemQuit.setOnMouseClicked(event -> System.exit(0));
        MenuItem itemCredits = new MenuItem("CREDITS");
        itemCredits.setOnMouseClicked(e -> createContent.setScene(creditsScene));
        MenuItem itemStart = new MenuItem("NEW GAME");
        itemStart.setOnMouseClicked(e -> createContent.setScene(gameScene));
        menu = new MenuBox("TOWER DEFENSE",
                itemStart,
                itemCredits,
                itemQuit);

        root.getChildren().add(menu);
        Scene startScene = new Scene(root);
        creditsScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {

                createContent.setScene(startScene);
            }
        });
        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                createContent.setScene(startScene);
            }
        });
        createContent.setScene(startScene);
        startScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                if (menu.isVisible()) {
                    menu.hide();
                } else {
                    menu.show();
                }
            }
        });
        return createContent;
    }

    public Stage getMainStage() throws FileNotFoundException, InterruptedException {
        return createContent();
    }

    private static class MenuBox extends StackPane {
        public MenuBox(String title, MenuItem... items) {
            Rectangle bg = new Rectangle(400, 720);
            bg.setOpacity(0.5);

            DropShadow shadow = new DropShadow(7, 5, 0, Color.BLACK);
            shadow.setSpread(0.8);

            bg.setEffect(shadow);

            Text text = new Text(title + "   ");
            text.setFont(font);
            text.setFill(Color.WHITE);

            Line hSep = new Line();
            hSep.setEndX(250);
            hSep.setStroke(Color.DARKGREEN);
            hSep.setOpacity(0.4);

            Line vSep = new Line();
            vSep.setStartX(300);
            vSep.setEndX(300);
            vSep.setEndY(600);
            vSep.setStroke(Color.DARKGREEN);
            vSep.setOpacity(0.4);

            VBox vbox = new VBox();
            vbox.setAlignment(Pos.TOP_RIGHT);
            vbox.setPadding(new Insets(200, 0, 0, 0));
            vbox.getChildren().addAll(text, hSep);
            vbox.getChildren().addAll(items);

            setAlignment(Pos.TOP_RIGHT);
            getChildren().addAll(bg, vSep, vbox);
        }

        public void show() {
            setVisible(true);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), this);
            tt.setToX(0);
            tt.play();
        }

        public void hide() {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), this);
            tt.setToX(-300);
            tt.setOnFinished(event -> setVisible(false));
            tt.play();
        }
    }

    private static class MenuItem extends StackPane {
        public MenuItem(String name) {
            Rectangle bg = new Rectangle(300, 24);

            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK),
                    new Stop(0.2, Color.DARKGREY));

            bg.setFill(gradient);
            bg.setVisible(false);
            bg.setEffect(new DropShadow(5, 0, 5, Color.BLACK));

            Text text = new Text(name + "      ");
            text.setFill(Color.LIGHTGREY);
            text.setFont(Font.font(30));

            setAlignment(Pos.CENTER_RIGHT);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setVisible(true);
                text.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                bg.setVisible(false);
                text.setFill(Color.LIGHTGREY);
            });

            setOnMousePressed(event -> {
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseReleased(event -> {
                bg.setFill(gradient);
                text.setFill(Color.WHITE);
            });
        }
    }


}