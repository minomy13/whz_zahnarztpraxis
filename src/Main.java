import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000,5,0);

        HashMap<Item, Integer> n = new HashMap<>();
        n.put(Item.COTTON_PAD, 15);
        logger.info(practise.getBudget());

        practise.getStockHandler().buy(Item.COTTON_PAD, 15, .36);

        practise.getPatientHandler().getPatientFileHandler().create("Bob");

        try {
            logger.info(practise.getStockHandler().getStock(Item.COTTON_PAD));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(practise.getBudget());
    }
}