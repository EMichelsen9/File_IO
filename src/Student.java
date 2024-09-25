/*
 * Author: Eleanor Michelsen
 * Assignment: C10A
 */

public class Student implements Comparable<Student>{

	private String name;
	private int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	@Override 
	public String toString(){
		return name + " " + score;
	}

	@Override
	public int compareTo(Student s) {
		
		return this.score - s.score;
	}
}
