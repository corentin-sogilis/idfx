package com.sogilis.idfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    public static Locale locale = Locale.ENGLISH;

    public static Stage primaryStage;
    public static Scene loginScene;
    public static Scene tollScene;

    private static Scene buildScene(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(
                Main.class.getResource(fxmlPath),
                ResourceBundle.getBundle("i18n", locale)
        );
        return new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setMinWidth(400);
        Main.primaryStage.setMinHeight(320);

        // Default locale English
        rebuildAllScenes(Locale.ENGLISH);

        String appTitle = ResourceBundle.getBundle("i18n", Locale.FRANCE).getString("app-title");
        primaryStage.setTitle(appTitle);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void rebuildAllScenes(Locale locale) throws IOException {
        Main.locale = locale;
        Main.loginScene = buildScene("/ui/LoginScene.fxml");
        Main.tollScene = buildScene("/ui/TollScene.fxml");
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

}
