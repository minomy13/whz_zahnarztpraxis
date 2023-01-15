package practise.patients.treatment;

import practise.stock.Item;

import java.util.Map;

public class TreatmentType {
    final String name;
    final double cost;
    private final Map<Item, Integer> needs;

    public TreatmentType(String name, double cost, Map<Item, Integer> needs) {
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

    public Map<Item, Integer> getNeeds() {
        return needs;
    }
}
