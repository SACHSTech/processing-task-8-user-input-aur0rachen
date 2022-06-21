import processing.core.PApplet;

public class Sketch extends PApplet {

  /**
   *  Global Variables
   */

    public boolean mClicked = false; 
    public boolean mDragged = false; 
    public boolean mWheel = false;

    public float stemSize = 25;

    public String message = ""; 

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */

  public void setup() {
    textSize(36);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {  
	  
    // Mouse Clicked - Draw Flowers
    if (mClicked) {
      // used to generate random flower size;
      float petalSize = random(5, 25);
      float petalDistance = petalSize/2;

      // used to generate random flower colours
      int r = (int)(Math.random() * 256);
      int g = (int)(Math.random() * 256);
      int b = (int)(Math.random() * 256);
      
      fill(r, g, b);
      // upper-left petal
      ellipse(mouseX - petalDistance, mouseY - petalDistance, petalSize, petalSize);
      // upper-right petal
      ellipse(mouseX + petalDistance, mouseY - petalDistance, petalSize, petalSize);
      // lower-left petal
      ellipse(mouseX - petalDistance, mouseY + petalDistance, petalSize, petalSize);
      // lower-right petal
      ellipse(mouseX + petalDistance, mouseY + petalDistance, petalSize, petalSize);
      // middle part
      fill(255,238,56);
      ellipse(mouseX, mouseY, petalSize, petalSize);
      // Stem
      fill(21, 191, 30);
      rect(mouseX, mouseY + petalSize, 2, stemSize);
      mClicked = false;
    }
    // Mouse Dragged - Create Grass
    if (mDragged) {
      fill(0, 102, 82);
      rect(mouseX, mouseY, mouseX, 400);
      mDragged = false;
    }    
    
    // Mouse wheel - Create Bugs
    if (mWheel) {
      fill(207, 14, 200);
      ellipse(mouseX, mouseY, 8, 10);
      mWheel = false;
    }

    fill(0);
    text(message, 120, 50);
  } 
 
  // define other methods down here.
  // Mouse
  public void mouseClicked () {
    mClicked = true;
  }

  public void mouseDragged() {
    mDragged = true;
  }

  public void mouseWheel() {
    mWheel = true;
  }

  // Keyboard
  public void keyPressed() {
    if (keyPressed) {
      if (key == 'b') {
        // Colour the background blue
        background(3, 136, 252);
      } 
      if (keyCode == SHIFT) {
        // draw sun
        fill(252, 227, 3);
        ellipse(325, 75, 35, 35);
      }
    }  
  }

  public void keyTyped() {
    if (key != 'b') {
      message += key;
    }
  }
}