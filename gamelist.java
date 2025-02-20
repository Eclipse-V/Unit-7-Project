import java.util.ArrayList;
import java.io.*;  
import java.util.Scanner;

public class GameList{
    private ArrayList<Game> = mew<Game>();
    
    public GameList() throws Exception{
        File file = new File("src/main/java/SuperBowlData.txt");
        Scanner text = new Scanner(file);
         
         while(text.hasNextLine()){
             str = text.nextLine();
         }
         int index1 = str.indexOf(",");
         int index2 = str.indexOf(",", index1 + 1);
         int index3 = str.indexOf(",", index2 + 1);
         int index4 = str.indexOf(",", index3 + 1);
         int index5 = str.indexOf(",", index4 + 1);
         int index6 = str.indexOf(",", index5 + 1);
         int index7 = str.indexOf(",", index6 + 1);
         int index8 = str.indexOf(",", index7 + 1);
         
         
        String numeral = str.substring(0, index1);
        int year = str.substring(index1 + 1, index2);
        String winningTeam = str.substring(index2 + 1, index3);
        String location = str.substring();
        String losingTeam;
        String score;
         
         
         
         
    }
    
    
    
}