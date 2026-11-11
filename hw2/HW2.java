package edu.monmouth.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edu.monmouth.vehicle.*;

public class HW2 {
	public static void main(String[] args) {
		initialization(args);
		
		ArrayList<String> strings = new ArrayList<>();
		
		File stringsFile = new File(HW2Constants.STRINGFILE);
		try (Scanner scanner = new Scanner(stringsFile)) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found! Please check the file name.");
            System.exit(HW2Constants.BADSTRINGFILE);
        }
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		File vehiclesFile = new File(HW2Constants.VEHICLEFILE);
		int lineNumber = 0;
		
		try (Scanner scanner = new Scanner(vehiclesFile)) {
            while (scanner.hasNextLine()) {
            	String line = scanner.nextLine();
            	lineNumber++;
            	
            	try {
                    String[] fields = line.split(",");

                    if (fields.length != HW2Constants.REQUIRED_FIELDS) {
                    	System.err.println("Line " + lineNumber + " discarded - invalid string: \"" + line + "\"");
                    }

                    else {
	                    String type = fields[0];
	                    PowerTypes powerSource = PowerTypes.valueOf(fields[1]);;
	                    int amount  = Integer.parseInt(fields[2]);;
	                 
	                    Vehicle vehicle = null;
		                switch (type) {
		                    case "c":
		                        vehicle = new Car(powerSource, amount);
		                        vehicles.add(vehicle);
		                        break;
		                        
		                    case "b":
		                        vehicle = new Boat(powerSource, amount);
		                        vehicles.add(vehicle);
		                        break;
		                        
		                    default:
		                    	System.err.println("Line " + lineNumber + " discarded - invalid type of vehicle: \"" + line + "\"");
		                }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Line " + lineNumber + " discarded - not a whole number: \"" + line + "\"");
                } catch (IllegalArgumentException e) {
                    System.err.println("Line " + lineNumber + " discarded - " + e.getMessage() + ": \"" + line + "\"");
                }catch(BoatException be) {
                	System.err.println("Line " + lineNumber + " discarded - invalid atribute: \"" + line + "\"");
        			System.out.println(be.getMessage());
        			be.printStackTrace();
        		} catch(CarException ce) {
        			System.err.println("Line " + lineNumber + " discarded - invalid atribute: \"" + line + "\"");
        			System.out.println(ce.getMessage());
        			ce.printStackTrace();
        		}
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found! Please check the file name.");
            System.exit(HW2Constants.BADSTRINGFILE);
        }
		
		
		printStringList(strings);
        
        System.out.println("Empty String list: " + strings.isEmpty());
		
		while(!strings.isEmpty()) {
			strings.remove(0);
		}
		
		strings.add("Test String");
		
		printStringList(strings);
		
		
		
		printVehicleList(vehicles);
		
		System.out.println("Empty Vehicle list: " + strings.isEmpty());
		
		while(!vehicles.isEmpty()) {
			vehicles.remove(0);
		}
		
		try {
			vehicles.add(new Plane(PowerTypes.FUELOIL, 2));
		 
		
			printVehicleList(vehicles);
			
	        Vehicle inList = new Plane(PowerTypes.FUELOIL, 2);
	        System.out.println("contains(" + inList + ") -> " + vehicles.contains(inList));
	
	        Vehicle notInList = new Boat(PowerTypes.GASOLINE, 100);
	        System.out.println("contains(" + notInList + ") -> " + vehicles.contains(notInList));
			
			printVehicleList(vehicles);
			
		} catch (BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		} catch (PlaneException pe) {
				System.out.println(pe.getMessage());
				pe.printStackTrace();
		}	
		
		
		//HW2 In-class
		System.out.println("Number of elements in string list: " + strings.size());
		System.out.println("Number of elements in vehicle list: " + vehicles.size());
		
		System.out.println();
		printStringList(strings);
		
		System.out.println();
		printVehicleList(vehicles);
		
		System.out.println();
		printStringListBackward(strings);
		
		System.out.println();
		printVehicleListBackward(vehicles);
		
		try {
			vehicles.add(new Plane(PowerTypes.FUELOIL, 100));
		 
			System.out.println();
			printVehicleList(vehicles);
			
			vehicles.remove(new Plane(PowerTypes.FUELOIL, 2));
			
			System.out.println();
			printVehicleList(vehicles);
			
		} catch (PlaneException pe) {
				System.out.println(pe.getMessage());
				pe.printStackTrace();
		}
		
	}
	
	private static void initialization(String[] args) {
		// check for 3 command line argument
		if(args.length != HW2Constants.REQUIREDARGS) {
			System.err.println("Give the name of a log file");
			System.exit(HW2Constants.BADARGS);
		}
		// redirect STDOUT & STDERR to file name given in args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(HW2Constants.BADREDIRECT);
		}
	}
	
	
	private static void printStringList(List<String> list) {
        Iterator<String> stringArr = list.iterator();
        int index = 0;
        while (stringArr.hasNext()) {
            System.out.println("  [" + index + "] " + stringArr.next());
            index++;
        }
	}
	
	private static void printVehicleList(List<Vehicle> list) {
        Iterator<Vehicle> vehicleArr = list.iterator();
        int index = 0;
        while (vehicleArr.hasNext()) {
            System.out.println("  [" + index + "] " + vehicleArr.next());
            index++;
        }
	}
	
	private static void printStringListBackward(List<String> list) {
        Iterator<String> stringArr = list.reversed().iterator();
        int index = list.size() - 1;
        while (stringArr.hasNext()) {
            System.out.println("  [" + index + "] " + stringArr.next());
            index--;
        }
	}
	
	private static void printVehicleListBackward(List<Vehicle> list) {
        Iterator<Vehicle> vehicleArr = list.iterator();
        int index = list.size() - 1;
        while (vehicleArr.hasNext()) {
            System.out.println("  [" + index + "] " + vehicleArr.next());
            index--;
        }
	}
}
