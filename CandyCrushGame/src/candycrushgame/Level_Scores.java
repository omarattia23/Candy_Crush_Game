package candycrushgame;

import java.io.*;
import java.util.Scanner;

public class Level_Scores {
    public static int countOfLevel  ;
    private int score = 0;
    private int move = 15;
    private int level;
    private String projectDir = System.getProperty("user.dir");

    public int level() {
        if (score <= 100) {
            level = 1;
            countOfLevel=1;
        } else if (score > 100 && score <= 250) {
            level = 2;
            countOfLevel =2;
        } else if (score > 250 && score <= 450) {
            level = 3;
            countOfLevel =3;
        } else if (score > 450 && score <= 700) {
            level = 4;
            countOfLevel =4;
        } else if (score > 700 && score <= 1000) {
            level = 5;
            countOfLevel =5;
        } else if (score > 1000 && score <= 1300) {
            level = 6;
            countOfLevel =6;
        } else if (score > 1300 && score <= 1650) {
            level = 7;
            countOfLevel =7;
        } else if (score > 1650 && score <= 2050) {
            level = 8;
            countOfLevel =8;
        } else if (score > 2050 && score <= 2500) {
            level = 9;
            countOfLevel =9;
        } else if (score > 2500 && score <= 3000) {
            level = 10;
            countOfLevel =10;
        }
        return level;
    }

    public void score1() {
        score += 10;

    }

    public void score2() {
        score += 15;
    }

    public String getScore() {
        String maxScore = "";
        switch (level) {
            case 1:
                maxScore = "/100";
            case 2:
                maxScore = "/250";
            case 3:
                maxScore = "/450";
            case 4:
                maxScore = "/700";
            case 5:
                maxScore = "/1000";
            case 6:
                maxScore = "/1300";
            case 7:
                maxScore = "/1650";
            case 8:
                maxScore = "/2050";
            case 9:
                maxScore = "/2500";
            case 10:
                maxScore = "/3000";
            default: {
            }
        }
        return ("" + score + maxScore);
    }

    public void saveLevelScore() {
        try {

            File file = new File(projectDir + "\\src\\level_score.txt");
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
            File file = new File(projectDir + "\\src\\level_score.txt");

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

        if (move == 0 || countOfLevel >1) {
            PopoutWindow popoutWindow = new PopoutWindow();
            
            popoutWindow.show();
            
        }
    }
    
    public void setMove(int move) {
        this.move = move;
    }

    public int getmoves() {
        return move;
    }
     
    public int getcountOfLevel() {
        return countOfLevel;
    }
}
