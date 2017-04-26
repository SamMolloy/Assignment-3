
import java.util.ArrayList;

import Assignment.Enemy;
import processing.core.*;

public class Assignment3 extends PApplet{
	
	//instantiating objects
	Player player = new Player();
	Enemy enemy = new Enemy();
	Menu menu = new Menu();
	Border border = new Border();
	Collect collect = new Collect();
	Die die = new Die();
	Score score = new Score();
	
	//variable to let the game know when to begin
	char start = 'a';

	//array list to store all the enemies. (Polymorphism used here as it includes 2 different types of enemy
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	//variables for a time interval that speeds up the enemies as the game goes on
	float checktime, interval;
	
	public static void main(String[] args) {
		PApplet.main("Assignment3");

	}
	
    public void settings(){
    	size(500,500);

    }

    public void setup(){
    smooth();
    
	  //setting up a time interval to increase enemy speed every 8 seconds
	  checktime = millis();
	  interval = 8000;// 8 second time interval
    	
     //for loop that starts the game off with 3 enemies
  	  for (int i = 0; i<3; i++)
  	  {
  	    enemies.add(new Enemy());
  	  }//end for

    }

    public void draw(){
    background(0);
  	  switch(start)
  	  {
  	    case 'a': 
  	      menu.display();
  	      die.lives = 5;
  	      if(keyCode == ENTER)
  	      {
  	        start = 'b';
  	      }
  	      break;
  	    
  	    case 'b':
  	      player.run();
  	      die.display();
  	      die.collide();
  	      score.run();
  	      
  	    case 'c': 

  	  
  	   }//end switch

    }
    
	  //increases the enemy speed by 0.05 every 8 seconds
    public void addSpeed()
    {
      if(millis() > checktime+interval)
      {
        checktime = millis();
        enemy.speed = (float) (enemy.speed + 0.05);
      }
    }//end addSpeed

    
    public void keyPressed()
    {

        if(keyCode == ENTER)
        {
          start = 'b';
        }//end inner if
     
        if(keyCode == SHIFT)
        {
          start = 'a';
        }
        

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
      
    //setting the enemies random movement
      void move()
      {
        
        //setting the enemies movement
        randomX = randomX+speed*directionX;
        randomY = randomY+speed*directionY; 
           
        //stopping the enemy fromm moving off the screen
        if (randomX > 460)
        {
          randomX = 40;
        }//end if
        if (randomY > 460)
        {  
          randomY = 40;
        } //end if 
        if (randomX < 40)
        {
          randomX = 460;
        }//end if
        if (randomY < 40)
        {   
          randomY = 460;
        } //end if 
        
        //randomsing movement
        if(randMove <.25)
        {
          directionX = 1;
          directionY = 0;
        }
        if(randMove > .25 && randMove< 0.5)
        {
          directionX = -1;
          directionY = 0;
        }
            if(randMove >.5 && randMove < 0.75)
        {
          directionY = 1;
          directionX = 0;
        }
            if(randMove >.75)
        {
          directionY = -1;
          directionX = 0;
        }
      }
    }//end enemy
    
    public class Collect extends Enemy
    {
      
      void display()
      {

        //Drawing the enemy model;
        noStroke();
        fill (0, 255, 0); 
        rect (randomX, randomY, 20, 20, 5);
      }//end display
       
    }//end collect
    
    public class Border
    {

      Border()
      {
      }
      
      //draws the yellow border lines around the screen
      void display()
      {
        stroke(0, 0, 255);
        
        line(30, 30, 470, 30);
        line(30, 470, 470, 470);
        line(470, 30, 470, 470);
        line(30, 30, 30, 470);
         
      }  
    }//end border
    
    public class Enemy2 extends Enemy
    {
      //setting the faster speed of the new enemy
        float speed = (float) 2.75;
      
        void display()
      {
        //Drawing the enemy model;
        noStroke();
        fill (40, 235, 255 ); 
        rect (randomX, randomY, 15, 15, 5);
      }

      
    }//end enemy2
    
    public class Die
    {
      int lives = 5;
      Die()
      {
      }
      
      void display()
      {
        String s1 = "Lives: " + lives;
          fill(255,255,0);
          textSize(18);
          text(s1, 50, 490);
      }
      
      //checks for collision between the player and all the enemy objects and deducts a life if it hits
      //checks for collision between the player and all the enemy objects and deducts a life if it hits
      void collide()
      {
          for (int i = 0; i < enemies.size(); i++) 
          {
            float distance = dist(player.x, player.y, enemies.get(i).randomX, enemies.get(i).randomY);
            if(distance <= 35)
            {
              enemies.get(i).randomX = random(40, 460);
              enemies.get(i).randomY = random(40, 460);
               lives --;
            }//end if
          }//end for   

      }//end collide
      

      
    }//end die
    
    public class Score extends Die
	    {
	      int score = 0;
	      
	      
	      void run()
	      {
	        display();
	        collide();
	      }
	      
	      void display()
	      {
	        String s1 = "Score: " + score;
	        text(s1, 385, 490);
	      }
	      
	      void collide()
	      {
	        //checks the distance between the player and the green object
	        float distance = dist(player.x, player.y, collect.randomX, collect.randomY);
	        
	        if(distance <= 35)
	        {
	          //resets the green objects position
	          collect.randomX = random(40, 460);
	          collect.randomY = random(40, 460);
	          collect.randMove = random(1);
	          
	          score++;
	          
	         float rand = random(1);
	         //if score is above 3 it will add either a normal enemy or a smaller and faster orange enemy
	          if(rand < 0.5)
	          {
	            enemies.add(new Enemy2()); 
	          }//end if
	          else
	          {
	           enemies.add(new Enemy());
	          }//end else
	        }//end outer if
	        
	      }//end collide
	      
	    }//end Score
}
