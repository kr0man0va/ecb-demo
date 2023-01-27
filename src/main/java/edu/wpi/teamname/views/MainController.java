package edu.wpi.teamname.views;

import edu.wpi.teamname.entity.Mortgage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
  @FXML private TextField amountField;
  @FXML private TextField rateField;
  @FXML private TextField yearField;
  @FXML private Button computeButton;

  private Mortgage mortgage;

  public MainController(Mortgage mortgage) {
    /* Inject entity objects */
    this.mortgage = mortgage;
  }

  /** Set the properties of the mortgage model and calculate the montly interest */
  @FXML
  private void calculateTotalClicked() {
    double amount = Double.parseDouble(amountField.getText());
    double rate = Double.parseDouble(rateField.getText());
    int year = Integer.parseInt(yearField.getText());

    this.mortgage.setAmount(amount);
    this.mortgage.setRate(rate);
    this.mortgage.setYears(year);

    mortgage.setMonthlyPayment();
  }

  /**
   * Enables the calculate button if every text box is filled. Disables it if any text box is empty
   */
  @FXML
  private void validateButton() {

    boolean valid =
        !this.amountField.getText().equals("")
            && !this.rateField.getText().equals("")
            && !this.yearField.getText().equals("");

    computeButton.setDisable(!valid);
  }
}
