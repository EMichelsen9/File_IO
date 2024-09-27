/*
 * Authors: Eleanor Michelsen, Jonah Mangi
 * Assignment: C10A
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {

	private static ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public static void loadDataFile(String fileName) throws FileNotFoundException {
		FileReader read = new FileReader(fileName);
		Scanner sc = new Scanner(read);
		String nameTemp = ""; // Create the temporary variables outside of the try block so that the catch can read them
		String scoreTemp = ""; // scoreTemp is a string because only invalid scores (strings) will be stored here
		while (sc.hasNext()) {
            try {
                nameTemp = sc.next() + " " + sc.next(); 
                scoreTemp = sc.next();
                int score = Integer.parseInt(scoreTemp); // Try to parse the score
                students.add(new Student(nameTemp, score));
            } catch (NumberFormatException e) {
                // If we're here, the parsing failed, and the score is not valid
                System.out.println("Incorrect format for " + nameTemp + " not a valid score: " + scoreTemp);
            }
        }
		sc.close();
	}
	
	public static void printInOrder(ArrayList<Student> sortedStudents) {
		sortedStudents.sort(null);
		System.out.println("Sorted Students");
		for (Student s : sortedStudents) {
			System.out.println(s);
		}
	}
	
	public void processFiles() { 
		for (String fileName : files) {
			try {
				loadDataFile(fileName);
				printInOrder(students);
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + fileName);
			}
		}

	}
	
	public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        tracker.processFiles();
    }

}
