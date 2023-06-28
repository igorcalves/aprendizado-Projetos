package all.entities;

public class ImportedProduct extends Product {

    private Double fee;

    

    public ImportedProduct(String name, Double price, Double fee) {
        super(name, price);
        this.fee = fee;
    }

    public Double getFee() {
        return fee;
    }

    @Override
    public final String priceTag() {
        return name + " $ " + totalPrice()  + " (Customs fee: $ " + fee + ")";  
    }
    
    private Double totalPrice(){
        return price + fee;
    }
    
    

    


    
}
