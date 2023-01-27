package edu.wpi.teamname.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
  @FXML private TextField amountField;
  @FXML private TextField rateField;
  @FXML private TextField yearField;
  @FXML private Button computeButton;

  public MainController() {
    /* Inject entity objects */
  }

  /** Set the properties of the mortgage model and calculate the montly interest */
  @FXML
  private void calculateTotalClicked() {}

  /**
   * Enables the calculate button if every text box is filled. Disables it if any text box is empty
   */
  @FXML
  private void validateButton() {}
}
