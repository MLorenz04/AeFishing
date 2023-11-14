package aemmo.aefishing.Items.Chests;


public class Stats {
    private int min_amount;

    private int max_amount;
    private double chance;

    public Stats(int min_amount, int max_amount, double chance) {

        this.min_amount = min_amount;
        this.max_amount = max_amount;
        this.chance = chance;
    }

    public int getMinAmount() {
        return this.min_amount;
    }

    public int getMaxAmount() {
        return this.max_amount;
    }

    public double getChance() {
        return this.chance;
    }

}
