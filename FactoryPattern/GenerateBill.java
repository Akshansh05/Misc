package FactoryPattern;

public class GenerateBill {
    public static void main(String[] args) {

        PlanFactory planFactory = new PlanFactory();

        Plan plan = planFactory.getPlan(PlanType.COMMERCIAL_PLAN);
        int unit = 5;

        System.out.println("Rate: " + plan.price());
        System.out.println("Unit: " + unit);
        System.out.println("Bill Amount: " + plan.calculateBill(unit));
    }
}
