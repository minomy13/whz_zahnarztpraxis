package practise.treatment;

public class Treatment {
    final String name;
    final double cost;

    public Treatment(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
