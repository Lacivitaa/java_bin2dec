package com.lacivita;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Main extends Application {

    Scene scene;
    Button button;
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        //Set title
        window = primaryStage;
        window.setTitle("Bin2Dec - IBM");

        //Form
        Label label = new Label("Bin2Dec - Converter");

        TextField binInput = new TextField();

        TextField decOutput = new TextField();

        button = new Button("Convert");
        button.setOnAction(c -> converterBin2Dec(binInput, decOutput));

        //Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20,20,20,20));
        vbox.getChildren().addAll(label,binInput, button, decOutput);

        scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void converterBin2Dec (TextField textInput, TextField textOutput){
        int binInt;
        int pot = 0;
        int result = 0;

        for (int x=textInput.getText().length(); x>0; x--){

            binInt = Integer.parseInt(textInput.getText().substring(x-1, x));

            if(binInt != 0 && binInt != 1 || textInput.getText().length() > 8){
                textInput.setText("Error! - Digit only 0 and 1, and no more than 8 digits");
                break;
            }
            else{
                result += (Math.pow(2,pot) * binInt);
                pot++;
            }
        }
        textOutput.setText(String.valueOf(result));
    }
}
