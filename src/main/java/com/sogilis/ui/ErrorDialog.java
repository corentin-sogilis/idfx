package com.sogilis.ui;

import com.sogilis.idfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class ErrorDialog {

    public static void showIncorrectCredentialsPopup(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ui/ErrorDialog.fxml"), ResourceBundle.getBundle("i18n", Main.locale));
        loader.setController(new Object() {
            @FXML private Button okButton;
            @FXML private void close(ActionEvent event) { ((Stage) okButton.getScene().getWindow()).close(); }
        });

        stage.setScene(new Scene(loader.load()));

        ResourceBundle i18n = ResourceBundle.getBundle("i18n", Main.locale);
        String title = i18n.getString("dialog-error-title");
        String label = i18n.getString("dialog-label-wrong-login-password");
        stage.setTitle(title);
        ((Label) stage.getScene().lookup("#errorLabel")).setText(label);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.showAndWait();
    }


}
