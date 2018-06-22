package pizzaorderingsystemnetbeans;

/**
 * Enum that holds the different choices for a pizza.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public enum Choices {
    empty(0, 0.0),
    small(10, 0.0),//10 inches diameter
    medium(12, 0.0),//12 inches diameter
    large(14, 0.0),//14 inches diameter
    deep(0, 0.11),
    thin(0, 0.08),
    stuffed(0, 0.14),
    tomato(0, 0.0),
    bbq(0, 0.5),
    pepperoni(0, 0.04),
    pineapple(0, 0.06);
    //declare the instance variable
    private final int diameter;
    private final double cost;

    /**
     * Enum constructor
     *
     * @param diameter the diameter of the chosen pizza size
     * @param cost the cost of the choice
     */
    Choices(int diameter, double cost) {
        this.diameter = diameter;
        this.cost = cost;
    }

    /**
     * Method to get the diameter of the chosen pizza size
     *
     * @return the diameter of the chosen pizza size
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Method to get the cost of the chosen pizza choices
     *
     * @return the cost of the chosen pizza choice
     */
    public double getCost() {
        return cost;
    }

    /**
     * Method to return the name of the choices as a string Enum Overrides
     * method
     *
     * @return a string containing the name of the choice
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
