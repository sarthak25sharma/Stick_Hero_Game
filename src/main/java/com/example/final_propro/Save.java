package com.example.final_propro;

import java.io.*;

public class Save implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double score;
    private int numberOfCherries;
    private int move_count;


    public Save() {
    }

    public void saveGame(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void loadGame(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Save loadedGame = (Save) inputStream.readObject();
            this.score = loadedGame.score;
            this.numberOfCherries = loadedGame.numberOfCherries;
            this.move_count=loadedGame.move_count;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getNumberOfCherries() {
        return numberOfCherries;
    }

    public void setNumberOfCherries(int numberOfCherries) {
        this.numberOfCherries = numberOfCherries;
    }

}

