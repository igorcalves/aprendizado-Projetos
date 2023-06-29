package all.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import all.entities.LegalPerson;
import all.entities.NaturalPerson;
import all.entities.TaxPayer;

public class dataInputProduct {

    private final String naturalPerson = "n";
    private final String legalPerson = "l";

    private String tag;
    private String name;
    private Double price;
    private Double healthExpenditures;
    private Integer numberOfEmployees;
    private TaxPayer tp;
    private List<TaxPayer> taxs = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void atomicCreateWithRead() {
        insertAPerson();
        allRegistre();

    }

    private void insertAPerson() {
        int qtd = howManyTaxPayer();

        for (int i = 1; i <= qtd; i++) {
            System.out.println("tax payer data # " + i);
            validTag();
            taxs.add(createAPerson());
        }
    }

    private TaxPayer createAPerson() {
        String message = "Annual Income: ";
        name = writeName();
        price = writeDoubleValue(message);
        if (tag.equalsIgnoreCase(naturalPerson) ) {
             tp = (NaturalPerson) createANaturalPerson();
        } else if (tag.equalsIgnoreCase(legalPerson)) {
             tp = (LegalPerson) createALegalPerson();
        }
        return tp;
    }

    private TaxPayer createANaturalPerson() {
        String message = "Health Expenditures: ";
        healthExpenditures = writeDoubleValue(message);
        TaxPayer tax = new NaturalPerson(name, price, healthExpenditures);
        return tax;
    }

    private TaxPayer createALegalPerson() {
        String message = "Number of employees: ";
        String errorMessage = "Invalid Value try again: ";
        numberOfEmployees = writeIntegerValue(message, errorMessage);
        TaxPayer tax = new LegalPerson(name, price, numberOfEmployees);
        return tax;
    }

    private void validTag() {
        while (true) {
            System.out.print("Switch\nNatural Person == N\nLegal Person == L\nValue: ");
            tag = sc.nextLine();
            if (validations.tagValidation(tag))
                break;
            else
                System.out.println("Invalid character try again");
        }
    }

    public int howManyTaxPayer() {
        String message = "Enter the number of tax payer: ";
        String errorMessage = "!!!Invalid Number!!!\nTry again!!!!\nRules:\n1° Only numbers\n2° Can't be a letter\n3° Can't be a null value\n value: ";
        Integer quantityItems = writeIntegerValue(message, errorMessage);
        return quantityItems;
    }

    private Integer writeIntegerValue(String message, String errorMessage) {
        while (true) {
            String value = "";
            System.out.print(message);
            value = sc.nextLine();
            if (validations.IsValidNumeric(value)) {
                return Integer.parseInt(value);
            } else {
                System.out.print(errorMessage);
            }
        }

    }


    private Double writeDoubleValue(String message) {
        String price = "";
        while (true) {
            System.out.print(message);
            price = sc.nextLine();
            if (validations.isValidDoubleNumeric(price)) {
                break;
            }
            System.out.println("Invalid Value!!!!");
        }
        return Double.parseDouble(price);
    }

    private String writeName() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        while (!validations.isNameValid(name)) {
            System.out.print("Invalid name try again !!!!\nName: ");
            name = sc.nextLine();
        }
        return name;
    }

    private void allRegistre() {
        for (int i = 0; i < 5 ;i++) {
                System.out.println();
            }
        for (TaxPayer tax : taxs) {
            System.out.println(tax.print());
        }
    }
}
