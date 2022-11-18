package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class PrimaryController implements Initializable {
    @FXML
    TextField myIpField = new TextField();

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

    private int playerTurn = 0;

    ArrayList<Button> buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button) {
        if (playerTurn % 2 == 0) {
            button.setText("X");
            playerTurn = 1;
        } else {
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver() {
        checkLineSuccess("X", button1, button2, button3);
        checkLineSuccess("X", button4, button5, button6);
        checkLineSuccess("X", button7, button8, button9);
        checkLineSuccess("X", button3, button5, button7);
        checkLineSuccess("X", button1, button4, button7);
        checkLineSuccess("X", button2, button5, button8);
        checkLineSuccess("X", button3, button6, button9);
        checkLineSuccess("O", button1, button2, button3);
        checkLineSuccess("O", button4, button5, button6);
        checkLineSuccess("O", button7, button8, button9);
        checkLineSuccess("O", button3, button5, button7);
        checkLineSuccess("O", button1, button4, button7);
        checkLineSuccess("O", button2, button5, button8);
        checkLineSuccess("O", button3, button6, button9);

        }


    //@FXML
   // private void switchToSecondary() throws IOException {
    //    App.setRoot("secondary");
    //}

    private void checkLineSuccess(String player, Button btn1, Button btn2, Button btn3) {
        if ( btn1.getText().equals(player) &&
                btn2.getText().equals(player) &&
                btn3.getText().equals(player)){
            winnerText.setText("You won!");
        }
    }
}
