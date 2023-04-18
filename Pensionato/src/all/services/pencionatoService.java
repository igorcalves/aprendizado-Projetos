package all.services;

import java.util.Scanner;

import all.entities.Rent;

public class pencionatoService {
     Scanner sc = new Scanner(System.in);
     private Rent[] rents = new Rent[10];
    
    public int studantDataInput(){
        System.out.print("Digite o numero de estudandes: ");
        String nEstudantes = sc.nextLine();
        int numericFomarmated = 0;

        if(validations.IsValidNumeric(nEstudantes) && validations.rangeNumeric(nEstudantes)){
            numericFomarmated = Integer.parseInt(nEstudantes);
        }
        else{
                System.out.println("!!!Numero invalido!!!\nTente Novamente!!!!\nRegras:\n1° Numero entre 0 e 1\n2° Não pode ser letran\n3° O valor Não pode ser vazio");
                atomicCreateWithRead();    
        }
        return numericFomarmated;
    }

    public void atomicCreateWithRead(){
        String name = "";
        String email = "";
        int room = 0;
        int iterator = studantDataInput();
        for (int i = 0; i < iterator; i++) {
            System.out.println("Estudante Nº : " + (i+1));
            name = writeName();
            email = writeEmail();
            room = writeRoom();
            Rent newRent = new Rent(name, email, room);
            allocateRoom(room, newRent);
        }
        
        sc.close();
    }

    private String writeName(){
        System.out.print("Digite o nome do Estudante: ");
        String name = sc.nextLine();
        while(!validations.isNameValid(name)){
            System.out.print("Nome Invalido Digite novamente !!!!\nDigite o nome do Estudante: ");
            name = sc.nextLine();
        }
        return name;
    }

    private String writeEmail(){
        System.out.print("Digite o Email do Estudante: ");
        String email = sc.nextLine();
        while(!validations.isValidEmail(email)){
            System.out.print("Email Invalido Digite novamente !!!!\nDigite o Email do Estudante: ");
            email = sc.nextLine();
        }
        return email;
    }

    private int writeRoom(){
        System.out.print("Digite o quarto do Estudante: ");
        String room = sc.nextLine();
        while(true){
            if(validations.IsValidNumeric(room) && validations.rangeNumeric(room)){
            break;
            }
            System.out.print("Quarto Invalido Digite novamente !!!!\nDigite o Quarto do Estudante: ");
            room = sc.nextLine();
        }

        return Integer.parseInt(room);
    }

    public void allocateRoom(int room, Rent newRent){
        while(!validations.emptyRoom(rents, room)){
            System.out.println("O quarto " + room + " esta ocupado tente novamente!\n");
            room = writeRoom();
        }
        rents[room] = newRent;
    }


    
    public void allRegistre(){
        for (int i = 0; i < rents.length; i++) {
            if(rents[i] != null){
                System.out.println(rents[i]);
            }
        }
        
        
    }   
}
