package all;


import java.util.ArrayList;
import java.util.List;

import all.entities.Employee;
import all.services.EmployeeService;
import all.services.pencionatoService;

public class App {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        service.atomicCreateWithRead();
        service.allRegistre();    
    }
  
}
