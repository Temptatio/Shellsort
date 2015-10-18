package com.github.temptatio.shellsort;

import java.util.NoSuchElementException;

import javax.xml.bind.ValidationException;

/**
 * Diese Klasse implementiert eine Abstandsfolge, wie von Shell vorgeschlagen (in 2er-Potenzen)
 *
 */
public class AbstandsfolgeShell implements Abstandsfolge {

	private int aktuelleSchrittweite;

	/**
	 * Der Konstruktor der Klasse
	 * 
	 * @param sequenzen Die Zahl der Sequenzen (zwischen 1 und 31)
	 * @throws ValidationException falls die Zahl der Sequenzen nicht korrekt ist
	 */
	public AbstandsfolgeShell(final int sequenzen) throws ValidationException {
		if (sequenzen < 1 || sequenzen > 31) {
			throw new ValidationException("Die Zahl der Sequenzen muss zwischen 1 und 31 liegen!");
		}

		this.aktuelleSchrittweite = 1 << (sequenzen - 1);
	}

	/**
	 * Diese Methode gibt zurueck, ob die feinste Unterteilung erreicht wurde (jedes Element wird beruecksichtigt)
	 */
	@Override
	public boolean hasNext() {
		return this.aktuelleSchrittweite > 0;
	}

	/**
	 * Diese Methode gibt die naechstkleinere Schrittweite zurueck
	 * 
	 * @return Die naechstkleinere Schrittweite
	 */
	@Override
	public Integer next() {
		if (this.hasNext()) {
			final int tmp = this.aktuelleSchrittweite;
			this.aktuelleSchrittweite >>= 1;
			return tmp;
		}

		throw new NoSuchElementException();
	}

}
