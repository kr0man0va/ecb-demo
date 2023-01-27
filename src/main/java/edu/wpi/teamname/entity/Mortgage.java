package edu.wpi.teamname.entity;

import javafx.beans.property.SimpleDoubleProperty;
import lombok.Getter;
import lombok.Setter;

public class Mortgage {

  @Setter @Getter double amount;
  @Setter @Getter double rate;
  @Setter @Getter int years;

  public SimpleDoubleProperty monthlyPayment = new SimpleDoubleProperty(0);

  public Mortgage() {}

  public void setMonthlyPayment() {
    int payPeriods = years * 12;
    double periodicRate = rate / 12;

    monthlyPayment.set(
                amount
                    / ((Math.pow(1 + periodicRate, payPeriods) - 1)
                        / (periodicRate * Math.pow(1 + periodicRate, payPeriods))));
  }
}
