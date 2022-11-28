package practise.stock;

class StockItem {
    private Item item;
    private double stock;

    public StockItem(Item item, double stock) {
        this.item = item;
        this.stock = stock;
    }

    public Item getItem() {
        return item;
    }

    public double getStock() {
        return stock;
    }

    public void increaseStock(double amount) {
        this.stock += amount;
    }

    public void decreaseStock(double amount) throws Exception {
        if (stock - amount < 0) throw new Exception("Stock must not be smaller than 0");
        this.stock -= amount;
    }
}
