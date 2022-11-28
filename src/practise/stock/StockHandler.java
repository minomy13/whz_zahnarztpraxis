package practise.stock;

import practise.Practise;

import java.util.ArrayList;

enum Item {
    BEAKER,
    COTTON_PAD
}

public class StockHandler {
    private Practise practise;
    private ArrayList<StockItem> stock;

    public StockHandler(Practise practise) {
        this.practise = practise;
        this.stock = new ArrayList<>();
    }

    public int getStock(Item item) throws Exception {
        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                return i.getStock();
            }
        }
        throw new Exception("Item not in assortment");
    }

    public void buy(Item item, int amount, double pricePerPiece) {
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

    public void take(Item item, int amount) throws Exception {
        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                if (i.getStock() - amount < 0) throw new Exception("Not enough of this item in stock");
                i.decreaseStock(amount);
                return;
            }
        }
        throw new Exception("Item not in assortment");
    }

    private void lowLevelCheck(Item item) {
        // TODO
    }
}
