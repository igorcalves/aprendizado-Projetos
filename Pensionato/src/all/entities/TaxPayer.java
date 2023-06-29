package all.entities;



public abstract class TaxPayer {

    protected String name;
    protected Double annualIncome;

    public TaxPayer() {
    }

    public TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public abstract Double tax();
    
    public String print(){
        return "name: " + name +"\nAnnual income: " + annualIncome ;
    }

}
