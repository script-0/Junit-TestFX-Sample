package com.script0.testfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    
    public static Stage stage = null;
    @Override public void start(Stage stage) {
        Main.stage=stage;
        Parent sceneRoot = new ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void startForTests(Stage stage) {
         Main.stage=stage;
        Parent sceneRoot = new ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    // scene object for unit tests
    public static class ClickPane extends StackPane {
        public ClickPane() {
            super();
            Button button = new Button("click me!");
            button.setOnAction(actionEvent -> {
                 Parent sceneRoot = new ClickPane2();
                Scene scene = new Scene(sceneRoot, 100, 100);
                Main.stage.setScene(scene);
                Main.stage.show();
	 //button.setText("clicked!");
            });
            getChildren().add(button);
        }
    }
		
 public static class ClickPane2 extends StackPane {
        public ClickPane2() {
            super();
            Button button = new Button("clicked!");
            button.setOnAction(actionEvent -> {
	 button.setText("clicked!");
            });
            getChildren().add(button);
        }
    }
}