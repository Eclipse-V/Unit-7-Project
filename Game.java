public class Game{
    //instance variables for the Game object
    private String numeral;
    private int year;
    private String location;
    private String winningTeam;
    private String losingTeam;
    private String score;

    //constructor 
    public Game(String n, int y, String l, String w, String losing, String s){
        numeral = n;
        year = y;
        location = l;
        winningTeam = w;
        losingTeam = losing;
        score = s;
    }
    //getters
    public String getNumeral(){
        return numeral;
    }
    public int getYear(){
        return year;
    }
    public String getLocation(){
        return location;
    }
    public String getWinningTeam(){
        return winningTeam;
    }
    public String getLosingTeam(){
        return losingTeam;
    }
    public String getScore(){
        return score;
    }
    //setters
    public void setNumeral(String s){
        numeral = s;
    }
    public void setYear(int y){
        year = y;
    }
    public void setLocation(String l){
        location = l;
    }
    public void setWinningTeam(String w){
        winningTeam = w;
    }
    public void setLosingTeam(String losing){
        losingTeam = losing;
    }
    public void setScore(String s){
        score = s;
    }
    //toString method to format the variables 
    public String toString(){
        return "\nSuperbowl " + numeral + ": " + winningTeam + " defeated " + losingTeam + "\nScore: " + score + "\nYear: " + year + "\nLocation: " + location + "\n";
    }
    
}
