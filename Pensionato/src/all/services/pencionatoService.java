package all.services;

import java.util.Scanner;

import all.entities.Aluguel;

public class pencionatoService {

         Aluguel[] aluguel = new Aluguel[10];
         Aluguel a;
    
    public void atomicCreateWithRead(int iterator){
        Scanner sc = new Scanner(System.in);
        String name = "";
        String email = "";
        int room = 0;
        for (int i = 0; i < iterator; i++) {
            System.out.println("Estudante Nº : " + (i+1));
            System.out.print("Digite o nome do Estudante: ");
            name = sc.nextLine();
            System.out.print("Digite o email do Estudante: ");
            email = sc.nextLine();
            System.out.print("Digite o quarto do Estudante: ");
            room = sc.nextInt();
            sc.nextLine();

             a = new Aluguel(name, email, room);
            aluguel[room] = a;
        }
        sc.close();
    }



    public void allRegistre(){
            for (int i = 0; i < aluguel.length; i++) {
                if(aluguel[i] != null){
                    System.out.println(aluguel[i]);
                }
            }
    }
    
}
