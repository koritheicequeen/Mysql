package project;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import project.entity.Project;
import projects.exception.DbException;
import projects.service.projectService;

public class projectsApp {
	private projectService ProjectService = new projectService();
//@formatter:off
	private List<String> operations = List.of("1) Add a project");
	//@formatter:on
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		new projectsApp().processUserSelections();
	}

	private void processUserSelections() {
		// TODO Auto-generated method stub
		boolean done = false;
	while(!done) {
	try {
		int selection = getUserSelection();
		switch (selection){
		case -1:
			done = exitMenu();
			break;
		case 1: 
			createProject();
			break;
		default:
			System.out.println("\n" + selection + " is not a valid selection. Try again.");
			break;
		}
	} catch (Exception e) {
		System.out.println("\nError: " + e + " try again.");
			}
		}
	}

	private void createProject() {
		// TODO Auto-generated method stub
		String projectName = getStringInput("Enter the project name.");
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours.");
		BigDecimal actualHours = getDecimalInput("Enter the actual hours.");
		Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
		String notes = getStringInput("Enter project notes.");
		Project project = new Project();
		
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		Project dbProject = projectService.addProject(project);
		System.out.println("You have successfully created project: "+ dbProject);
		
	}

	private BigDecimal getDecimalInput(String string) {
		// TODO Auto-generated method stub
		String Input = getStringInput(string);
		if (Objects.isNull(Input)) {
		// TODO Auto-generated method stub
		return null;}
		try {
		return new BigDecimal(Input).setScale(2);}
		catch(NumberFormatException e) {
			throw new DbException(Input + " is not a valid number");
		}
	}

	private boolean exitMenu() {
		// TODO Auto-generated method stub
		return false;
	}

	private int getUserSelection() {
		printOperations();
		
		Integer input = getIntInput("Enter a menu selection");
		// TODO Auto-generated method stub
		return Objects.isNull(input) ? -1 : input;
	}

	private Integer getIntInput(String String) {
		String Input = getStringInput(String);
		if (Objects.isNull(Input)) {
		// TODO Auto-generated method stub
		return null;}
		try {
		return Integer.valueOf(Input);}
		catch(NumberFormatException e) {
			throw new DbException(Input + " is not a valid number");
		}
	}

	private String getStringInput(String string) {
		// TODO Auto-generated method stub
		System.out.println(string + ": ");
		String input = scanner.nextLine();
		return input.isBlank() ? null : input.trim();
	}

	private void printOperations() {
		// TODO Auto-generated method stub
		System.out.println("\nThese are the available selections. Press Enter key to quit");
		for(String line : operations) {
			System.out.println("  "+ line);
		}
	}
	
}
