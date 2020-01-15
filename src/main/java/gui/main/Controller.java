package gui.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;

public class Controller {

    // Math
    public double PRICE = 0.0;
    public double AMOUNT = 0.0;
    public boolean CONVERSION_SETTING = false;

    // Messages
    public String selectPrompt = "Select a conversion!";
    public String selectConfirmation = "";
    public String noInput = "Enter a price and amount!";
    public String invalidInput = "Invalid input!";

    // Labels
    @FXML
    private Label enterPrice;
    private String priceText = "";
    @FXML
    private Label enterAmount;
    private String amountText = "";
    @FXML
    private Label inputInfo;
    private String inputText = "";
    @FXML
    private Label resultInfo;
    private String resultText = "";
    @FXML
    private Label status;

    // Text fields
    @FXML
    private TextField priceField;
    @FXML
    private TextField amountField;

    // Buttons
    @FXML
    private RadioButton usToCad;
    @FXML
    private RadioButton cadToUs;
    private boolean radioUsed;
    @FXML
    private Button convert;

    // Methods

    // sets text based on conversion selection
    @FXML
    public void chooseUS() {
        CONVERSION_SETTING = false;
        radioUsed = true;
        selectConfirmation = "US to CA selected.";
        status.setText(selectConfirmation);
        priceText = "Price per gallon:";
        amountText = "Gallons pumped:";
        enterPrice.setText(priceText);
        enterAmount.setText(amountText);
        System.out.println("US conversion selected");
    }
    @FXML
    public void chooseCA() {
        CONVERSION_SETTING = true;
        radioUsed = true;
        selectConfirmation = "CA to US selected.";
        status.setText(selectConfirmation);
        priceText = "Price per litre;";
        amountText = "Litres pumped:";
        enterPrice.setText(priceText);
        enterAmount.setText(amountText);
        System.out.println("CA conversion selected");
    }

    // convert button action
    @FXML
    public void onConvertClicked() {

        if ((priceField.getText().isEmpty() || amountField.getText().isEmpty())) {
            status.setText(noInput);
        } else if (!radioUsed) {
            status.setText(selectPrompt);
        } else {
            PRICE = Double.parseDouble(priceField.getText());
            AMOUNT = Double.parseDouble(amountField.getText());

            double imperialConversion = Math.round(AMOUNT * 0.2199692);
            double usdConversion = Math.round((PRICE * 0.75) * imperialConversion);

            double metricConversion = Math.round(AMOUNT * 4.54609);
            double cadConversion = Math.round((PRICE * 1.33) * metricConversion);

            if (!CONVERSION_SETTING) {
                inputText = "At $" + PRICE + " USD per each gallon, you've pumped " + AMOUNT + " gallons.";
                resultText = "Equivalent to paying $" + cadConversion + " CAD for " + metricConversion + " litres.";
                inputInfo.setText(inputText);
                resultInfo.setText(resultText);
            } else {
                inputText = "At $" + PRICE + " CAD per each litre, you've pumped " + AMOUNT + " litres.";
                resultText = "Equivalent to paying $" + usdConversion + " USD for " + imperialConversion + " gallons.";
                inputInfo.setText(inputText);
                resultInfo.setText(resultText);
            }
        }
    }
}
