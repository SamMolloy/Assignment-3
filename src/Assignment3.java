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
        
        //stopping the player form moving off the screen
        if (x > 470)
        {
          x = 30;
        }//end if
        if (y > 470)
        {   
          y = 30;
        } //end if 
        if (x < 30)
        {
          x = 470;
        }//end if
        if (y < 30)
        {   
          y = 470;
        } //end if 
      }
           
    //Setting the movement controls
      void keyPressed()
      {
        if (key == CODED)
        {
          if (keyCode == LEFT)
          {    
            speed = (float) 2.75;
            directionX=-1;
            directionY=0;     
          }//end LEFT
        
          else if (keyCode == RIGHT)
          {  
            speed = (float) 2.75;
            directionX=1;
            directionY=0;    
          }//end RIGHT
        
          else if (keyCode == UP)
          {    
            speed = (float) 2.75;
            directionY=-1;
            directionX=0;     
          }//end UP
        
          else if (keyCode == DOWN)
          {
            speed = (float) 2.75;
            directionY=1;
            directionX=0;
          }//end DOWN
        }//end outer IF
      }//end keyPressed  

      
    }//end Player()
    
    public class Enemy
    {
      //variable used for the movement of the enemy
        int directionX = 0, directionY = 1;
        float speed=(float) 1.75; 
        float randomX = random(40, 460), randomY = random(40, 460);
        float randMove = random(1);
     
        
      Enemy()
      {
      }
      
      void run()
      {
        display();
        move();
      }
      
      
      void display()
      {
        //Drawing the enemy model;
        noStroke();
        fill (245, 95, 175); 
        rect (randomX, randomY, 20, 20, 5);
      }

}
