package practise.patients.treatment;

import practise.stock.Item;
import utils.touple.Touple;

import java.util.ArrayList;

public class Treatment {
    final String name;
    final double cost;
    private ArrayList<Touple<Item, Integer>> needs;

    public Treatment(String name, double cost, ArrayList<Touple<Item, Integer>> needs) {
        this.name = name;
        this.cost = cost;
        this.needs = needs;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public ArrayList<Touple<Item, Integer>> getNeeds() {
        return needs;
    }
}
