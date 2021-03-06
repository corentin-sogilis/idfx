package com.sogilis.idfx.callback;

import com.sogilis.idfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Locale;

public class TollCallbacks {

    @FXML private void onBackPressed(ActionEvent event) {
        Main.primaryStage.setScene(Main.loginScene);
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
        Main.primaryStage.setScene(Main.tollScene);
    }

}
