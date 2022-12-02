package practise.patients.treatment;

import practise.Practise;
import practise.stock.Item;
import utils.touple.Touple;

import java.util.ArrayList;

public class Treatment {
    final String name;
    final double cost;

    public Treatment(String name, double cost, ArrayList<Touple<Item, Integer>> needs, Practise practise) throws Exception {
        this.name = name;
        this.cost = cost;

        for (Touple<Item, Integer> i : needs) {
            practise.getStockHandler().take(i.t1, i.t2);
        }
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
