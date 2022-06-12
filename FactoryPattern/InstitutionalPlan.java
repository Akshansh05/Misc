package FactoryPattern;

public class InstitutionalPlan extends Plan {
    @Override
    int price() {
        this.price = 5;
        return price;
    }
}
