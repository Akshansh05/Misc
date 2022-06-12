package FactoryPattern;

public class CommercialPlan extends Plan {
    @Override
    int price() {
        this.price = 7;
        return price;
    }
}
