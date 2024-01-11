package com.example.final_propro;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class StickHero {

    private ImageView sth_class;
    @FXML
    private  static ImageView Stickhero;
    private  static StickHero st = null;
    private StickHero(ImageView s){
        this.sth_class=s;
    };
    public static StickHero getInstance(){
        if (st==null){
            st= new StickHero(Stickhero);
        }
        return st;
    }

    public ImageView getSth_class() {
        return sth_class;
    }
}
