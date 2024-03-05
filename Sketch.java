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
    size(400, 400);

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
	  ellipse( intPosX, intPosY, 10, 10);
    
    // movement calculations
    intPosX = intPosX + intMoveX;
    intPosY = intPosY + intMoveY;

    // time teller
    sec = second();
    min = minute();

    // X axis

    // left of the window
    if (intPosX - 5 <= 0) {
      intMoveX = (int) random(2, 4);
      RandomColour();
    }
    // right of the window
    if (intPosX + 5 >= width) {
      intMoveX = (int) random(-2, -4);
      RandomColour();
    }

    // Y axis

    // top of the window
    if (intPosY - 5 <= 0) {
      intMoveY = (int) random(2, 4);
      RandomColour();
    }
    // bottom of the window
    if (intPosY + 5 >= width) {
      intMoveY = (int) random(-2, -4);
      RandomColour();
    }

    // for the colour change
    BallColour = RandColour;

  }

}