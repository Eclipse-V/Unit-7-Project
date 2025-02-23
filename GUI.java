import java.awt.event.*; 
import javax.swing.*; 

public class GUI{

  public void runGUI() throws Exception{
    //creates a GameList object
    GameList g = new GameList();
    JFrame f=new JFrame("SuperBowl Data");  //Creates a Frame with Title
    final JTextField tf=new JTextField();  //Creates a text Field
    tf.setBounds(50,50, 100,20); 
    //setBounds(x location, y location, width, height)
    JButton b1=new JButton("Number of wins:");  //Creates a Button
    b1.setBounds(50,100,200, 30);
    JButton b2=new JButton("Order by Year");  //Creates a Button
    b2.setBounds(50,150,200,30);
    JButton b3=new JButton("Order by Winning Team");  //Creates a Button
    b3.setBounds(50,200,200,30);
    JButton b4=new JButton("Order by point Spread");  //Creates a Button
    b4.setBounds(50,250,200,30);
    

      //The block of code below this tells the program what to do when the button is clicked.
      b1.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 

          String textFieldValue = tf.getText();//Obtains String typed into text value
          System.out.println(g.numWins(textFieldValue));//Prints to Console
          } 
      });

      b2.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 
          g.sortByYear();
          System.out.println(g.getSuperBowls());
          } 
      });

      b3.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 
          g.sortByWinningTeam();
          System.out.println(g.getSuperBowls());
          } 
      });

      b4.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 
          g.sortByPointDifferential();
          System.out.println(g.getSuperBowls());
          } 
      });

      //Adds objects to our GUI, and sets basic preferences
      f.add(tf);
      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4); 
      f.setSize(400,600); 
      f.setLayout(null); 
      f.setVisible(true);
    }
}

