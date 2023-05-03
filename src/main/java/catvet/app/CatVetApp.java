package catvet.app;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.jeep.JeepSales;

import catvet.ComponentScanMarker;
import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.entity.Owner;
import catvet.exception.CVException;
import catvet.service.DefaultCatVetService;



@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class })
public class CatVetApp {
	private Scanner scanner = new Scanner(System.in);
	private DefaultCatVetService catVetService = new DefaultCatVetService();
	private Cat curCat;
	// @formatter: off
	private List<String> operations = List.of(
			"1) Add an owner", 
			"2) Add a patient", 
			"3) List patients",
			"4) Select a patient",
			"5) Update patient info", 
			"6) Update owner info",
			"7) List doctors on call"
	// @formatter: on
	);
	
	public static void main(String[] args) {
		SpringApplication.run(CatVetApp.class, args);
		new CatVetApp().displayMenu();

	}
	private void displayMenu() {
		boolean done = false;

		while (!done) {
			try {
				int operation = getOperation();
				switch (operation) {
				case -1:
					done = exitMenu();
					break;

				case 1:
					addOwner();
					break;

				case 2:
					addCat();
					break;

				case 3:
					listPatients();
					break;

				case 4:
					setCurrentPatient();
					break;

				case 5:
					updatePatientInfo();
					break;
					
				case 6:
					listDoctors();
					break;
					
				default:
					System.out.println("\n" + operation + " is not valid. Try again.");
					break;
				}
			} catch (Exception e) {
				System.out.println("\nError: " + e.toString() + " Try Again.");
			}
		}

	}
	
	private void addOwner() {
		String id = getStringInput("Enter an ID for this owner (e.g. FULL_NAME");
		String firstName = getStringInput("Enter the owner's first name");
		String lastName = getStringInput("Enter the owner's last name");
		
		Owner owner = new Owner();
		
		owner.setOwnerId(id);
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
	}
	
	private void addCat() {
		String id = getStringInput("Enter an ID for this patient (e.g. FULL_NAME");
		String name = getStringInput("Enter the patient's name");
		Integer age = getIntInput("Enter the patient's age");
		Breed breed = getEnumInput("Enter the patient's breed");
		String color = getStringInput("Enter the patient's fur color");
		boolean neutered = getBooleanInput("Is this patient neutered?");
		String personality = getStringInput("What sort of personality does this cat have?");
		String notes = getStringInput("Please add any relevant notes(optional)");

		Cat cat = new Cat();
		
		cat.setCatId(id);
		cat.setCatName(name);
		cat.setCatAge(age);
		cat.setBreed(breed);
		cat.setColor(color);
		cat.setNeutered(neutered);
		cat.setPersonality(personality);
		cat.setNotes(notes);

		Cat dbCat = catVetService.addCat(cat);
		System.out.println("You added this patient:\n" + dbCat);

		curCat = catVetService.fetchCatById(dbCat.getCatId());
		
	}
	private boolean exitMenu() {
		System.out.println("\nExiting the menu.");
		return true;
	}
	
	private int getOperation() {
		printOperations();
		Integer op = getIntInput("\nEnter an operation number (press Enter to quit)");

		return Objects.isNull(op) ? -1 : op;
	}
	
	private void printOperations() {
		System.out.println();
		System.out.println("Here's what you can do:");
		;

		operations.forEach(op -> System.out.println("   " + op));

		if (Objects.isNull(curCat)) {
			System.out.println("\nNo patient selected.");
		} else {
			System.out.println("\nYou are working with patient " + curCat);
		}
	}
	
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new CVException(input + " is not a valid number.");
		}
	}
	
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String line = scanner.nextLine();

		return line.isBlank() ? null : line.trim();
	}
	
	private boolean getBooleanInput(String prompt) {
		boolean result = Boolean.parseBoolean(scanner.nextLine());
		return result;
	}
	private Breed getEnumInput(String prompt) {
		String input = scanner.nextLine();
		return Breed.getByName(input);
	}
	
//	private List<Cat> listPatients() {
//		List<Cat> patients = catService.fetchRecipes();
//
//		System.out.println("\n Recipes:");
//
//		recipes.forEach(recipe -> System.out.println("   " + recipe.getRecipeId() + ": " + recipe.getRecipeName()));
//
//		return recipes;
//	}
}
