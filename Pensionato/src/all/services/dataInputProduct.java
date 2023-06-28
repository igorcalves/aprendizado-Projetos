package all.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import all.entities.ImportedProduct;
import all.entities.Product;
import all.entities.UsedProduct;

public class dataInputProduct {

    private final String common = "c";
    private final String used = "u";
    private final String imported = "i";


    private String tag;
    private String name;
    private Double price;

    private List<Product> products = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public void atomicCreateWithRead() {
        insertProductsInAList();
        allRegistre();

    }

    private void insertProductsInAList(){
        int qtd = howManyProducts();

        for (int i = 1; i <= qtd; i++) {
            System.out.println("Product data # " + i );
            validTag();
            products.add(createAProduct());
        }
    }




    private Product createAProduct(){
        Product p = new Product();
        name = writeName();
        price = writeDoubleValue();
        if(tag.equalsIgnoreCase(common)){
            p = new Product(name, price);
        }else if(tag.equalsIgnoreCase(used)){
            System.out.print("Manufacture date: ");
            LocalDate manufacturDate = writeDate();
            p = new UsedProduct(name, price, manufacturDate);
        }else if (tag.equalsIgnoreCase(imported)){
            System.out.print("Custom fee: ");
            Double customfee = writeDoubleValue();
            p = new ImportedProduct(name, price, customfee);
        }
        return p;

    }



    private void validTag(){
         while(true){
            System.out.print("Common, used or imported (c/u/i): ");
            tag = sc.nextLine();
            if(validations.tagValidation(tag)) break;
            else System.out.println("Invalid character try again");
         }
    }

   public int howManyProducts(){
        System.out.println("how many items do you want to enter: ");
        String errorMessage = "!!!Invalid Number!!!\nTry again!!!!\nRules:\n1° Only numbers\n2° Can't be a letter\n3° Can't be a null value\n value: ";
        Integer quantityItems = writeIntegerValue(errorMessage);
        return quantityItems;
    }

    private Integer writeIntegerValue(String errorMessage){
        System.out.print("Value: ");
        String value = sc.nextLine();
        while(true){
            if(validations.IsValidNumeric(value)){
            break;
            }
            if(errorMessage == null){
                System.out.println("Invalid Value!!!!\nValue: ");
            }else{
                System.out.print(errorMessage);
            }
            value = sc.nextLine();
        }

        return Integer.parseInt(value);
    }

    private LocalDate writeDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("manufacture date model [dd/MM/yyyy]: ");
        String date = sc.nextLine();
        while(!validations.isValidDate(date)){
            System.out.print("invalid date try again!!!!\nBirthday model [dd/MM/yyyy]: ");
            date = sc.nextLine();
        }

        LocalDate ldate = LocalDate.parse(date,formatter);
        return ldate;
    }

    private Double writeDoubleValue(){
        String price = "";
        while(true){
            System.out.print("Product Price: ");
            price = sc.nextLine();
            if(validations.isValidDoubleNumeric(price)){
            break;
            }
            System.out.println("Invalid Value!!!!");
        }

        return Double.parseDouble(price);
    }

    private String writeName(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        while(!validations.isNameValid(name)){
            System.out.print("Invalid name try again !!!!\nName: ");
            name = sc.nextLine();
        }
        return name;
    }
    
    public void allRegistre(){
        for (Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}
