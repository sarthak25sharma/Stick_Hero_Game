package com.example.final_propro;
//Things to be done: while moving stick is extending handle that error.
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

import java.util.Random;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class HelloController{
    static int move_count=0;
    static int count =0;
    static boolean  count_flag=false;
    static boolean  write_flag=false;
    @FXML
    private Label labelmove;

    @FXML
    private AnchorPane anchor;
    @FXML
    private Button logout1 ;
    @FXML
    private Button help;
    @FXML
    private ImageView Stickhero;

    private boolean elongate = true;
    @FXML
    private Label label2;
    private boolean moving=false;

    private Timeline elongateTimeline;
    private Timeline rotateTimeline;
    private double pivotX;
    private double pivotY;
    private boolean horizontal=false;

    @FXML
    private  Rectangle stick;
    private  double originalStickHeight;
    @FXML
    private Label label1;
    private static double score=0;
    private static double cherries;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private ImageView cherry;
    @FXML
    private Label label3;
    static int stickpos;
    private Stage stage1;
    private Scene scene;
    private Parent root;
    private double updatedX=0;
    private double Ystick=0;
    private boolean rotating = false;
    private double BONUS_SCORE=2;
    @FXML
    private Rectangle r1;
    @FXML
    private Rectangle r2;
    int t=1;
    private static ImageView s;

    static Scene mainGameScene;
    static Scene maingame23;
    static int len;
    static Stage stage;

    boolean amIFlip=false;
    public void resumegame12(ActionEvent event) throws IOException {

        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(mainGameScene);
        stage.show();
    }

    private void checkCollision(){
        Bounds stickBounds = Stickhero.getBoundsInParent();
        Bounds cherryBounds = cherry.getBoundsInParent();
        if (stickBounds.intersects(cherryBounds)) {
            cherries+=1;
            updatecherry();
            moveCherryToRandomPosition();
        }
    }
    private void checkbuildingcollison(){
        if(amIFlip){
            falldown();
        }
    }
    public void updatecherry(){
        label5.setText("CHERRIES: "+cherries);
    }
    public void finalcheery(){
        label6.setText("FINAL CHERRIES: "+cherries);
    }
    private void moveCherryToRandomPosition() {
        cherry.setLayoutX(500);
    }
    public void switchtoscene1(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void restart(ActionEvent event)throws IOException{
        score=0;
        cherries=0;
        move_count=0;
        switchtoscene2(event);
    }
    @FXML
    public void revivefunc(ActionEvent event) throws IOException{
        if (cherries >= 3) {
            cherries-=3;
            move_count=0;
            switchtoscene2(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Not enough cherries to revive!", ButtonType.OK);
            alert.showAndWait();
        }

    }
    //gameplay
    public void switchtoscene2(ActionEvent event) throws IOException {
        FXMLLoader y=new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root= y.load();
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        StickHero stickhero=StickHero.getInstance();
        Stickhero=stickhero.getSth_class();
        ((HelloController)y.getController()).label1.setText("SCORE:"+score);
        ((HelloController)y.getController()).label5.setText("CHERRIES: "+(cherries));
        scene.setOnKeyPressed(a-> System.out.println(a.getCode()));
        mainGameScene=scene;
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoscene3(ActionEvent event) throws IOException {
        FXMLLoader abcd=new FXMLLoader(getClass().getResource("scene3.fxml"));
        Parent root= abcd.load();
        label3=((HelloController)(abcd.getController())).label3;
        updateScoreLabel3();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoscenehelp(ActionEvent event) throws IOException {
        FXMLLoader abcd=new FXMLLoader(getClass().getResource("help.fxml"));
        Parent root= abcd.load();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //game over
    public void switchtoscene4() throws IOException {
        FXMLLoader fcvg=new FXMLLoader(getClass().getResource("scene4.fxml"));
        Parent root= fcvg.load();
        label2=((HelloController)(fcvg.getController())).label2;
        label6=((HelloController)(fcvg).getController()).label6;
        finalscore();
        finalcheery();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void updateScoreLabel3() {
        Admin a= Admin.getInstance();
        a.score_update3(label3,score);
    }



    @FXML
    public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You are about to exit the application");
        alert.setContentText("Do you want to save before exiting");
        if (alert.showAndWait().get() == ButtonType.OK) {
            if (anchor != null) {
                stage = (Stage) anchor.getScene().getWindow();
                System.out.println("You have Exited Successfully");
                stage.close();
            } else {
                System.out.println("Error: AnchorPane is null.");
            }
        }

    }
    static boolean isFirst=true;
    @FXML
    void Pressing(MouseEvent event) {
        if(!moving) {
            elongate = true;
            //count_flag=true;
            elongateTimeline = new Timeline(
                    new KeyFrame(Duration.millis(10), e -> extend())
            );
            elongateTimeline.setCycleCount(Timeline.INDEFINITE);
            elongateTimeline.play();
        }
        else{
            if(isFirst) {
                Scale scale = new Scale();
                scale.setY(-1);
                scale.setPivotY(35);
                Stickhero.getTransforms().add(scale);
                amIFlip=true;
            }
            checkCollision();
        }
    }

    @FXML
    void done(MouseEvent event) {
        if(!moving) {
            elongate = false;

            if (elongateTimeline != null) {
                elongateTimeline.stop();
            }

            rotateStick();
        }
        else {
                Scale scale = new Scale();
                scale.setY(-1);
                scale.setPivotY(35);
                amIFlip=false;
                //isFirst=false;
                Stickhero.getTransforms().add(scale);
        }
    }


    private void extend() {
        if(!rotating&&!moving) {
            if (elongate) {
                stick.setHeight(stick.getHeight() + 1);
                stick.setY(stick.getY() - 1);
            }
        }
    }
    @FXML
    public void rotateStick() {
        if (!rotating && !moving) {
            rotating = true;
            double targetAngle = 90.0;
            double durationMillis = 1000.0;
            Rotate rotate = new Rotate(0, pivotX, pivotY);
            stick.getTransforms().add(rotate);
            rotateTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), targetAngle)
                    ));
            System.out.println("stick length" + stick.getHeight());

            if (t == 1) {
                double a = gap(r1, r2);
                double b = gaplimit(r1, r2);
                maingame23=mainGameScene;
                if (stick.getHeight() < a || stick.getHeight() > b) {
                    rotateTimeline.setOnFinished(event -> {
                        falldown();
                        rotating = false;
                    });
                    rotateTimeline.play();
                    horizontal = true;
                } else {
                    rotateTimeline.setOnFinished(event -> {
                        move();
                        rotating = false;
                    });
                    rotateTimeline.play();
                    horizontal = true;
                }
            } else if (t == 2) {
                double c = gap(r2, r1);
                double d = gaplimit(r2, r1);
                if (stick.getHeight() < c || stick.getHeight() > d) {
                    rotateTimeline.setOnFinished(event -> {
                        falldown();
                        rotating = false;
                    });
                    rotateTimeline.play();
                    horizontal = true;
                } else {
                    rotateTimeline.setOnFinished(event -> {
                        move();
                        rotating = false;
                    });
                    rotateTimeline.play();
                    horizontal = true;
                }

            } else {
                System.out.println("error");
            }
        }
    }

    private void resetStick() {
        Stickhero.setLayoutX(-15);
        stick.getTransforms().clear();
        stick.setHeight(10);
        stick.setY(0);
        System.out.println(stick.getLayoutY()+"Hello");
        stick.setLayoutY(268);
        stick.setLayoutX(t==1?r1.getWidth():r2.getWidth());
        horizontal = false;
        double i=(t==1?r1.getWidth():r2.getWidth())+10;
        double j=(t==1?r2.getLayoutX():r1.getLayoutX())-60;
        Random r = new Random();
        double randomValue = i + (j - i) * r.nextDouble();
        Random prob = new Random();

        cherry.setLayoutX(randomValue);
    }
    private void updateScoreLabel() {
        Admin a=Admin.getInstance();
        a.score_update(label1,score);

    }
    private void finalscore(){
        Admin a= Admin.getInstance();
        a.finalscore_update(label2,score);
    }

    public void move(){
        double d3=stick.getHeight();
        score+=d3%100;
        if(move_count%15==0){
            score=score+50;
        }
        updateScoreLabel();
        if (horizontal&&!moving) {
            moving=true;
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(Stickhero);
            translate.setDuration(Duration.millis(3000));
            translate.setByX(d3+(t==1?r2.getWidth():r1.getWidth()));
            translate.play();
            translate.setOnFinished(event -> {
                //checkCollision();
                checkbuildingcollison();
                updatedX = Stickhero.localToScene(Stickhero.getBoundsInLocal()).getMinX();
                moving=false;
                Tower_mover();
            });

        }

    }
    public void falldown(){
        TranslateTransition moveOnStickTransition = new TranslateTransition();
        moveOnStickTransition.setNode(Stickhero);
        moveOnStickTransition.setDuration(Duration.millis(1000));
        moveOnStickTransition.setByX(stick.getHeight()+(t==1?r2.getWidth():r1.getWidth()));
        moveOnStickTransition.play();
        moveOnStickTransition.setOnFinished(moveEvent -> {
            TranslateTransition fallTransition = new TranslateTransition();
            fallTransition.setNode(Stickhero);
            fallTransition.setDuration(Duration.millis(1000));
            fallTransition.setByY(235);
            fallTransition.play();
            fallTransition.setOnFinished(event -> {
                try {
                    switchtoscene4();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }



    public double gap(Rectangle r,Rectangle rr){
        double a=rr.getLayoutX();
        double b=r.getLayoutX()+r.getWidth();
        return (a-b);

    }
    public double gaplimit(Rectangle r,Rectangle rr){
        double a=gap(r,rr);
        double b=rr.getWidth();
        return a+b;
    }
    public void Tower_mover(){
        if (t == 1) {
            count_flag=true;
            System.out.println("h:"+t);
            stick.setHeight(0);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), r2);
            transition.setByX(-1*r2.getLayoutX());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                r2.setTranslateX(0);
                r2.setLayoutX(0);
                r2.setX(0);
                Stickhero.setLayoutX(0);
                Stickhero.setX(0);
                resetStick();
            });
            TranslateTransition transitionpic = new TranslateTransition(Duration.seconds(2), Stickhero);
            transitionpic.setToX(0);
            transitionpic.play();
            transitionpic.setOnFinished(actionEvent -> {
            });


            Random random = new Random();
            int minValue = 40;
            int maxValue = 70;
            int randomInt = random.nextInt((maxValue - minValue) + 1) + minValue;
            r1.setWidth(randomInt);
            r1.setTranslateY(500);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(2), r1);

            transition2.setToY(0);
            transition2.play();

            r1.setLayoutX(200);
            t = 2;
            if(write_flag) {
                Admin a = Admin.getInstance();
                a.move_update(labelmove, move_count);
                count++;
            }

        } else {
            count_flag=true;
            stick.setHeight(0);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), r1);
            transition.setByX(-1*r1.getLayoutX());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                r1.setTranslateX(0);
                r1.setLayoutX(0);
                r1.setX(0);
                Stickhero.setLayoutX(0);
                Stickhero.setX(0);
                resetStick();

            });
            TranslateTransition transitionpic = new TranslateTransition(Duration.seconds(2), Stickhero);
            transitionpic.setToX(0);
            transitionpic.play();
            transitionpic.setOnFinished(actionEvent -> {
            });
            Random random = new Random();
            int minValue = 40;
            int maxValue = 70;
            int randomInt = random.nextInt((maxValue - minValue) + 1) + minValue;
            r2.setWidth(randomInt);
            r2.setTranslateY(500);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(2), r2);
            transition2.setToY(0);
            transition2.play();
            r2.setLayoutX(200);
            t = 1;
            if(write_flag) {
                Admin a = Admin.getInstance();
                a.move_update(labelmove, move_count);
                count++;

            }


        }
    }
}