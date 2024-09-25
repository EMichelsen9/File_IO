/*
 * Author: Eleanor Michelsen
 * Assignment: C10A
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {

	private static ArrayList<Student> students = new ArrayList<Student>(); 
	
	/* Empty constructor for if you need to unstatic all methods. Please delete it otherwise. 
	 * ScoreTrakker(){}
	 */
	
	public static void loadDataFile(String fileName) throws FileNotFoundException {
		FileReader read = new FileReader(fileName);
		Scanner sc = new Scanner(read);
		while (sc.hasNext()) {
		String nameTemp = sc.next() + " " + sc.next();
		int scoreTemp = sc.nextInt();
		students.add(new Student(nameTemp, scoreTemp));}
	}
	
	public static void printInOrder(ArrayList<Student> sortedStudents) {
		sortedStudents.sort(null);
		System.out.println("Sorted Students");
		for (Student s : sortedStudents) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		try {
			loadDataFile("scores.txt");
			printInOrder(students);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
