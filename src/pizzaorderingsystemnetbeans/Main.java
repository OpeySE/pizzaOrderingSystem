package pizzaorderingsystemnetbeans;

/**
 * Class to start running the Pizza Ordering System.
 *
 * @author OpeySE
 * @version 2018.06.21
 */
public class Main {

    public static void main(String[] args) {
        OrderingSystem orders = new OrderingSystem();
        orders.drawOrderScreen();
        orders.startOrdering();
    }

}
