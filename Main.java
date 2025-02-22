import java.io.File;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception{
        File file = new File("SuperBowlData.txt");
        GameList game = new GameList(file);
        System.out.println(game.getSuperBowls());

    }
}
