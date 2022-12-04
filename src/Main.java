import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;
import utils.tuple.Tuple;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000);

        ArrayList<Tuple<Item, Integer>> a = new ArrayList<>();
        a.add(new Tuple(Item.COTTON_PAD, 3));
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