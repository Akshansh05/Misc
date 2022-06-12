package FactoryPattern;

public class DomesticPlan extends Plan {
    @Override
    int price() {
        this.price = 3;
        return price;
    }
}
