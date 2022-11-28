package practise.stock;

import java.util.ArrayList;
import java.util.stream.Collectors;

enum Item {
    BEAKER,
    COTTON_PAD
}

public class StockHandler {
    private ArrayList<StockItem> stock;

    public void buy(Item item, int amount, double pricePerPiece) {
        if (stock.stream().filter(o -> o.getItem().equals(item)).collect(Collectors.toList()).size() > 0) {

        }

    }
}
