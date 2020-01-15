package gui.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {

    // Math
    public double PRICE;
    public double AMOUNT;
    public boolean CONVERSION_SETTING;

    public final double IMPERIAL_CONVERSION = Math.round(AMOUNT * 0.2199692);
    public final double USD_CONVERSION = Math.round((PRICE * 0.75) * IMPERIAL_CONVERSION);

    public final double METRIC_CONVERSION = Math.round(AMOUNT * 4.54609);
    public final double CAD_CONVERSION = Math.round((PRICE * 1.33) * METRIC_CONVERSION);

    // Labels
    @FXML
    private Label enterPrice;
    @FXML
    private Label enterAmount;
    @FXML
    private Label inputInfo;
    @FXML
    private Label resultInfo;

    // Buttons
    @FXML
    private RadioButton usToCad;
    @FXML
    private RadioButton cadToUs;
    @FXML
    private Button convert;

    public void initialize() {

    }
}
