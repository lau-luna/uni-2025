
/**
 * A tree that can be manipulated and draws itself with the canvas.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree {
    // instance variables - replace the example below with your own
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private Triangle leaves;
    private Square trunk;

    /**
     * Constructor for objects of class Tree
     */
    public Tree() {
        height = 100;
        width = 50;
        xPosition = 280;
        yPosition = 190;

        leaves = new Triangle();
        trunk = new Square();

        setup();
    }

    public void setup() {
        this.leaves.changeSize((int) Math.round((height / 3) * 2), width);
        this.trunk.changeSize((int) Math.round(width / 2));

        // Indicate a start position
        this.leaves.changePosition(this.xPosition, this.yPosition);
        this.trunk.changePosition(this.xPosition, this.yPosition);

        this.trunk.changeColor("brown");
        this.trunk.moveVertical((int) Math.round(((this.height / 3) * 2)));
        this.trunk.moveHorizontal((int) Math.round(-(this.width) / 4));

        // Make leaves & trunk visible
        this.trunk.makeVisible();
        this.leaves.makeVisible();
    }

}
