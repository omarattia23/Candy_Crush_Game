package candycrushgame;

import java.io.*;
import java.util.Scanner;

public class Level_Scores {

    private int score = 0;
    private int move = 25;
    private int level;
    private String projectDir; // = System.getProperty("user.dir");
        
    public Level_Scores(){
         projectDir = System.getProperty("user.dir");
         System.out.println(System.getProperty("user.dir"));
    }
    public int level() {
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
        return level;
    }

    public void score() {
        score += 10;
    }

    public String getScore() {
        String maxScore = "";
        switch (level) {
            case 1:
                maxScore = "/100";
                break;
            case 2:
                maxScore = "/250";
                break;
            case 3:
                maxScore = "/450";
                break;
            case 4:
                maxScore = "/700";
                break;
            case 5:
                maxScore = "/1000";
                break;
            case 6:
                maxScore = "/1300";
                break;
            case 7:
                maxScore = "/1650";
                break;
            case 8:
                maxScore = "/2050";
                break;
            case 9:
                maxScore = "/2500";
                break;
            case 10:
                maxScore = "/3000";
                break;
            default:
                break;
        }
        return ("" + score + maxScore);
    }

    public void saveLevelScore() {
        try {
            
            File file = new File(projectDir + "\\level_score.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Level: " + level);
            bw.newLine();
            bw.write("Score: " + score);
            bw.close();
            System.out.println("Level and score saved to file.");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving level and score to file.");
            e.printStackTrace();
        }
    }

    public void loadLevelScore() {
        try {
            File file = new File(projectDir + "\\level_score.txt");
            
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Level: ")) {
                    level = Integer.parseInt(line.substring(7));
                } else if (line.startsWith("Score: ")) {
                    score = Integer.parseInt(line.substring(7));
                }
            }
            scanner.close();
            System.out.println("Level and score loaded from file.");
        } catch (IOException e) {
            System.out.println("Error occurred while loading level and score from file.");
            e.printStackTrace();
        }
    }

    

    public void moves() {
        move--;
    }

    public int getmoves() {
        return move;
    }

}
