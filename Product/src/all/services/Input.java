package all.services;

import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import all.entities.Client;
import all.entities.Order;
import all.entities.OrderItem;
import all.entities.Product;
import all.entities.enums.OrderStatus;

public class Input {

    

    private Client client;
    private Product product;
    private OrderItem orderItem;
    private Order order;



    Scanner sc = new Scanner(System.in);
    
    public void atomicCreateWithRead() {
        dataInputClients();
        order();
        registry();
        
    }

    private void order(){
        System.out.print("Entry with Order Status: ");
        String status = sc.nextLine();
        order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
        int quantityItems = howManyProducts();
        
        for (int i = 0; i < quantityItems; i++) {
            OrderItem o = dataInputOrderItems();
            order.addOrderItem(o);
        }

    }

    public OrderItem dataInputOrderItems(){
        Product productCreated = dataInputProducts();
        System.out.println("Entry with Quantity of product: " + productCreated.getName());
        Integer quantity = writeIntegerValue();
        orderItem = new OrderItem(quantity, product);
        return orderItem;
    }

    private void dataInputClients(){
        System.out.println("Entry with Client Value");
        String name = writeName();
        String email = writeEmail();
        LocalDate date = writeDate();
        client = new Client(name, email,date);
    }
    
    private Product dataInputProducts(){
        System.out.println("Entry with Product Value");
        String productName = writeName();
        Double productPrice = writeDoubleValue();
        product = new Product(productName, productPrice);
        return product;
    }

    public int howManyProducts(){
        System.out.print("how many items do you want to enter: ");
        String quantityItems = sc.nextLine();
        int numberFomarted = 0;

        if(validations.IsValidNumeric(quantityItems)){
            numberFomarted = Integer.parseInt(quantityItems);
        }else{
                System.out.println("!!!Invalid Number!!!\nTry again!!!!\nRules:\n1° Only numbers\n2° Can't be a letter\n3° Can't be a null value");
                howManyProducts(); 
        }
        
        return numberFomarted;
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

    private String writeEmail(){
        System.out.print("Client Email: ");
        String email = sc.nextLine();
        while(!validations.isValidEmail(email)){
            System.out.print("Invalid Email try again !!!!\nClient Email: ");
            email = sc.nextLine();
        }
        return email;
    }

    private LocalDate writeDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Birthday model [dd/MM/yyyy]: ");
        String date = sc.nextLine();
        while(!validations.isValidDate(date)){
            System.out.print("invalid date try again!!!!\nBirthday model [dd/MM/yyyy]: ");
            date = sc.nextLine();
        }

        LocalDate ldate = LocalDate.parse(date,formatter);
        return ldate;
    }

    
    private Double writeDoubleValue(){
        System.out.print("Product Price: ");
        String price = sc.nextLine();
        while(true){
            if(validations.isValidDoubleNumeric(price)){
            break;
            }
            System.out.print("Invalid Value!!!!\nProduct Price: ");
            price = sc.nextLine();
        }

        return Double.parseDouble(price);
    }

    private Integer writeIntegerValue(){
        System.out.print("Value: ");
        String value = sc.nextLine();
        while(true){
            if(validations.IsValidNumeric(value)){
            break;
            }
            System.out.print("Invalid Value!!!!\nValue: ");
            value = sc.nextLine();
        }

        return Integer.parseInt(value);
    }


    private void registry(){
        System.out.println(order);
    }
    
}
