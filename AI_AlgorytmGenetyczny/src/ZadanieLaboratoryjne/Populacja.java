package ZadanieLaboratoryjne;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Klasa Odpowiedzialna za utworzenie populacji osobników
 * Populacja sk³ada siê z osobników z przedzia³u [0,5 - 2,5]
 * Ka¿dy osobnik musi byæ wyznaczony z dok³adnoœci¹ do 3 zer po kropce dziesiêtnej
 * Ca³a Populacja sk³ada siê z 2000 osobników 
 * Wynika z tego ¿e ka¿dy osobnik musi byæ zakodowany na 11 bitach
 * 2 do 10 potêgi < 2000 < 2 do 11 potêgi
 * 1024 < //2000// < 2048
 */
public class Populacja {

	private LinkedList<Integer[]> populacja;
	private Integer[] pierwszyOsobnik;

	/*
	 * Integer pop_size -> wielkoœæ populacji (ca³a przestrzeñ przeszukiwañ)
	 * Integer size -> iloœæ bitów potrzebna do zakodwoania pojedynczego
	 * osobnika
	 */
	public LinkedList<Integer[]> utworzeniePopulacji(Integer pop_size, Integer size) {
		populacja = new LinkedList<>();
		for (Integer i = pop_size; i >= 0; i--) {

			Integer[] osobnik = new Integer[size];
			utwórzPierwszegoOsobnika(size);
			osobnik = pierwszyOsobnik;
			
			// Zamiana ka¿dego punktu z przestrzeni poszukiwañ na reprezentacje
			// binarn¹
			String strBit = Integer.toBinaryString(i);
			// Zamiana reprezentacji binarnej na tablice znaków [0,1]
			char[] charTab = strBit.toCharArray();

			if (strBit.toCharArray().length == size) {
				for (int j = size - 1; j >= 0; j--) {
					if (charTab[j] == 48) {
						osobnik[j] = 0;
					} else {
						osobnik[j] = 1;
					}
//					populacja.add(osobnik);
				}
			} else {
				for (int s = charTab.length - 1; s >= 0; s--) {
					int przesuniecie = size - charTab.length;
					if (charTab[s] == 48) {
						osobnik[s + przesuniecie] = 0;
					} else {
						osobnik[s + przesuniecie] = 1;
					}
//					populacja.add(osobnik);
				}
			}
			populacja.add(osobnik);
		}
		return populacja;
	}

	/*
	 * Prywanta metod s³u¿¹ca do utworzenia pierwszego osobnika o wartoœci 0
	 */
	private Integer[] utwórzPierwszegoOsobnika(Integer size) {
		pierwszyOsobnik = new Integer[size];

		for (int i = size - 1; i >= 0; i--) {
			pierwszyOsobnik[i] = 0;
		}

		return pierwszyOsobnik;
	}

	public LinkedList<Integer[]> getPopulacja() {
		return populacja;
	}

	public void setPopulacja(LinkedList<Integer[]> populacja) {
		this.populacja = populacja;
	}

}
