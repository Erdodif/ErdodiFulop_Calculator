package hu.petrik.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HelloController {
    private static Boolean modosit = false;
    @FXML
    public Label output;
    @FXML
    public Spinner<Double> szamElso;
    @FXML
    public Spinner<Double> szamMasodik;
    @FXML
    public Button addition;
    @FXML
    public Button subtraction;
    @FXML
    public Button multiplication;
    @FXML
    public Button division;
    @FXML
    public Button modulus;

    private boolean tartalomValid(){
        boolean ki = true;
        if(szamElso.getValue() == null || szamMasodik.getValue() == null){
            output.setText("Mezők kitölése kötelező");
            ki = false;
        }
        return ki;
    }

    @FXML
    public void addition(ActionEvent actionEvent) {
        if (tartalomValid()){
            output.setText(Double.toString(szamElso.getValue() + szamMasodik.getValue()));
            output.getStyleClass().removeAll("hiba");
        }
    }

    @FXML
    public void subtraction(ActionEvent actionEvent) {
        if (tartalomValid()){
            output.setText(Double.toString(szamElso.getValue() - szamMasodik.getValue()));
            output.getStyleClass().removeAll("hiba");
        }
    }

    @FXML
    public void multiplication(ActionEvent actionEvent) {
        if(tartalomValid()){
            output.setText(Double.toString(szamElso.getValue() * szamMasodik.getValue()));
            output.getStyleClass().removeAll("hiba");
        }
    }

    @FXML
    public void division(ActionEvent actionEvent) {
        if(tartalomValid()){
            double elso = szamElso.getValue();
            double masodik = szamMasodik.getValue();
            if(elso == 0 || masodik == 0){
                output.setText("Nullával osztás!");
                output.getStyleClass().add("hiba");
            }
            else {
                output.setText(Double.toString( elso/masodik ));
            }
        }
    }

    @FXML
    public void modulus(ActionEvent actionEvent) {
        if (tartalomValid()){
            double elso = szamElso.getValue();
            double masodik = szamMasodik.getValue();
            if(elso == 0 || masodik == 0){
                output.setText("Nullával osztás!");
                output.getStyleClass().add("hiba");
            }
            else {
                output.setText(Double.toString( elso % masodik ));
            }
        }
    }
}