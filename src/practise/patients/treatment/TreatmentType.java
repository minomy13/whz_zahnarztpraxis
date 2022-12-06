package practise.patients.treatment;

import practise.stock.Item;

import java.util.HashMap;

public class TreatmentType {
    final String name;
    final double cost;
    private HashMap<Item, Integer> needs;

    public TreatmentType(String name, double cost, HashMap<Item, Integer> needs) {
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

    public HashMap<Item, Integer> getNeeds() {
        return needs;
    }
}
