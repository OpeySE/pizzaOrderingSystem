package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Class to represent a single pizza.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class Pizza {

    private final Canvas canvas;
    private int topLeftX;
    private int topLeftY;
    private int pizzaPosition;
    private final int pizzaSize;
    private final int pizzaBase;
    private final int pizzaSauce;
    private final int toppingOne;
    private final int toppingTwo;
    private final int numOfToppings;

    /**
     * Constructor for pizza.
     *
     * @param win the window to draw the pizza on.
     * @param position the position of the pizza based on the array of pizzas.
     * @param size the pizza size
     * @param base the pizza crust
     * @param sauce the pizza sauce
     * @param toppingOne the first ordered topping
     * @param toppingTwo the second ordered topping
     * @param numOfToppings the number of toppings on a pizza
     *
     */
    public Pizza(Canvas win, int position, int size, int base, int sauce,
            int toppingOne, int toppingTwo, int numOfToppings) {
        canvas = win;
        pizzaPosition = position;
        pizzaSize = size;
        pizzaBase = base;
        pizzaSauce = sauce;
        this.toppingOne = toppingOne;
        this.toppingTwo = toppingTwo;
        this.numOfToppings = numOfToppings;

    }

    /**
     * Method to set the pizza position.
     *
     * @param position the position of the pizza in the array
     * @return the new position of the pizza.
     */
    public int setPizzaPosition(int position) {
        return pizzaPosition = position;
    }

    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza() {
        topLeftX = calculateX(pizzaPosition);
        topLeftY = calculateY(pizzaPosition);
        drawPizza(topLeftX, topLeftY);
        drawTopLine(topLeftX, topLeftY);
        drawBottomLine(topLeftX, topLeftY);
    }

    /**
     * Method to calculate the x position of the pizza based on the position.
     *
     * @param position is the position of the pizza in the array of pizzas.
     * @return an integer based on the pizza position that is used for a x axis.
     */
    private int calculateX(int position) {
        //Caluate how to turn variable 1,2,3,4,5,6 to 0,300,600
        int xPosition;
        while (position > 3) {
            position -= 3;
        }
        if (position == 1) {
            xPosition = 0;
        } else if (position == 2) {
            xPosition = 300;
        } else {
            xPosition = 600;
        }
        return xPosition;
    }

    /**
     * Method to calculate the y position of the pizza based on the position.
     *
     * @param position is the position of the pizza in the array of pizzas.
     * @return an integer based on the pizza position that is used for a y axis.
     */
    private int calculateY(int position) {
        int yPosition;
        while (position > 6) {
            position -= 6;
        }
        if (position == 1 || position == 2 || position == 3) {
            yPosition = 0;
        } else {
            yPosition = 300;
        }
        return yPosition;
    }

    /**
     * Method to display the pizza on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    private void drawPizza(int topLeftX, int topLeftY) {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        drawSauce(topLeftX, topLeftY);
        drawToppings(topLeftX, topLeftY);
    }

    /**
     * Method to display the pizza sauce on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    private void drawSauce(int topLeftX, int topLeftY) {
        Enum sauce = Choices.values()[pizzaSauce];
        if (Choices.bbq == sauce) {
            canvas.setForegroundColor(Color.ORANGE);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 175);
        } else {
            canvas.setForegroundColor(Color.RED);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 175);
        }
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 150);
    }

    /**
     * Method to display the pizza toppings on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    private void drawToppings(int topLeftX, int topLeftY) {
        if (numOfToppings == 1) {
            Enum topping = Choices.values()[toppingOne];
            if (Choices.pineapple == topping) {
                fivePineapples(topLeftX, topLeftY);
            } else {
                fivePepperonis(topLeftX, topLeftY);
            }
        } else if (numOfToppings == 2) {
            Enum top1 = Choices.values()[toppingOne];
            Enum top2 = Choices.values()[toppingTwo];
            if (Choices.pineapple == top1 && Choices.pineapple == top2) {
                fivePineapples(topLeftX, topLeftY);
                fourPineapples(topLeftX, topLeftY);
            } else if (Choices.pineapple == top1 && Choices.pepperoni == top2) {
                fivePineapples(topLeftX, topLeftY);
                fourPepperonis(topLeftX, topLeftY);
            } else if (Choices.pepperoni == top1 && Choices.pineapple == top2) {
                fivePepperonis(topLeftX, topLeftY);
                fourPineapples(topLeftX, topLeftY);
            } else if (Choices.pepperoni == top1 && Choices.pepperoni == top2) {
                fivePepperonis(topLeftX, topLeftY);
                fourPepperonis(topLeftX, topLeftY);
            }
        }

    }

    /**
     * Method to draw five pineapples on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    public void fivePineapples(int topLeftX, int topLeftY) {
        new Pineapple().drawPineapple(topLeftX + 150, topLeftY + 150, canvas);
        new Pineapple().drawPineapple((topLeftX - 35) + 150, (topLeftY - 35) + 150, canvas);
        new Pineapple().drawPineapple((topLeftX + 35) + 150, (topLeftY + 35) + 150, canvas);
        new Pineapple().drawPineapple((topLeftX + 35) + 150, (topLeftY - 35) + 150, canvas);
        new Pineapple().drawPineapple((topLeftX - 35) + 150, (topLeftY + 35) + 150, canvas);
    }

    /**
     * Method to draw four pineapples on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    public void fourPineapples(int topLeftX, int topLeftY) {
        new Pineapple().drawPineapple((topLeftX - 35) + 150, topLeftY + 150, canvas);
        new Pineapple().drawPineapple((topLeftX) + 150, (topLeftY - 35) + 150, canvas);
        new Pineapple().drawPineapple((topLeftX + 35) + 150, topLeftY + 150, canvas);
        new Pineapple().drawPineapple(topLeftX + 150, (topLeftY + 35) + 150, canvas);
    }

    /**
     * Method to draw five pepperonis on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    public void fivePepperonis(int topLeftX, int topLeftY) {
        new Pepperoni().drawPepperoni(topLeftX + 150, topLeftY + 150, canvas);
        new Pepperoni().drawPepperoni((topLeftX - 35) + 150, (topLeftY - 35) + 150, canvas);
        new Pepperoni().drawPepperoni((topLeftX + 35) + 150, (topLeftY + 35) + 150, canvas);
        new Pepperoni().drawPepperoni((topLeftX + 35) + 150, (topLeftY - 35) + 150, canvas);
        new Pepperoni().drawPepperoni((topLeftX - 35) + 150, (topLeftY + 35) + 150, canvas);
    }

    /**
     * Method to draw four pepperonis on the screen.
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    public void fourPepperonis(int topLeftX, int topLeftY) {
        new Pepperoni().drawPepperoni((topLeftX - 35) + 150, topLeftY + 150, canvas);
        new Pepperoni().drawPepperoni(topLeftX + 150, (topLeftY - 35) + 150, canvas);
        new Pepperoni().drawPepperoni((topLeftX + 35) + 150, topLeftY + 150, canvas);
        new Pepperoni().drawPepperoni(topLeftX + 150, (topLeftY + 35) + 150, canvas);
    }

    /**
     * Method to write the information shown in the bottom line of the
     * individual pizza on the screen. This method will display the pizza number
     * and size at the top of the screen
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    private void drawTopLine(int topLeftX, int topLeftY) {
        String topLine = "Pizza: " + String.valueOf(pizzaPosition);

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 25;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }

    /**
     * Method to write the information shown in the bottom line of the
     * individual pizza on the screen. This method will display the type of
     * crust and sauce ordered (once completed)
     *
     * @param topLeftX is the top left x coordinates based on the pizza position
     * @param topLeftY is the top left y coordinates based on the pizza position
     */
    private void drawBottomLine(int topLeftX, int topLeftY) {
        String bottomLine = "Crust: " + Choices.values()[pizzaBase].toString();

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 290;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }

    /**
     * Method to calculate the cost of the pizza
     *
     * @return the total cost of a pizza
     */
    public double getTotalCost() {
        double crust = crustCost();
        double sauce = sauceCost();

        double topping1Cost = 0;
        double topping2Cost = 0;

        Enum topping1 = Choices.values()[toppingOne];
        Enum topping2 = Choices.values()[toppingTwo];

        if (Choices.pepperoni == topping1 && Choices.empty == topping2) {
            topping1Cost = 5 * 0.04;
        } else if (Choices.pineapple == topping1 && Choices.empty == topping2) {
            topping1Cost = 5 * 0.06;
        } else if (Choices.pepperoni == topping1 && Choices.pepperoni == topping2) {
            topping1Cost = 5 * 0.04;
            topping2Cost = 4 * 0.04;
        } else if (Choices.pineapple == topping1 && Choices.pineapple == topping2) {
            topping1Cost = 5 * 0.06;
            topping2Cost = 4 * 0.06;
        } else if (Choices.pepperoni == topping1 && Choices.pineapple == topping2) {
            topping1Cost = 5 * 0.04;
            topping2Cost = 4 * 0.06;
        } else if (Choices.pineapple == topping1 && Choices.pepperoni == topping2) {
            topping1Cost = 5 * 0.06;
            topping2Cost = 4 * 0.04;
        }

        double totalCost = crust + sauce + topping1Cost + topping2Cost;
        return (totalCost);
    }

    /**
     * Method to calculate the cost of the crust.
     *
     * @return the cost of the crust.
     */
    public double crustCost() {
        /**
         * Method to calculate the cost of the crust.
         *
         * @return the cost of the crust.
         *///Area of the pizza
        double area = 0;
        if (Choices.small == Choices.values()[pizzaSize]) {
            area = 78.54;
        } else if (Choices.medium == Choices.values()[pizzaSize]) {
            area = 113.1;
        } else if (Choices.large == Choices.values()[pizzaSize]) {
            area = 153.94;
        }
        //price of the crust
        double crustCost = 0;
        if (Choices.deep == Choices.values()[pizzaBase]) {
            crustCost = area * 0.11;
        } else if (Choices.thin == Choices.values()[pizzaBase]) {
            crustCost = area * 0.08;
        } else if (Choices.stuffed == Choices.values()[pizzaBase]) {
            crustCost = area * 0.14;
        }
        return crustCost;
    }

    /**
     * Method to calculate the cost of the sauce.
     *
     * @return the cost of the sauce.
     */
    public double sauceCost() {
        //price of the sauce
        double sauceCost;
        if (Choices.bbq == Choices.values()[pizzaSauce]) {
            sauceCost = 0.5;
        } else {
            sauceCost = 0;
        }
        return sauceCost;
    }
}
