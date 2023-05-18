package all.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import all.entities.Employee;

public class EmployeeService {
    Scanner sc = new Scanner(System.in);
    List<Employee> list = new ArrayList<>();
    
    public int dataEmployeeInput(){
        System.out.print("Digite a quantidade de de funcionarios para cadastro: ");
        String nEmployee = sc.nextLine();
        int numericFomarmated = 0;

        if(validations.IsValidNumeric(nEmployee)){
            numericFomarmated = Integer.parseInt(nEmployee);
        }
        else{
                System.out.println("!!!Numero invalido!!!\nTente Novamente!!!!\nRegras:\n1° Somente Valores Numericos\n2° Não pode ser letran\n3° O valor Não pode ser vazio");
                atomicCreateWithRead();    
        }
        return numericFomarmated;
    }

    public void atomicCreateWithRead(){
        String name = "";
        int id = 0;
        double wage = 0;
        int iterator = dataEmployeeInput();
        for (int i = 0; i < iterator; i++) {
            System.out.println("Colaborador Nº : " + (i+1));
            id = writeId();
            name = writeName();
            wage = writeWage();

            list.add(new Employee(id, name, wage));
        }
        increaseWage();
        sc.close();
    }

    private double writeWage() {
        System.out.print("Digite o Salario do Colaborador: ");
        String wage = sc.nextLine();
        while(true){
            if(validations.isValidDoubleNumeric(wage)){
            break;
            }
            System.out.print("Valor Invalido Digite novamente !!!!\nDigite o Salario do Colaborador: ");
            wage = sc.nextLine();
        }
        return Double.parseDouble(wage);
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

    private int writeId(){
        System.out.print("Digite o ID do Colaborador: ");
        String id = sc.nextLine();
        while(true){
            if(validations.IsValidNumeric(id)){
                if(validations.listContainsId(list, id)){
                    System.out.print("Id já existe digite  o valor novamente: ");
                     id = sc.nextLine();
                }else break;
            }else{
                System.out.print("ID Invalido Digite novamente !!!!\nDigite o ID do Colaborador: ");
                id = sc.nextLine();
            }
        }
        return Integer.parseInt(id);
    }

    private int writeIdForIncreaseWage(){
        System.out.print("Digite o id Localizar o funcionario: ");
        String id = sc.nextLine();
        while(!validations.IsValidNumeric(id)){
            System.out.println("valor Invalido!!!\ndigite um numero inteiro valido: ");
            id = sc.nextLine();
        }
        return Integer.parseInt(id);
    }

    private int writePercent(){
        System.out.print("Digite a porcentagem: ");
        String Percent = sc.nextLine();

        while(!validations.IsValidNumeric(Percent)){
            System.out.println("Valor invalido!!!\ndigite um numero inteiro valido: ");
            Percent = sc.nextLine();
        }
        return Integer.parseInt(Percent);
       
    }


    private void increaseWage(){
        int id = writeIdForIncreaseWage();
        if(!validations.listContainsId(list, id)) {
            System.out.println("id não existe");
            return;
        }
        int increasePercent = writePercent();
        Employee e = null;

        if(validations.listContainsId(list, id)){
            e = validations.findEmployeeById(list, id);
        }
        if(e == null) return;
        System.out.println("passou");
        e.increaseWage(increasePercent);
        
            
    }
    

    public void allRegistre(){
        for(Employee e: list){
            System.out.println(e);
        }
    }
}
