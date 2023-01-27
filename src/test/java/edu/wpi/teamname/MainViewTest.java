package edu.wpi.teamname;

import static org.testfx.api.FxAssert.verifyThat;

import edu.wpi.teamname.entity.Mortgage;
import edu.wpi.teamname.views.LabelController;
import edu.wpi.teamname.views.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

public class MainViewTest extends ApplicationTest {

  @Override
  public void start(Stage stage) throws Exception {
    Mortgage sharedMortgage = new Mortgage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("views/MainView.fxml"));
    loader.setControllerFactory(
        controllerClass -> {
          if (controllerClass.equals(LabelController.class)) {
            return new LabelController(sharedMortgage);
          } else {
            return new MainController(sharedMortgage);
          }
        });
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setAlwaysOnTop(true);
    stage.show();
  }

  @Test
  void testButtonEnables() {
    clickOn("#amountField");
    write("2000");
    clickOn("#rateField");
    write(".03");
    clickOn("#yearField");
    write("30");
    verifyThat("#computeButton", NodeMatchers.isEnabled());
  }

  @Test
  void testMortgage() {
    clickOn("#amountField");
    write("2000");
    clickOn("#rateField");
    write(".03");
    clickOn("#yearField");
    write("30");
    clickOn("#computeButton");

    double monthlyRate = .03 / 12;
    int n = 30 * 12;

    verifyThat(
        "#totalLabel",
        l ->
            ((Label) l)
                .getText()
                .equals(String.format("$%.2f", 2000 * Math.pow(1 + monthlyRate, n) / 12)));
  }
}
