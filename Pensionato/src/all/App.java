package all;

import java.util.Locale;
import java.util.Scanner;

import all.entities.Aluguel;
import all.services.pencionatoService;

public class App {

    public static void main(String[] args) {

        pencionatoService service = new pencionatoService();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o numero de estudandes: ");
        int nEstudantes = sc.nextInt();
        Aluguel[] aluguel = new Aluguel[10];
        sc.nextLine();
        service.atomicCreateWithRead(nEstudantes);

        service.allRegistre();        
        sc.close();
    
    }
  
}
