package com.github.temptatio.shellsort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import javax.xml.bind.ValidationException;

import org.junit.Test;

/**
 * Diese Methode testet die korrekte Funktionsweise der Klasse
 * {@link AbstandsfolgeShell}
 * 
 */
public class AbstandsfolgeShellTest {

	/**
	 * Der Pruefling
	 */
	private Abstandsfolge abstandsfolge;

	/**
	 * Diese Methode testet die korrekte Funktionsweise der Methode
	 * {@link AbstandsfolgeShell#hasNext()]
	 */
	@Test
	public void testHasNext() throws ValidationException {

		this.abstandsfolge = new AbstandsfolgeShell(4);
		for (int i = 0; i < 10; ++i) {
			if (i < 3) {
				assertTrue(this.abstandsfolge.hasNext());
				this.abstandsfolge.next();
			}

		}
	}

	@Test(expected = ValidationException.class)
	public void testHasNextException1() throws ValidationException {
		this.abstandsfolge = new AbstandsfolgeShell(0);
	}

	@Test(expected = ValidationException.class)
	public void testHasNextException2() throws ValidationException {
		this.abstandsfolge = new AbstandsfolgeShell(32);
	}

	/**
	 * Diese Methode testet die korrekte Funktionsweise der Methode
	 * {@link Abstandsfolge#next()}
	 * 
	 * @throws ValidationException
	 */
	@Test
	public void testNext() throws ValidationException {

		int sequenzenZaehler = 8;
		this.abstandsfolge = new AbstandsfolgeShell(sequenzenZaehler);
		while (this.abstandsfolge.hasNext()) {
			final int istSchrittweite = this.abstandsfolge.next().intValue();
			final int sollSchrittweite = (int) Math.pow(2, --sequenzenZaehler);
			assertEquals(sollSchrittweite, istSchrittweite);
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextException() throws ValidationException {
		this.abstandsfolge = new AbstandsfolgeShell(4);
		for (int i = 0; i < 4; ++i) {
			this.abstandsfolge.next();
		}
	}

}
