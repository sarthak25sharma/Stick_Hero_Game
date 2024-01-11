package com.example.final_propro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Admin {
    private static Admin admin = null;
    private Admin(){

    }
    public static  Admin getInstance(){
        if (admin==null){
            admin= new Admin();
        }

        return admin;
    }

    void score_update(Label label1, double score) {
        label1.setText("Score: " + score);
    }
    void finalscore_update(Label label2,double score){
        label2.setText("Final Score: "+score);
    }
    void score_update3(Label label3,double score) {
        label3.setText("Score: " + score);
    }
    void move_update(Label labelmove,int count) {
        labelmove.setText("Moves: " + count);
    }


}
