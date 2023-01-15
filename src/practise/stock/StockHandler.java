package practise.stock;

import practise.Practise;
import utils.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockHandler {
    private final Practise practise;
    private final ArrayList<StockItem> stock = new ArrayList<>();
    private final int criticalStockLevel;
    private final int refillAmount;
    private final Map<Item, Double> prices = new HashMap<>();

    public StockHandler(Practise practise, int criticalStockLevel, int refillAmount) {
        this.practise = practise;
        this.criticalStockLevel = criticalStockLevel;
        this.refillAmount = refillAmount;
    }


    /**
     * Gives back amount of specific item.
     *
     * @param item Item of stock
     * @return Amount of item kept in stock
     * @throws Exception if Item was never bought
     */
    public int getStock(Item item) throws Exception {
        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                return i.getStock();
            }
        }
        throw new Exception("Item not in assortment");
    }

    /**
     * Gives back String showing all the items in stock and their amount.
     *
     * @return String with all items and their amount
     * @throws Exception if no items are in stock
     */
    public String getAllStocks() throws Exception {
        StringBuilder buffer = new StringBuilder();
        for (StockItem item : stock) {
            buffer.append(String.format("%s: %s; ", item.getItem().name(), item.getStock()));
        }
        if (buffer.length() == 0) throw new Exception("No items in stock.");
        return buffer.toString();
    }

    /**
     * Increases stock of specific Item. Budget gets less.
     * Also saves price for auto refill.
     *
     * @param item          Item to increase stock for
     * @param amount        Amount to increase
     * @param pricePerPiece Price of a single piece
     */
    public void buy(Item item, int amount, double pricePerPiece) {
        if (prices.containsKey(item)) {
            prices.replace(item, pricePerPiece);
        } else prices.put(item, pricePerPiece);

        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                i.increaseStock(amount);
                practise.decreaseBudget(amount * pricePerPiece);
                return;
            }
        }
        stock.add(new StockItem(item, amount));
        practise.decreaseBudget(amount * pricePerPiece);
    }

    /**
     * Decreases stock of specific item. Checks for low levels and refills when needed.
     *
     * @param item   Item to decrease stock for
     * @param amount Amount to decrease
     * @throws Exception if item was never bought or not enough in stock
     */
    public void take(Item item, int amount) throws Exception {
        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                if (i.getStock() - amount < 0) throw new Exception(String.format("Not enough of \"%s\" in stock",
                        i.getItem().name()));
                i.decreaseStock(amount);
                lowLevelCheck(i);
                return;
            }
        }
        throw new Exception("Item not in assortment");
    }

    /**
     * Checks stock for lov levels and refills automatically.
     *
     * @param item Item to check
     */
    private void lowLevelCheck(StockItem item) {
        if (item.getStock() <= criticalStockLevel) {
            Logger logger = new Logger();
            logger.warning(String.format("Stock level for item %s critical.",
                    item.getItem().name()));
            buy(item.getItem(), refillAmount, prices.get(item.getItem()));
            if (item.getStock() > criticalStockLevel) logger.success("Item refilled.");
        }
    }
}
