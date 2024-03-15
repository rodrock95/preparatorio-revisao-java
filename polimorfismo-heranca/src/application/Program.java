package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int numberTaxPayers = sc.nextInt();
		
		TaxPayer taxPayer;
		List<TaxPayer> list = new ArrayList<>();
		
		double sum = 0;
		for(int i = 1; i <=numberTaxPayers; i++) {
			
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			int ic = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
		
			if(ic == 'i') {		
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				
				taxPayer = new Individual(name, anualIncome, healthExpenditures);
				list.add(taxPayer);
				sum += taxPayer.tax();
				
			}
			else {
				System.out.print("Number of employees: ");
				int numberEmployees = sc.nextInt();
				
				taxPayer = new Company(name, anualIncome, numberEmployees);
				list.add(taxPayer);
				sum += taxPayer.tax();
			}
		}
		System.out.println("\nTAXES PAID");
		
		for(TaxPayer t : list) {
			System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
		}
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));	
		
		sc.close();

	}

}
