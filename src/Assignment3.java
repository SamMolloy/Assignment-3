import processing.core.*;

public class Assignment3 extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Assignment3");

	}
	
    public void settings(){
    	size(500,500);

    }

    public void setup(){

    }

    public void draw(){

    }
    
    public class Menu
    {  
      
    
      Menu()
      {
      }
      
      void display()
      {
        //Strings for the start menu options
        String s1 = "Press Up Arrow to Start!";
        String s2 = "Arrow Keys to move";
        String s3 = "Collect green objects & avoid";
        String s4 = "everything else!";

        fill(0,0,255);
        textSize(20);
        text(s1, 120, 350);
        
        fill(0,0,255);
        textSize(20);
        text(s2, 140, 150);
     
        fill(0,0,255);
        textSize(20);
        text(s3, 90, 250);
        
        fill(0,0,255);
        textSize(20);
        text(s4, 165, 275);
      }//end display()
      
    }//end Menu
    
    public class Player
    {
        float radius = 17, directionX = 1, directionY = 0;
        float x=250, y=450, speed=0;
      
      Player()
      {
      }
      
      void run()
      {
        display();
        move();
        keyPressed();
      }//end run
      
      
      void display()
      {
        //Drawing the player model
        noStroke();
        fill (255, 255, 0); 
        ellipse (x, y, radius, radius);
      }//end display()
      
      
      void move()
      {
        //setting the players movement
        x=x+speed*directionX;
        y=y+speed*directionY; 
        
      }
           



      
      
      
    }//end Player()

}
