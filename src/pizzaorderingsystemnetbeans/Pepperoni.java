package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Class to draw one pepperoni.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class Pepperoni extends Toppings {

    /**
     * Constructor for objects of pepperoni and calls super constructor
     */
    public Pepperoni() {
        super();
    }

    /**
     * Method to draw a pepperoni on the screen using x and y points
     *
     * @param xPoint is the x coordinate of the center of a pizza
     * @param yPoint is the y coordinate of the center of a pizza
     * @param canvas is the canvas where the pepperoni will be drawn.
     */
    public void drawPepperoni(double xPoint, double yPoint, Canvas canvas) {
        //Center Pepperoni
        canvas.setForegroundColor(Color.RED);
        canvas.fillCircle(xPoint, yPoint, 30);
        canvas.setForegroundColor(Color.PINK);
        canvas.fillCircle(xPoint, yPoint, 4);
        canvas.fillCircle(xPoint - 6, yPoint - 6, 4);
        canvas.fillCircle(xPoint + 6, yPoint + 6, 4);
        canvas.fillCircle(xPoint + 6, yPoint - 6, 4);
        canvas.fillCircle(xPoint - 6, yPoint + 6, 4);
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(xPoint - 6, yPoint, 4);
        canvas.fillCircle(xPoint + 6, yPoint, 4);
        canvas.fillCircle(xPoint, yPoint + 6, 4);
        canvas.fillCircle(xPoint, yPoint - 6, 4);
    }

}
