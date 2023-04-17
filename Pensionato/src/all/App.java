package all;


import all.services.pencionatoService;

public class App {

    public static void main(String[] args) {

        pencionatoService service = new pencionatoService();

        service.atomicCreateWithRead();

        service.allRegistre();        
    
    }
  
}
