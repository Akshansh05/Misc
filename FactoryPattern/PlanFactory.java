package FactoryPattern;

public class PlanFactory {

    public Plan getPlan(PlanType planType) {
        if (planType.equals(PlanType.DOMESTIC_PLAN)) {
            return new DomesticPlan();
        } else if (planType.equals(PlanType.INSTITUTIONAL_PLAN)) {
            return new InstitutionalPlan();
        } else if (planType.equals(PlanType.COMMERCIAL_PLAN)) {
            return new CommercialPlan();
        }
        return null;
    }
}
