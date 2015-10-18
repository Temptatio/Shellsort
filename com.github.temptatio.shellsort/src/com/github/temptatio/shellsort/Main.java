package com.github.temptatio.shellsort;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

import javax.xml.bind.ValidationException;

public class Main {

	final static int LAENGE = 10;

	public static void main(String[] args) throws ValidationException {

		final Abstandsfolge abstandsfolge = new AbstandsfolgeShell(4);

		double[] array = erstelleZufallsarray();

		System.out.println("Nicht sortiert:\n");
		System.out.println("=====================================\n");
		druckeArray(array);

		Shellsort.sort(array, abstandsfolge);

		System.out.println("Sortiert:\n");
		System.out.println("=====================================\n");
		druckeArray(array);

	}

	protected static void druckeArray(final double[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.printf(Locale.US, "%.4f\n", new Double(array[i]));
		}
	}

	private static double[] erstelleZufallsarray() {
		SecureRandom secureRandom = new SecureRandom();
		long seed = new BigInteger(secureRandom.generateSeed(Integer.SIZE / Byte.SIZE)).longValue();
		Random random = new Random(seed);

		double[] array = new double[LAENGE];

		for (int i = 0; i < LAENGE; ++i) {
			array[i] = random.nextDouble();
		}

		return array;
	}

}
