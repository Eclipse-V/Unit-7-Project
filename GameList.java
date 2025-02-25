import java.util.ArrayList;
import java.io.*;  
import java.util.Scanner;

public class GameList{
    //instance variable for the GameList object
    public ArrayList<Game> superBowls = new ArrayList<Game>();
    
    //constructor  
    //loops and scans through the text file
    public GameList() throws Exception{
        File file = new File("SuperBowlData.txt"); //access to the textfile
        Scanner text = new Scanner(file);
        text.nextLine(); //skips the first line
         while(text.hasNextLine()){ //loops through the textfile until there are no lines left
             String str = text.nextLine(); //gets the line

             //looks for when there are commas in the line
             int index1 = str.indexOf(",");
            int index2 = str.indexOf(",", index1 + 1);
            int index3 = str.indexOf(",", index2 + 1);
            int index4 = str.indexOf(",", index3 + 1);
            int index5 = str.indexOf(",", index4 + 1);
            int index6 = str.indexOf(",", index5 + 1);
            int index7 = str.indexOf(",", index6 + 1);
            int index8 = str.indexOf(",", index7 + 1);
            int index9 = str.indexOf(",", index8 + 1);
         
            //stored variables
            String numeral = str.substring(0, index1);
            int year = Integer.valueOf(str.substring((index2 + 2), (index3 - 1)));
            String winningTeam = str.substring(index3 + 1, index4);
            String location = str.substring((index8 + 2), (index9 - 1));
            String losingTeam = str.substring(index5 + 1, index6);
            String score = str.substring(index4 + 1, index5);

            //makes a new object with the variables and adds them into the ArrayList
            Game g = new Game(numeral, year, location, winningTeam, losingTeam, score);
            superBowls.add(g);
         }
         
    }

    //getter
    public ArrayList<Game> getSuperBowls(){
        return superBowls;
    }

    //method for returning the amount of wins a team has
    //loops through the list for instances of the winning team and keeps count
    public int numWins(String teamName){
        int count = 0;
        for (Game game: superBowls){
            String teamWin = game.getWinningTeam();
            if(teamName.equals(teamWin)){
                count++;
            }
        }
        return count;
    }

    //method for sorting the superBowls variable by the chronological year    
    public void sortByYear(){
        for (int i = 0; i < superBowls.size() - 1; i++){
            int minIndex = i;
            Game currentGame = superBowls.get(i);
            int minYear = currentGame.getYear();
            for(int j = i + 1; j < superBowls.size(); j++){
                Game nextGame = superBowls.get(j);
                if(nextGame.getYear() < minYear){
                    minYear = nextGame.getYear();
                    minIndex = j;
                }
            }
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(minIndex));
            superBowls.set(minIndex, temp); 
        }

    }

    //method for sorting the superBowls variable by the winning team by alphabetical order
    public void sortByWinningTeam(){
        for (int i = 0; i < superBowls.size() - 1; i++){
            int minIndex = i;
            Game currentGame = superBowls.get(i);
            String firstWinningTeam = currentGame.getWinningTeam();
            for(int j = i + 1; j < superBowls.size(); j++){
                Game nextGame = superBowls.get(j);
                if(nextGame.getWinningTeam().compareTo(firstWinningTeam) < 0){
                    firstWinningTeam = nextGame.getWinningTeam();
                    minIndex = j;
                }    
            }
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(minIndex));
            superBowls.set(minIndex, temp); 
        }
    }

    //sorts the superBowls variable by the greatest to least point difference
    public void sortByPointDifferential(){
        for (int i = 0; i < superBowls.size() - 1; i++){
            int minIndex = i;
            Game currentGame = superBowls.get(i);
            String minScoreDiff = currentGame.getScore();
            //getting the score differnce 
            int dash1 = minScoreDiff.indexOf("\–");
            int firstScore1 = Integer.valueOf(minScoreDiff.substring(0, dash1));
            int secondScore1 = Integer.valueOf(minScoreDiff.substring(dash1 + 1));
            int diff1 = Math.abs((firstScore1 - secondScore1));
            
            for(int j = i + 1; j < superBowls.size(); j++){
                Game nextGame = superBowls.get(j);
                String nextScoreDiff = nextGame.getScore();
                int dash2 = minScoreDiff.indexOf("\–");
                int firstScore2 = Integer.valueOf(nextScoreDiff.substring(0, dash1));
                int secondScore2 = Integer.valueOf(nextScoreDiff.substring(dash1 + 1));
                int diff2 = Math.abs((firstScore2 - secondScore2));
                if(diff2 > diff1){
                    diff1 = diff2;
                    minIndex = j;
                }
            }
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(minIndex));
            superBowls.set(minIndex, temp); 
        }
    }
    
    
}
