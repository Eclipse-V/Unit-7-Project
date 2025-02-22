public class Main
{
    public static void main(String[] args)  throws Exception{
        GameList game = new GameList();
        game.sortByYear();
        System.out.println(game.getSuperBowls());

    }
}
