package com.sogilis.idfx.callback;

import com.sogilis.idfx.Main;
import com.sogilis.ui.ErrorDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Locale;

public class LoginCallbacks {

    @FXML private TextField agentId;
    @FXML private PasswordField agentPassword;

    private void switchToTollScene() {
        Main.primaryStage.setScene(Main.tollScene);
        agentId.clear();
        agentPassword.clear();
    }

    private boolean passwordCorrect() {
        String agentIdValue = agentId.getText();
        String agentPasswordValue = agentPassword.getText();
        return agentIdValue.equals("jack") && agentPasswordValue.equals("toto");
    }

    @FXML protected void onConnectionPressed(ActionEvent event) throws IOException {
        if (passwordCorrect()) {
            switchToTollScene();
        } else {
            ErrorDialog.showIncorrectCredentialsPopup(event);
        }
    }

    @FXML public void setFrench() throws IOException {
        Main.rebuildAllScenes(Locale.FRANCE);
        selfReload();
    }

    @FXML public void setEnglish() throws IOException {
        Main.rebuildAllScenes(Locale.ENGLISH);
        selfReload();
    }

    private void selfReload() {
        String agentIdValue = agentId.getText();
        String agentPasswordValue = agentPassword.getText();

        Main.primaryStage.setScene(Main.loginScene);

        ((TextField) Main.loginScene.lookup("#agentId")).setText(agentIdValue);
        ((PasswordField) Main.loginScene.lookup("#agentPassword")).setText(agentPasswordValue);
    }

}
