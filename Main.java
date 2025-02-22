import java.io.File;
public class Main
{
    public static void main(String[] args){
        File file = new File("SuperBowlData.txt");
        GameList game = new GameList(file);
        System.out.println(game.getSuperBowls());

    }
}
