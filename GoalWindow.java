import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class GoalWindow {
    protected static boolean onOpen() {
        Alert alrt = new Alert(AlertType.CONFIRMATION);
        alrt.setTitle(null);
        alrt.setHeaderText("GOAL!");
        alrt.setContentText("continue?");
        Optional<ButtonType> result = alrt.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    protected static void onOpenFail() {
        Alert alrt = new Alert(AlertType.INFORMATION);
        alrt.setTitle(null);
        alrt.setHeaderText("OPEN FAIL");
        alrt.setContentText("You don't have keys");
        alrt.showAndWait();
    }
}
