package all.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import all.entities.enums.OrderStatus;

public class Order {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Date momment, OrderStatus status, Client client) {
        this.momment = momment;
        this.status = status;
        this.client = client;
    }

    public Order() {
    }

    public Date getMomment() {
        return momment;
    }

    public void setMomment(Date momment) {
        this.momment = momment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    } 

    public void addOrderItem(OrderItem ordermItem){
        orderItems.add(ordermItem);
    }

    public void removeOrderItem(OrderItem ordermItem){
        orderItems.remove(ordermItem);
    }
    
    public Double total(){
        Double total = 0.0;

        for (OrderItem oI: orderItems) {
            total += oI.subTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("momment: " + sdf.format(momment) + "\n");
        sb.append("Status: " + OrderStatus.PROCESSING + "\n");
        sb.append(client + "\n");
        for (OrderItem orderItem : orderItems) {
            sb.append(orderItem.getProduct().getName() + ", ");
            sb.append("Quantity: " + orderItem.getQuantity() + ", ");
            sb.append("Subtotal: " + orderItem.subTotal() + "\n");
        }
        

        return sb.toString();
    }

    
    

    
}
