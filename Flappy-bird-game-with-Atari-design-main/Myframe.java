import javax.swing.*;

public class Myframe extends JFrame{ 

  Mypanel panel;
  public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
  
  Myframe(){
    panel = new Mypanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(WIDTH,HEIGHT);
    this.add(panel);
    this.pack();
    this.setResizable(false);
		this.setVisible(true);
  }
}