package all;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

import all.entities.Department;
import all.entities.HourContract;
import all.entities.Worker;
import all.entities.enums.WorkerLevel;

public class App {

    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(
            workerName,
            WorkerLevel.valueOf(workerLevel), 
            baseSalary,
            new Department(departmentName));

            System.out.println("how many contract to this Worker? ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter contract " + i + " data: ");
                System.out.print("Date (DD/MM/YYYY): ");
                Date contractDate = sdf.parse(sc.next());
                System.out.print("Value per hour: ");
                double valuePerHour = sc.nextDouble();
                System.out.print("Duration (hours): ");
                int hours = sc.nextInt();
                HourContract contract = new HourContract(
                    contractDate, 
                    valuePerHour, 
                    hours);
                    worker.addContract(contract);
            }

            System.out.println();

            System.out.println("Enter month and year to calculate income (MM/YYYY)");
            String monthAndYear = sc.next();
            int month = Integer.parseInt(monthAndYear.substring(0,2));
            int year = Integer.parseInt(monthAndYear.substring(3));
            System.out.println("Name: " + worker.getName());
            System.out.println("Department: " + worker.getDepartment().getName());
            System.err.println("incoming for: " + monthAndYear + " " + String.format("%.2f", worker.income(year, month)));

    }

    
  
}
