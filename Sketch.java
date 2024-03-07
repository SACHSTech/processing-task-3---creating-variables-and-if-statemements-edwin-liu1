import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */

   // variables
   int intScreenSize;

   // ball position variables
   int intPosX;
   int intPosY;
   int intMoveX;
   int intMoveY;

   // ball colour variables
   int BallColour;
   int RandColour;

   // time variables
   int sec;
   int min;
   int hour;

   /**
    * colour changing method
    *
    * @return RandColour a randomized colour
    */
   private int RandomColour() {

    RandColour = color( (int) random(255), (int) random(255), (int) random(255) );

    return RandColour;
   }

  public void settings() {
	// put your size call here
    size(600, 600);

    intPosX = width / 2;
    intPosY = height / 2;

    intMoveX = (int)random(2, 4);
    intMoveY = (int)random(2, 4);

    RandomColour();
    BallColour = RandColour;

  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255, 255, 255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  public void draw() {
    background(255);
    fill(BallColour);
    stroke(0);
    strokeWeight(2);
	  ellipse( intPosX, intPosY, 20, 20);
    
    // movement calculations
    intPosX = intPosX + intMoveX;
    intPosY = intPosY + intMoveY;

    // X axis

    // left of the window
    if (intPosX - 10 <= 0) {
      intMoveX = (int) random(2, 4);
      RandomColour();
    }
    // right of the window
    if (intPosX + 10 >= width) {
      intMoveX = (int) random(-2, -4);
      RandomColour();
    }

    // Y axis

    // top of the window
    if (intPosY - 10 <= 0) {
      intMoveY = (int) random(2, 4);
      RandomColour();
    }
    // bottom of the window
    if (intPosY + 10 >= width) {
      intMoveY = (int) random(-2, -4);
      RandomColour();
    }

    // for the colour change
    BallColour = RandColour;

    // time teller
    sec = second();
    min = minute();
    hour = hour();

    // clock

    // hours hand
    stroke(0);
    strokeWeight(5);
    line (width / 2 , height / 2 , (int) (Math.cos( (hour * 30 + min / 2)* 3.14f / 180 - 3.14f / 2) * 60 + (width / 2) ), (int) (Math.sin( (hour * 30 + min / 2)* 3.14f / 180 - 3.14f / 2) * 60 + (height / 2) ) ); 
    //minutes hand
    stroke(0);
    strokeWeight(3);
    line (width / 2 , height / 2 , (int) (Math.cos(min * 3.14f / 30 - 3.14f / 2) * 120 + (width / 2) ), (int) (Math.sin(min * 3.14f / 30 - 3.14f / 2) * 120 + (height/ 2) ) );
    // seconds hand
    stroke(255, 100, 100);
    strokeWeight(2);
    line (width / 2 , height / 2 , (int) (Math.cos(sec * 3.14f / 30 - 3.14f / 2) * 120 + (width / 2) ), (int) (Math.sin(sec * 3.14f / 30 - 3.14f / 2) * 120 + (height/ 2) ) );

  }

}