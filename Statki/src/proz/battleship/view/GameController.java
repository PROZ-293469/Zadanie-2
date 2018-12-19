package proz.battleship.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

    @FXML
    private Button square00;
    
    @FXML
    private Button square01;    
	
    @FXML
    void boardSquare00Pressed(ActionEvent event) {
    	square00.setStyle("-fx-background-color: #ff0000; ");
    }
    
    @FXML
    void boardSquare01Pressed(ActionEvent event) {
    	square01.setStyle("-fx-background-color: #ff0000; ");
    }
	
}
