package all.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

    private LocalDate manufactureDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public final String priceTag() {
        return name +" (Used) " + " $ " + price + " (Manufacture date: " + manufactureDate.format(formatter) + ")";  
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }


    
}
