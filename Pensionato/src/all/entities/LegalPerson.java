package all.entities;

public class LegalPerson extends TaxPayer{

    protected Integer numberOfEmployees;

    public LegalPerson(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }


    @Override
    public Double tax() {
        Double tax;
        if(numberOfEmployees > 10){
            tax = annualIncome * 0.14;
        }else{
            tax = annualIncome * 0.16;
        }
        return tax;
    }


    @Override
    public String print() {
        return super.print() + "\nLegal Person\nNumber of Employees: " + numberOfEmployees + "\nTax = " + String.format("%.2f",tax()) + "\n";
    }

    

    


    
}
