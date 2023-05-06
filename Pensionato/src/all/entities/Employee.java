package all.entities;

public class Employee {

    private int id;

    private String name;

    private Double wage;

    public Employee(int id, String name, Double wage) {
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWage() {
        return wage;
    }

    public Double increaseWage(double percentIncreaseWage){
        Double value = this.getWage() * ((percentIncreaseWage / 100)+1);
        return value;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", wage=" + wage + "]";
    }

    


    
    
}
