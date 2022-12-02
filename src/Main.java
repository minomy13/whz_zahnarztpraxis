import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;
import utils.touple.Touple;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000);

        ArrayList<Touple<Item, Integer>> a = new ArrayList<>();
        a.add(new Touple(Item.COTTON_PAD, 3));
        logger.info(practise.getBudget());

        practise.getStockHandler().buy(Item.COTTON_PAD, 15, .36);

        practise.getPatientHandler().getPatientFileHandler().create("Bob");
        practise.getPatientHandler().startTreatment("A", 360.90, a);

        try {
            logger.info(practise.getStockHandler().getStock(Item.COTTON_PAD));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(practise.getBudget());
    }
}