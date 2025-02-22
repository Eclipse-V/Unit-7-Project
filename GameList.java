import java.util.ArrayList;
import java.io.*;  
import java.util.Scanner;

public class GameList{
    public ArrayList<Game> superBowls = new ArrayList<Game>();
    
    public GameList() throws Exception{
        File file = new File("SuperBowlData.txt");
        Scanner text = new Scanner(file);
        text.nextLine(); 
         while(text.hasNextLine()){
             String str = text.nextLine();
             int index1 = str.indexOf(",");
            int index2 = str.indexOf(",", index1 + 1);
            int index3 = str.indexOf(",", index2 + 1);
            int index4 = str.indexOf(",", index3 + 1);
            int index5 = str.indexOf(",", index4 + 1);
            int index6 = str.indexOf(",", index5 + 1);
            int index7 = str.indexOf(",", index6 + 1);
            int index8 = str.indexOf(",", index7 + 1);
            int index9 = str.indexOf(",", index8 + 1);
         
         
            String numeral = str.substring(0, index1);
            int year = Integer.valueOf(str.substring((index2 + 2), (index3 - 1)));
            String winningTeam = str.substring(index3 + 1, index4);
            String location = str.substring((index8 + 2), (index9 - 1));
            String losingTeam = str.substring(index5 + 1, index6);
            String score = str.substring(index4 + 1, index5);
            Game g = new Game(numeral, year, location, winningTeam, losingTeam, score);
            superBowls.add(g);
         }
         
    }

    public ArrayList<Game> getSuperBowls(){
        return superBowls;
    }

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

    //look back on this
    public void sortByYear(){
        for (int i = 0; i < superBowls.size(); i++){
            int minIndex = i;
            Game min = superBowls.get(i);
            for(int j = i + 1; j < superBowls.size(); i++){
                if(superBowls.get(j).getYear() < superBowls.get(minIndex).getYear()){
                    minIndex = j;
                    min = superBowls.get(j);
                }
                /*superBowls.set(minIndex, superBowls.get(i));
                superBowls.set(i, min);  */   
            }
            superBowls.set(minIndex, superBowls.get(i));
            superBowls.set(i, min); 
        }

        /*for(Game game: games){
            //Check the current min value
            int min = game.getYear();
            int minIndex = i;
            for(int j = i; j < games.size(); j++){
                if(games.get(j).getYear() < min){
                    min = games.get(j).getYear();
                    minIndex = j;
                }
        
        games.set(minIndex, game);
        games.set(game, minIndex);*/
    }

    public void sortByWinningTeam(){
        for (int i = 0; i < superBowls.size(); i++){
            int minIndex = i;
            Game min = superBowls.get(i);
            for(int j = i + 1; j < superBowls.size(); i++){
                if(superBowls.get(j).getWinningTeam().compareTo(superBowls.get(minIndex).getWinningTeam()) < 0){
                    minIndex = j;
                    min = superBowls.get(j);
                }    
            }
            superBowls.set(minIndex, superBowls.get(i));
            superBowls.set(i, min); 
        }
    }

    public void sortByPointDifferential(){
        for(int i = 0; i < superBowls.size(); i++){
            Game min = superBowls.get(i);
            int minIndex = i;
            String pointDiff1 = min.getScore();
            int dash1 = pointDiff1.indexOf("-");
            int firstScore1 = Integer.valueOf(pointDiff1.substring(0, dash1));
            int secondScore1 = Integer.valueOf(pointDiff1.substring(dash1));
            int diff1 = Math.abs(firstScore1 - secondScore1);
            for(int j = i + 1; j < superBowls.size(); j++){
                String pointDiff2 = superBowls.get(j).getScore();
                int dash2 = pointDiff2.indexOf("-");
                int firstScore2 = Integer.valueOf(pointDiff2.substring(0, dash2));
                int secondScore2 = Integer.valueOf(pointDiff2.substring(dash2));
                int diff2 = Math.abs(firstScore2 - secondScore2);
                if(diff2 < diff1){
                    min = superBowls.get(j);
                    minIndex = j;
                }
            }
            superBowls.set(minIndex, superBowls.get(i));
            superBowls.set(i, min);
        }
    }
    
    
}
