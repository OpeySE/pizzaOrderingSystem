package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Class to draw one pineapple.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class Pineapple extends Toppings {

    /**
     * Constructor for objects of pineapple and calls super constructor
     */
    public Pineapple() {
        super();
    }

    /**
     * Method to draw a pineapple on the screen using x and y points.
     *
     * @param xPoint is the x coordinate of the center of a pizza.
     * @param yPoint is the y coordinate of the center of a pizza.
     * @param canvas is the canvas where the pineapple will be drawn.
     */
    public void drawPineapple(double xPoint, double yPoint, Canvas canvas) {
        int index = 1;
        for (index = 1; index < 6; index++) {
            int len1 = 5;
            int len2 = 10;
            int len3 = 15;
            if (index == 1) {
                canvas.setForegroundColor(Color.YELLOW);
                canvas.fillTriangle(xPoint + len1, yPoint + len2, xPoint + len1, yPoint - len2, xPoint + len3, yPoint - len2);
                canvas.fillTriangle(xPoint - len1, yPoint + len2, xPoint - len1, yPoint - len2, xPoint - len3, yPoint - len2);
                //canvas.setForegroundColor(Color.BLUE);
                canvas.fillRectangle(xPoint - len1, yPoint - len2, len1 * 2, len2 * 2);
            } else if (index == 2) {
                len1 = 4;
                len2 = 8;
                len3 = 12;
                canvas.setForegroundColor(Color.WHITE);
                canvas.fillTriangle(xPoint + len1, yPoint + len2, xPoint + len1, yPoint - len2, xPoint + len3, yPoint - len2);
                canvas.fillTriangle(xPoint - len1, yPoint + len2, xPoint - len1, yPoint - len2, xPoint - len3, yPoint - len2);
                canvas.fillRectangle(xPoint - len1, yPoint - len2, len1 * 2, len2 * 2);
            } else if (index == 3) {
                len1 = 3;
                len2 = 6;
                len3 = 9;
                canvas.setForegroundColor(Color.YELLOW);
                canvas.fillTriangle(xPoint + len1, yPoint + len2, xPoint + len1, yPoint - len2, xPoint + len3, yPoint - len2);
                canvas.fillTriangle(xPoint - len1, yPoint + len2, xPoint - len1, yPoint - len2, xPoint - len3, yPoint - len2);
                canvas.fillRectangle(xPoint - len1, yPoint - len2, len1 * 2, len2 * 2);
            } else if (index == 4) {
                len1 = 2;
                len2 = 4;
                len3 = 6;
                canvas.setForegroundColor(Color.WHITE);
                canvas.fillTriangle(xPoint + len1, yPoint + len2, xPoint + len1, yPoint - len2, xPoint + len3, yPoint - len2);
                canvas.fillTriangle(xPoint - len1, yPoint + len2, xPoint - len1, yPoint - len2, xPoint - len3, yPoint - len2);
                canvas.fillRectangle(xPoint - len1, yPoint - len2, len1 * 2, len2 * 2);
            } else if (index == 5) {
                len1 = 1;
                len2 = 2;
                len3 = 3;
                canvas.setForegroundColor(Color.YELLOW);
                canvas.fillTriangle(xPoint + len1, yPoint + len2, xPoint + len1, yPoint - len2, xPoint + len3, yPoint - len2);
                canvas.fillTriangle(xPoint - len1, yPoint + len2, xPoint - len1, yPoint - len2, xPoint - len3, yPoint - len2);
                canvas.fillRectangle(xPoint - len1, yPoint - len2, len1 * 2, len2 * 2);
            }

        }
    }
}
