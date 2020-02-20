/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chcndmediaplayer;

import static chcndmediaplayer.TransferScene.transferScene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author houchule
 */
public class AboutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button Back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    @FXML
    private void Back(){
        transferScene("Player");
    }    
    
}
