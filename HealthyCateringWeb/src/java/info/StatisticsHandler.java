package info;

import database.DatabaseHandler;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author colsen91
 */
@ApplicationScoped
public class StatisticsHandler {

    private ArrayList<Order> allorders;
    @Inject
    DatabaseHandler dbhandler;

    public StatisticsHandler() {
        this.allorders = new ArrayList<Order>();
    }

    public double getTotalPriceAllOrders() {
        double total = 0;
        for (Order order : allorders) {
            total += order.getPrice();
        }
        return total;
    }

    public int getNumOfOrders() {
        allorders = dbhandler.selectOrders();
        return allorders.size();
    }

    public double getHighestOrder() {
        allorders = dbhandler.selectOrders();
        double currentHigh = 0;
        for (Order o : allorders) {
            if(o.getPrice() > currentHigh){
                currentHigh = o.getPrice();
            }
        }
        
        return currentHigh;
    }
    
    public double getLowestOrder() {
        allorders = dbhandler.selectOrders();
        double currentLow = 0;
        for (Order o : allorders) {
            if(o.getPrice() < currentLow){
                currentLow = o.getPrice();
            }
        }
        
        return currentLow;
    }
}