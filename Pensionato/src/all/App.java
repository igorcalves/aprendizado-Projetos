package all;


import all.entities.LegalPerson;
import all.entities.NaturalPerson;
import all.entities.TaxPayer;



public class App {

    public static void main(String[] args) {

        TaxPayer np = new LegalPerson("Igor", 400000.0, 1);

        System.out.println(String.format("%.2f", np.tax()));


  
}
}