package edu.wpi.teamname.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LabelController implements Initializable {

  @FXML private Label totalLabel;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // totalLabel.textProperty().bind(Bindings.format("$%.2f", Fill In This Variable ));
  }
}
