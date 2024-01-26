// Write a menu driven Java Program to work with files.

/*
1] Write a menu driven Java program to read contents of a file and: 
a) print characters on the console – one character at a time 
b) print the entire file 
c) print contents to another file. 
Read both source & target file names & check for their existence/ non – existence to take appropriate actions.
*/
package TW1;

import java.io.*;
import java.util.Scanner;

public class TW1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source file name: ");
		String sourceFileName = sc.nextLine();
		System.out.println("Enter destn file name: ");
		String destFileName = sc.nextLine();
		
		File sourceFile = new File(sourceFileName);
	
		if (!sourceFile.exists()) {
			System.out.println("Source file doesn't exist!");
            sc.close();
			return;
		}
		
		char choice = getMenuChoice(sc);
		
		switch(choice) {
			case 'a':
				printFileCharacters(sourceFile);
				break;
			case 'b':
				printEntireFile(sourceFile);
				break;
			case 'c':
				copyFileContents(sourceFile, destFileName);
				break;
			default:
				System.out.println("Invalid choice!");
		}
        sc.close();
	}

	private static char getMenuChoice(Scanner sc) {
		System.out.println("Enter Menu Choice: ");
		System.out.println("a. Print file content char by char ");
		System.out.println("b. Print entire file");
		System.out.println("c. Transfer File contents");
		return sc.nextLine().charAt(0);
	}

	private static void printFileCharacters(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int character;
			while ((character = br.read()) != -1) {
				System.out.print((char)character);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printEntireFile(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void copyFileContents(File srcFile, String destnFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(srcFile));
		     BufferedWriter bw = new BufferedWriter(new FileWriter(destnFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

