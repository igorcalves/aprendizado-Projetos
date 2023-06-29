package all.entities;

public class NaturalPerson extends TaxPayer{

    private Double healthExpenditures;

    
    public NaturalPerson(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;

    }




    @Override
    public  Double tax() {
        Double tax;
        if (super.annualIncome < 20000.0){
            tax = 20000.0 * 0.15;
        }else {
            tax = 20000.0 *0.25;
        }
        if(healthExpenditures >0){
            tax = (annualIncome * 0.25) - (healthExpenditures * 0.50);
        }
        return tax;
    }




    @Override
    public String print() {
        return super.print() + "\nNatural Person\nHealth Expenditures: " + healthExpenditures + "\ntax = " + String.format("%.2f",tax())+ "\n";
    }

    


    

    
}
