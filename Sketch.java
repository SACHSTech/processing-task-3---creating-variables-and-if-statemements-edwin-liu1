import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */

   int intScreenSize;
   int intPosX;
   int intPosY;
   int intMoveX;
   int intMoveY;

   private int ColourRandom() {
    int Colour;

    Colour =(int)random(255);

    return Colour;
   }

  public void settings() {
	// put your size call here
    size(400, 400);

    intPosX = width / 2;
    intPosY = height / 2;

    intMoveX = (int)random(2, 4);
    intMoveY = (int)random(2, 4);

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
    fill(0);
	  ellipse( intPosX, intPosY, 10, 10);

    intPosX = intPosX + intMoveX;
    intPosY = intPosY + intMoveY;

    // X axis
    if (intPosX - 10 <= 0) {
      intMoveX = (int) random(2, 4);
    }
    if (intPosX + 10 >= width) {
      intMoveX = (int) random(-2, -4);
    }

    // Y axis
    if (intPosY - 10 <= 0) {
      intMoveY = (int) random(2, 4);
    }
    if (intPosY + 10 >= width) {
      intMoveY = (int) random(-2, -4);
    }

  }

}