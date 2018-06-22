package pizzaorderingsystemnetbeans;

/**
 * Class to prompt and get the users inputs.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class UserCommandLineInterface {

    private final KeyboardInput userInput;

    /**
     * Constructor for the UserCommandLineInterface class
     */
    public UserCommandLineInterface() {
        userInput = new KeyboardInput();
    }

    /**
     * method to get the pizza size the user wants.
     *
     * @return an integer representation of the user choice for the pizza size.
     */
    public int pizzaSize() {
        System.out.println("\tWhat type of pizza size would you like?");
        System.out.printf("\t1:%-10s 2:%-10s 3:%-10s\n", "Small", "Medium", "Large");
        System.out.printf("\tSelected Option: ");
        return checkInputs(1, 3, "a pizza size");
    }

    /**
     * method to get the pizza crust the user wants.
     *
     * @return an integer representation of the user choice for the pizza crust.
     */
    public int pizzaBase() {
        System.out.println("\tWhat type of pizza crust would you like?");
        System.out.printf("\t1:%-15s 2:%-15s 3:%-15s\n", "Deep Pan", "Thin Crust", "Stuffed Crust");
        System.out.printf("\tSelected Option: ");
        return checkInputs(1, 3, "a pizza base");
    }

    /**
     * method to get the pizza sauce the user wants.
     *
     * @return an integer representation of the user choice for the pizza sauce
     */
    public int pizzaSauce() {
        System.out.println("\tWhat type of pizza sauce would you like?");
        System.out.printf("\t1:%-10s 2:%-10s\n", "Tomato", "BBQ");
        System.out.printf("\tSelected Option: ");
        return checkInputs(1, 2, "a pizza sauce");
    }

    /**
     * method to get the number of toppings the user wants.
     *
     * @return an integer that represents the number of toppings the user wants.
     */
    public int numOfToppings() {
        System.out.println("\tHow many toppings would you like?");
        System.out.printf("\t0:%-15s 1:%-15s 2:%-15s\n", "No Toppings", "One Topping", "Two toppings");
        System.out.printf("\tSelected Option: ");
        return checkInputs(0, 2, "the number of toppings");
    }

    /**
     * method to get the pizza sauce the user wants.
     *
     * @return an integer representation of the user choice for the pizza sauce
     */
    public int toppings() {
        System.out.println("\tWhat type of pizza topping would you like?");
        System.out.printf("\t1:%-10s 2:%-10s\n", "Pepperoni", "Pineapple");
        System.out.printf("\tSelected Option: ");
        return checkInputs(1, 2, "the pizza topping");
    }

    /**
     * method to get the user inputs, which will keep asking the user until the
     * correct inputs are inputted.
     *
     * @param minChoice the minimum value that the user can choose
     * @param numOfChoices the number of choices the user can choose from .
     * @param object a string value which states what the user is choosing from.
     * @return an integer that represents of the user choice.
     */
    public int checkInputs(int minChoice, int numOfChoices, String object) {
        while (true) {
            int inputValue = userInput.getInputInteger();
            if (inputValue >= minChoice && inputValue <= numOfChoices) {
                System.out.println();
                return inputValue;
            }
            System.out.println();
            System.out.println("\tEnter a number from " + minChoice
                    + " to " + numOfChoices + " to choose " + object);
            System.out.printf("\tSelected Option: ");
        }
    }

}
