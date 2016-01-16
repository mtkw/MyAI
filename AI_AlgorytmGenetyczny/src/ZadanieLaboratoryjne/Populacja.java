package ZadanieLaboratoryjne;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Klasa Odpowiedzialna za utworzenie populacji osobnik�w
 * Populacja sk�ada si� z osobnik�w z przedzia�u [0,5 - 2,5]
 * Ka�dy osobnik musi by� wyznaczony z dok�adno�ci� do 3 zer po kropce dziesi�tnej
 * Ca�a Populacja sk�ada si� z 2000 osobnik�w 
 * Wynika z tego �e ka�dy osobnik musi by� zakodowany na 11 bitach
 * 2 do 10 pot�gi < 2000 < 2 do 11 pot�gi
 * 1024 < //2000// < 2048
 */
public class Populacja {

	private LinkedList<Integer[]> populacja;
	private Integer[] pierwszyOsobnik;

	/*
	 * Integer pop_size -> wielko�� populacji (ca�a przestrze� przeszukiwa�)
	 * Integer size -> ilo�� bit�w potrzebna do zakodwoania pojedynczego
	 * osobnika
	 */
	public LinkedList<Integer[]> utworzeniePopulacji(Integer pop_size, Integer size) {
		populacja = new LinkedList<>();
		for (Integer i = pop_size; i >= 0; i--) {

			Integer[] osobnik = new Integer[size];
			utw�rzPierwszegoOsobnika(size);
			osobnik = pierwszyOsobnik;
			
			// Zamiana ka�dego punktu z przestrzeni poszukiwa� na reprezentacje
			// binarn�
			String strBit = Integer.toBinaryString(i);
			// Zamiana reprezentacji binarnej na tablice znak�w [0,1]
			char[] charTab = strBit.toCharArray();

			if (strBit.toCharArray().length == size) {
				for (int j = size - 1; j >= 0; j--) {
					if (charTab[j] == 48) {
						osobnik[j] = 0;
					} else {
						osobnik[j] = 1;
					}
				}
			} else {
				for (int s = charTab.length - 1; s >= 0; s--) {
					int przesuniecie = size - charTab.length;
					if (charTab[s] == 48) {
						osobnik[s + przesuniecie] = 0;
					} else {
						osobnik[s + przesuniecie] = 1;
					}
				}
			}
			populacja.add(osobnik);
		}
		return populacja;
	}

	/*
	 * Prywanta metod s�u��ca do utworzenia pierwszego osobnika o warto�ci 0
	 */
	private Integer[] utw�rzPierwszegoOsobnika(Integer size) {
		pierwszyOsobnik = new Integer[size];

		for (int i = size - 1; i >= 0; i--) {
			pierwszyOsobnik[i] = 0;
		}

		return pierwszyOsobnik;
	}
	
	//Dekodowanie Zgodne ze wzrorem umieszczonym w przyk�adzie
	public Double dekodowanieChromosomu(Integer[] osobnik, Double pocz�tekZakresu, Double wielko��Zakresu){
		Double value = 0.0;
		int xPrim = 0;
		for(int i = 0; i < osobnik.length; i++){
			xPrim += (int)(osobnik[i] * 2);
		}
		System.out.println(xPrim);
		value = pocz�tekZakresu + (wielko��Zakresu * xPrim)/(Math.pow(2.0, 11.0) - 1);
		return value;
	}

	public LinkedList<Integer[]> getPopulacja() {
		return populacja;
	}

	public void setPopulacja(LinkedList<Integer[]> populacja) {
		this.populacja = populacja;
	}

}
