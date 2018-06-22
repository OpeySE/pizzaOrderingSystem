package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to manage the pizza order.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class OrderingSystem {

    private final Canvas canvas;
    private final UserCommandLineInterface ucli;
    private final ArrayList<Pizza> pizzaArray;
    boolean keepOrdering = true;
    private int toppingOne = 0;
    private int toppingTwo = 0;
    private int method;

    /**
     * Constructor for the ordering system.
     */
    public OrderingSystem() {
        canvas = new Canvas("Pizza Ordering", 900, 650);
        ucli = new UserCommandLineInterface();
        pizzaArray = new ArrayList<>();
    }

    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen() {
        //Covers old texts
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillRectangle(0, 0, 900, 600);
        canvas.fillRectangle(0, 600, 800, 300);
        canvas.setForegroundColor(Color.BLACK);
        // vertical dividers
        canvas.drawLine(300, 0, 300, 600);
        canvas.drawLine(600, 0, 600, 600);
        // halfway divider
        canvas.drawLine(0, 300, 900, 300);
        // total price line
        canvas.drawLine(0, 600, 900, 600);
        canvas.setFontSize(25);
        double totalCost = calculateTotalCost();
        String currentCost = String.format("%.2f", totalCost);
        canvas.drawString("Total Price of the Order: £" + currentCost, 10, 640);
    }

    /**
     * Method to start ordering a pizza.
     */
    public void startOrdering() {
        //I want to get all the info for a pizza then add it to a pizza.
        //Finally we are going to display the arrayList
        System.out.println("--------------------------------------------------"
                + "------------");
        System.out.printf("\t    %s", "WELCOME TO PIZZA KING\n");
        System.out.println("\t-----------------------------");
        System.out.println("\t\t* * * * * * *.");
        System.out.println("\t\t *  o  %  o *");
        System.out.println("\t\t  * %  o % *");
        System.out.println("\t\t   *  o o *");
        System.out.println("\t\t    *  % *");
        System.out.println("\t\t     *  *");
        System.out.println("\t\t      **");
        System.out.println("\t       ---------------------");
        System.out.println(" \t\tLets Start Ordering   ");
        System.out.println(" \t       ---------------------");
        System.out.println("___________________________________________________"
                + "___________");
        addPizza();
        displayPizzaArray();
        manageOrders();
        displayPizzaArray();
        finishOrdering();
    }

    /**
     * Method to manage the ordering of the pizzas.
     */
    public void manageOrders() {
        System.out.println("___________________________________________________"
                + "___________");
        System.out.println("\t\t\tMain Menu");
        System.out.println(" \t\t      -------------");
        System.out.printf("\t%-25s%-25s\n", "1:Add a pizza", "2:Remove a pizza");
        System.out.printf("\t\t      %s\n", "3:Stop Ordering");
        System.out.println("---------------------------------------------------"
                + "-----------");
        System.out.printf("\tSelected Option: ");
        method = ucli.checkInputs(1, 3, "the next methods");
        System.out.println("___________________________________________________"
                + "___________");

        while (method != 3) {
            if (method == 2 && pizzaArray.size() > 0) {
                System.out.println("\tWhat pizza would you like to remove?");
                System.out.printf("\tSelected Option: ");
                int removePizza = ucli.checkInputs(1, pizzaArray.size(),
                        "the pizza you would like to remove");
                pizzaArray.remove(removePizza - 1);
                //Go inside each pizza and change the position
                for (int i = 0; i < pizzaArray.size(); i++) {
                    pizzaArray.get(i).setPizzaPosition(i + 1);
                }
            } else {
                if (pizzaArray.size()<30){
                    addPizza();            
                }
                else {
                    return;
                }
            }
            displayPizzaArray();
            manageOrders();
        }
    }

    /**
     * Method to display the order has finished
     */
    public void finishOrdering() {
        if (pizzaArray.size() >= 30) {
            System.out.println("-------------------------------------------"
                    + "-------------------");
            System.out.println("\tYou have reach the maximum number of pizzas");
            System.out.println("-------------------------------------------"
                    + "-------------------");
        }
        System.out.println("___________________________________________________"
                + "___________");
        System.out.println("\t\tThanks for Ordering");
        System.out.println("___________________________________________________"
                + "___________");
    }

    /**
     * Method to add a pizza to the array list of pizzas.
     */
    public void addPizza() {
        int pizzaPosition = pizzaArray.size() + 1;
        int pizzaSize = ucli.pizzaSize();
        int pizzaBase = ucli.pizzaBase() + 3;
        int pizzaSauce = ucli.pizzaSauce() + 6;
        int numOfToppings = ucli.numOfToppings();
        if (numOfToppings == 1) {
            toppingOne = ucli.toppings() + 8;
        } else if (numOfToppings == 2) {
            toppingOne = ucli.toppings() + 8;
            toppingTwo = ucli.toppings() + 8;
        }
        Pizza pizza = new Pizza(canvas, pizzaPosition, pizzaSize, pizzaBase,
                pizzaSauce, toppingOne, toppingTwo, numOfToppings);
        pizzaArray.add(pizza);
    }

    /**
     * Method to display the pizzas
     */
    public void displayPizzaArray() {
        drawOrderScreen();
        if (pizzaArray.size() > 0 && pizzaArray.size() <= 6) {
            for (int i = 0; i < pizzaArray.size(); i++) {
                pizzaArray.get(i).displayPizza();
            }
        } else if (pizzaArray.size() > 6 && pizzaArray.size() <= 12) {
            for (int i = 0; i < pizzaArray.size() - 6; i++) {
                pizzaArray.get(i + 6).displayPizza();
            }
        } else if (pizzaArray.size() > 12 && pizzaArray.size() <= 18) {
            for (int i = 0; i < pizzaArray.size() - 12; i++) {
                pizzaArray.get(i + 12).displayPizza();
            }
        } else if (pizzaArray.size() > 18 && pizzaArray.size() <= 24) {
            for (int i = 0; i < pizzaArray.size() - 18; i++) {
                pizzaArray.get(i + 18).displayPizza();
            }
        } else if (pizzaArray.size() > 24 && pizzaArray.size() <= 30) {
            for (int i = 0; i < pizzaArray.size() - 24; i++) {
                pizzaArray.get(i + 24).displayPizza();
            }
        }
    }

    /**
     * Method to calculate the cost of pizzas.
     * @return the total cost
     */
    public double calculateTotalCost() {
        double cost;
        double totalCost = 0;
        ArrayList<Double> listOfCost = new ArrayList<>();
        for (int i = 0; i < pizzaArray.size(); i++) {
            cost = pizzaArray.get(i).getTotalCost();
            listOfCost.add(cost);
        }
        for (int x = 0; x < pizzaArray.size(); x++) {
            totalCost += listOfCost.get(x);
        }
        return totalCost;
    }

}
