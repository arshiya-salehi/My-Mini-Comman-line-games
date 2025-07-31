import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Mypanel extends JPanel{

  private Image airplane;
  private JLabel gameOver;
  private JLabel score;
  private int scoreNum;
  private JButton start;       // start the game
  private int y;    // for the plain
  private Timer render;
  private TimerTask refresh;
  private JButton jump;
  private Timer spawning;
  private TimerTask movingX;
  
  private boolean end;   // become true when we want to 
  private int yPosition;  // for the rec
  private int  xPosition; // for the rec
  private final int recW=70;   // size
  private final int recH=100;  // size   
  
  
  private final int WIDTH = 600;   // panel size
  private final int HEIGHT = 600;  // panel size
  
  
  Mypanel(){
    this.yPosition=randY();
    this.xPosition=600;
    this.y=100;
    this.scoreNum=0;
    this.end=false;
    airplane= new ImageIcon("combat2.png").getImage();
    this.setPreferredSize(new Dimension(600,600));
    gameOver= new JLabel("Game Over");
    gameOver.setVisible(false);
    score= new JLabel("Score is: "+scoreNum);
    score.setVisible(false);
    start= new JButton("begin");
    jump= new JButton("jump");

    
    render= new Timer();
    refresh= new TimerTask() {
      public void run(){
        if(!end) {
          gravity();
          checkY();
        } else {
          gameOver.setVisible(true);
          score.setText("Score is: "+scoreNum);
          score.setVisible(true);
        }
      }
    };

    spawning=new Timer();
    movingX= new TimerTask(){
      public void run(){
        xPosition-=10;
        repaint();
        if(xPosition==600){
          yPosition=randY();
        }
      }
    };
    
    class startListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
        render.scheduleAtFixedRate(refresh,0,20);
        spawning.scheduleAtFixedRate(movingX,0,50);
			}
		}
		start.addActionListener(new startListener());

    class jumpListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
        if(!end){
          y-=70;
          checkEnd();
        }
      }
    }
    jump.addActionListener(new jumpListener());

  this.add(start);
  this.add(jump);
  this.add(gameOver);
  this.add(score);
    
  }
  
  public void paintComponent(Graphics g){   // drawing
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.fillRect(0,0,WIDTH,HEIGHT);
    g.setColor(Color.BLACK);
    g.fillRect(0,550,WIDTH,HEIGHT-500);
    g.drawImage(airplane,0,y,null);
    g.setColor(Color.BLACK);
    g.fillRect(xPosition,0,recW,yPosition);
    g.fillRect(xPosition,yPosition+recH,recW,500);
    }

  
    public void gravity(){    // going down
        y+=5;
        repaint();
        checkEnd();
    }

    public void checkEnd(){   // if it hits the ground
      if(y>500){
        end=true;
      }
    }

    public int randY(){ // make a random position for hte space
      return (int)(Math.random()*300+1);
    }

    public void checkY(){      // check if you pass the area or not
      if(y<yPosition+recW && y>yPosition && xPosition<20 && xPosition>0){
        scoreNum++;
        xPosition=600;
        yPosition=randY();
      }else if(xPosition<0){
        end=true;
      }
    }
}


// make space between the lavbels and button or could possibly put it on together 