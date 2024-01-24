/*
 * 4]	Write a menu-driven Java Program to create an ArrayList of 
 * (1) integers and 
 * (2) floats of user specified length. 
 * Write a set of overloaded methods to “add” and/or “remove” elements from the arrays and 
 * another set of overloaded methods to perform linear search on the arrays, given the key element. 
 * Create object(s) to demonstrate the above functionalities. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TW4 {
    private ArrayList<Integer> integerList;
    private ArrayList<Float> floatList;

    public TW4() {
        integerList = new ArrayList<>();
        //Create an ArrayList object of type float
        floatList = new ArrayList<>();
    }

    // Method to add elements to the integer ArrayList
    public void addElement(int element) {
        integerList.add(element);
    }

    // Method to add elements to the float ArrayList
    public void addElement(float element) {
        floatList.add(element);
    }

    // Method to remove elements from the integer ArrayList
    public void removeElement(int index) {
        if (index >= 0 && index < integerList.size()) {
            integerList.remove(index);
        } else {
            System.out.println("Invalid index for integer ArrayList!");
        }
    }

    // Method to remove elements from the float ArrayList
    public void removeElement(float element) {
        // Remove element
        if (floatList.contains(element)) {
            floatList.remove(element);
        }
        else {
            System.out.println("Element not present!");
        }
    }

    // Method to perform linear search on the integer ArrayList
    public boolean linearSearch(int key) {
        return integerList.contains(key);
    }

    // Method to perform linear search on the float ArrayList
    public boolean linearSearch(float floatKey) {
        return floatList.contains(floatKey);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TW4 operations = new TW4();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add an integer element");
            System.out.println("2. Add a float element");
            System.out.println("3. Remove an integer element");
            System.out.println("4. Remove a float element");
            System.out.println("5. Search in integer ArrayList");
            System.out.println("6. Search in float ArrayList");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // read an integer and add element to integer list
                    System.out.print("Enter the integer to add in the list: ");
                    int integerEle = scanner.nextInt();
                    operations.addElement(integerEle);
                    break;
                case 2:
                    // read a float and add element to float list
                    System.out.print("Enter the float to add in the list: ");
                    float floatEle = scanner.nextFloat();
                    operations.addElement(floatEle);
                    break;
                case 3:
                    // read index of element and remove from integer list
                    System.out.print("Enter the index to remove in the intList: ");
                    int index = scanner.nextInt();
                    operations.removeElement(index);
                    break;
                case 4:
                    // read element and remove from floatlist
                    System.out.print("Enter the float element to remove in floatList: ");
                    float floatRem = scanner.nextFloat();
                    operations.removeElement(floatRem);
                    break;
                case 5:
                    System.out.print("Enter the integer to search in the list: ");
                    int intSearchKey = scanner.nextInt();
                    // read int element to be seached and perform a linear Search(return boolean
                    // value)
                    System.out.println("Integer found: " + operations.linearSearch(intSearchKey));
                    break;
                case 6:
                    System.out.println("Enter the float to search in the list: ");
                    float floatSearchKey = scanner.nextFloat();
                    // read float element to be seached and perform a linear Search(return boolean
                    // value)
                    System.out.println("Float found: " + operations.linearSearch(floatSearchKey));
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
