package Lambdas;

import java.util.ArrayList;
import java.util.List;

public interface DogCompare {
	List<Dog> getDogResultArray(ArrayList<Dog> dogArray, int value);
}
class Dog {
	String name;
	int weight;
	int age;
	Dog(String n, int w, int a){
		name = n;
		weight = w;
		age = a;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}
	
}