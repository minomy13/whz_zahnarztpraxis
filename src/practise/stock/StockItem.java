package practise.stock;

class StockItem {
    //TODO documentations
    private Item item;
    private int stock;

    public StockItem(Item item, int stock) {
        this.item = item;
        this.stock = stock;
    }

    public Item getItem() {
        return item;
    }

    public int getStock() {
        return stock;
    }

    public void increaseStock(int amount) {
        this.stock += amount;
    }

    public void decreaseStock(int amount) throws Exception {
        if (stock - amount < 0) throw new Exception("Stock must not be smaller than 0");
        this.stock -= amount;
    }
}
