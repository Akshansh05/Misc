package FactoryPattern;

public abstract class Plan {
    public int price;

    abstract int price();

    public int calculateBill(int unit) {
        return (unit * price);
    }
}
