package service;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import model.Reader;

public class IDGenerator {
	private static Random numberGenerator = new Random();
	private static Set<Integer> idPool = new TreeSet<Integer>();

	public static int generateID() {
		int number = 1 + numberGenerator.nextInt(1000);
		while (idPool.contains(number)) {
			number = 1 + numberGenerator.nextInt(1000);
		}
		idPool.add(number);
		return number;
	}

	public static void getBackNumberID(Reader reader) {
		int number = reader.getId();
		idPool.remove(number);
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++)
			System.out.println(generateID());
	}
}
