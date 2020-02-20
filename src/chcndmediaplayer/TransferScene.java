/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chcndmediaplayer;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author houchule
 */
public abstract class TransferScene {
    public static Scene  presentScene;
    public static final HashMap<String, TransferScene> hashMap = new HashMap();
    
    public Parent node;

    public void setNode(Parent node) {
        this.node = node;
    }
     public Parent getNode() {
        return node;
    }
    public static TransferScene editToList(String name){
        TransferScene controller;
        
        controller = hashMap.get(name);
        
        if(controller == null){
            try{
                FXMLLoader loader = new FXMLLoader(TransferScene.class.getResource(name + ".fxml"));
                Parent node = (Parent)loader.load();
                controller = (TransferScene)loader.getController();
                controller.setNode(node);
                hashMap.put(name, controller);
            }catch (IOException e){
                System.out.println(e);
            }
        }
        
        return controller;
    }
    
    public static void transferScene(String name){
        TransferScene controller = hashMap.get(name);
         if(controller != null){
            if(presentScene != null){
                presentScene.setRoot(controller.getNode());
            }
        }
        if(controller == null){
            controller = TransferScene.editToList(name);
        }
       
    }
    
}
