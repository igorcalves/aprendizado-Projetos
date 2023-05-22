package all;


import all.services.EmployeeService;

public class App {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        service.atomicCreateWithRead();
        service.allRegistre(); 
    }
  
}
