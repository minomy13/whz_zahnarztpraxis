import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.HashMap;
import practise.*;
public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000,5,0,1 ,8,00);

        practise.getEmployeeHandler().hireEmployee("Karl", "Dentist");
        // TODO employee timestamp/ comeandgo
        practise.getPatientHandler().getPatientFileHandler().create("Bob");
        //TODO create more Patients & their Reports

        HashMap<Item, Integer> n = new HashMap<>();
        n.put(Item.COTTON_PAD, 15);
        logger.info(practise.getBudget());

        practise.getStockHandler().buy(Item.COTTON_PAD, 15, .36);
        //TODO enter more items

        try {
            logger.info(practise.getStockHandler().getStock(Item.COTTON_PAD));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info(practise.getBudget());
        System.out.println(practise.getCalendar().getTime());


    }
}