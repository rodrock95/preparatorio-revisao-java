package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
    public static void main(String[] args) throws ParseException {
        
    	Locale.setDefault(Locale.US);
    	Scanner sc = new Scanner(System.in);
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	System.out.print("Enter department's name: ");
    	String departmentName = sc.next();
    	System.out.println("Enter worker data: ");
    	System.out.print("Name: ");
    	String workerName = sc.next();
    	System.out.print("Level: ");
    	String workerLevel = sc.next();
    	System.out.print("Base salary: ");
    	Double baseSalary = sc.nextDouble();
    	
    	Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
    	
    	System.out.print("How many contracts to this worker? ");
    	int contract = sc.nextInt();
    	
    	for(int i = 1; i <= contract; i++) {
    		System.out.println("Enter contract #" + i + " data");
    		System.out.print("Date (DD/MM/YYYY): ");
    		Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            
            HourContract hourContract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(hourContract);
    	}

    	System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String dateString = sc.next();
        String[] dateParts = dateString.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt(dateParts[1]);
        
        double total = worker.income(year, month);
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " +dateString+ " : " + total) ;
	
    	sc.close();
    }
}
