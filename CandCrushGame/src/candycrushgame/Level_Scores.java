package candycrushgame;

import java.io.*;
import java.util.Scanner;

public class Level_Scores {

    public static int countOfLevel;
    public static int lastLevel;
    public boolean checkLevel = false;
    private int score;
    private int move = 15;
    private int level;
    private String projectDir = System.getProperty("user.dir");

    public int level() {
        /*--------------------------------------------------------------------------------------------*/
        /*----------------------- Set level according to the score --------------------------------- */
        /*------------------------------------------------------------------------------------------*/
        int currentLevel = level;
        if (score <= 100) {
            level = 1;
        } else if (score > 100 && score <= 250) {
            level = 2;
        } else if (score > 250 && score <= 450) {
            level = 3;
        } else if (score > 450 && score <= 700) {
            level = 4;
        } else if (score > 700 && score <= 1000) {
            level = 5;
        } else if (score > 1000 && score <= 1300) {
            level = 6;
        } else if (score > 1300 && score <= 1650) {
            level = 7;
        } else if (score > 1650 && score <= 2050) {
            level = 8;
        } else if (score > 2050 && score <= 2500) {
            level = 9;
        } else if (score > 2500 && score <= 3000) {
            level = 10;
        }
        System.out.println(level);
        System.out.println(currentLevel);
        if (getmoves() >= 0 && level > currentLevel && currentLevel > 0) {
            PopoutWindow popoutWindow = new PopoutWindow();
            popoutWindow.lbl.setText("Congratulation");
            move = 15;
            secondWindow.movesLbl1.setText("" + getmoves());
            popoutWindow.show();
            saveLevel();
        } else if (getmoves() == 0 && level == currentLevel && currentLevel > 0) {
            PopoutWindow popoutWindow = new PopoutWindow();
            popoutWindow.lbl.setText("Game Over");
            move = 15;
            score = 0;
            getScore();
            secondWindow.movesLbl1.setText("" + getmoves());
            popoutWindow.show();
        }
        return level;
    }

    public String getScore() {
        /*--------------------------------------------------------------------------------------------*/
        /*----------------------- Set record score according to the level--------------------------- */
        /*------------------------------------------------------------------------------------------*/
        String maxScore = "";
        switch (level) {
            case 1 ->
                maxScore = "/100";
            case 2 ->
                maxScore = "/250";
            case 3 ->
                maxScore = "/450";
            case 4 ->
                maxScore = "/700";
            case 5 ->
                maxScore = "/1000";
            case 6 ->
                maxScore = "/1300";
            case 7 ->
                maxScore = "/1650";
            case 8 ->
                maxScore = "/2050";
            case 9 ->
                maxScore = "/2500";
            case 10 ->
                maxScore = "/3000";
            default -> {
            }
        }
        return ("" + score + maxScore);
    }

    public void saveLevel() {
        /*-------------------------------------------------------------------------------------------------*/
        /*--------------------- save level in txt file for the next game ---------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/
        try {

            File file = new File(projectDir + "\\src\\level_score.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Level: " + level);
            bw.newLine();
            bw.write("Score: " + getScore());
            bw.close();
            System.out.println("Level and score saved to file.");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving level and score to file.");
            e.printStackTrace();
        }
    }

    public int loadLevel() {
        /*-------------------------------------------------------------------------------------------------*/
        /*----------------------------------- load level value -------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/
        try {
            File file = new File(projectDir + "\\src\\level_score.txt");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Level: ")) {
                    level = Integer.parseInt(line.substring(7));
                }
                else if (line.startsWith("Score: ")) {
                    score = Integer.parseInt(line.substring(7,line.indexOf("/")));
            }
            scanner.close();
            System.out.println("Level and score loaded from file.");
        }
    }catch (IOException e) {
            System.out.println("Error occurred while loading level and score from file.");
            e.printStackTrace();
        }
        return level;
    }

    public void moves() {
        move--;

    }

    /*-------------------------------------------------------------------------------------------------*/
    /*----------------------------------- return values and get values -------------------------------*/
    /*-----------------------------------------------------------------------------------------------*/
    public void score1() {
        score += 10;
    }

    public void score2() {
        score += 15;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getmoves() {
        return move;
    }

    public int getLevel() {
        return level;
    }

    public int getcountOfLevel() {
        return countOfLevel;
    }

    public int getLastLevel() {

        return lastLevel;

    }

    public void setScore(int score) {

        this.score = score;
    }

}
