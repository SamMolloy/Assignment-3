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

}
