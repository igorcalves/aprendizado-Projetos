package all;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import all.entities.Client;
import all.entities.Order;
import all.entities.OrderItem;
import all.entities.Product;
import all.entities.enums.OrderStatus;


public class App {

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Client client = new Client("Igor", "Igor193@live.com", sdf.parse("26/12/1997 00:00:00"));
        Product product_1 =  new Product("Raul em tamanho real", 300.0);
        Product product_2 =  new Product("Raul em tamanho miniatura", 150.0);
        Product product_3 =  new Product("Raul em tamanho de colecionador", 450.0);
        OrderItem orderItem_1 = new OrderItem(3, product_1);        
        OrderItem orderItem_2 = new OrderItem(1, product_2);        
        OrderItem orderItem_3 = new OrderItem(4, product_3);

        Order order = new Order(new Date(), OrderStatus.PROCESSING, client);
        order.addOrderItem(orderItem_1);        
        order.addOrderItem(orderItem_2);
        order.addOrderItem(orderItem_3);
   
        System.out.println(order);

   
    }
  
}
