package ZadanieLaboratoryjne;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/*
 * Klasa Odpowiedzialna za utworzenie populacji osobnik�w
 * Populacja sk�ada si� z osobnik�w z przedzia�u [0,5 - 2,5]
 * Ka�dy osobnik musi by� wyznaczony z dok�adno�ci� do 3 zer po kropce dziesi�tnej
 * Ca�a Populacja sk�ada si� z 2047 osobnik�w 
 * Wynika z tego �e ka�dy osobnik musi by� zakodowany na 11 bitach
 */
public class Populacja {

	private FunkcjaPrzystosowania fn = new FunkcjaPrzystosowania();

	private LinkedList<Object[]> fenotyp;
	private Object[] pierwszyOsobnik;
	private LinkedList<Object[]> populacja;
	private LinkedList<Object[]> populacjaPoOceniePrzystosowania;

	/*
	 * Integer pop_size -> wielko�� populacji (ca�a przestrze� przeszukiwa�)
	 * Integer size -> ilo�� bit�w potrzebna do zakodwoania pojedynczego
	 * osobnika
	 */
	public LinkedList<Object[]> utworzenieFenotypu(Integer pop_size, Integer size) {
		fenotyp = new LinkedList<>();
		for (Integer i = pop_size; i >= 0; i--) {

			Object[] osobnik = new Object[size];
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
			fenotyp.add(osobnik);
		}
		return fenotyp;
	}

	/*
	 * Prywanta metod s�u��ca do utworzenia pierwszego osobnika o warto�ci 0
	 */
	private Object[] utw�rzPierwszegoOsobnika(Integer size) {
		pierwszyOsobnik = new Object[size];

		for (int i = size - 1; i >= 0; i--) {
			pierwszyOsobnik[i] = 0;
		}

		return pierwszyOsobnik;
	}

	// Dekodowanie Zgodne ze wzrorem umieszczonym w przyk�adzie
	public Double dekodowanieChromosomu(Object[] osobnik, Double pocz�tekZakresu, Double wielko��Zakresu) {
		Double value = 0.0;
		int xPrim = 0;
		int pot = 0;
		for (int i = osobnik.length - 1; i >= 0; i--) {
			int val = (int)osobnik[i];
			xPrim += (int) (val * Math.pow(2, pot));
			pot++;
		}
		BigDecimal bd = new BigDecimal(pocz�tekZakresu + (wielko��Zakresu * xPrim) / (Math.pow(2.0, 11.0) - 1));
	    BigDecimal rounded = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
//		value = pocz�tekZakresu + (wielko��Zakresu * xPrim) / (Math.pow(2.0, 11.0) - 1);
//	    System.out.println(rounded.doubleValue());
		return rounded.doubleValue();
	}

	public LinkedList<Object[]> inicjacjaPopulacji(LinkedList<Object[]> fenotyp, int pop_size) {
		populacja = new LinkedList<>();
		for (int i = 0; i < pop_size; i++) {
			Random r = new Random();
			int pozycja = r.nextInt(fenotyp.size() - 1);
//			System.out.println("RANDOM:  " + pozycja);
			populacja.add(fenotyp.get(pozycja));
		}
		return populacja;
	}

	/*
	 * Tworzy Liste zawieraj�c� dwa parametry
	 * pierwszy parametr to pozycja chromosomu na li�cie populacji
	 * drugi parametr to warto�� funkcji przystosowania dla tego chromosomu
	 */
	public LinkedList<Object[]> ocenaPrzystosowaniaChromosomu(LinkedList<Object[]> populacja) {
		populacjaPoOceniePrzystosowania = new LinkedList<>();
		for (Object[] chromosom: populacja) {
			Object[] wektor = new Object[12];
			fn.wyznaczenie_warto�ci_funckji_przystosowania(dekodowanieChromosomu(chromosom, 0.5, 2.0));
			for(int j = 0; j < wektor.length - 1; j++){
				wektor[j] = chromosom[j];
			}
			wektor[11] = fn.getWartoscFunckji();
			populacjaPoOceniePrzystosowania.add(wektor);
		}
		return populacjaPoOceniePrzystosowania;
	}

	public LinkedList<Object[]> getFenotyp() {
		return fenotyp;
	}

	public void setFenotyp(LinkedList<Object[]> fenotyp) {
		this.fenotyp = fenotyp;
	}

	public LinkedList<Object[]> getPopulacja() {
		return populacja;
	}

	public void setPopulacja(LinkedList<Object[]> populacja) {
		
		for(Object[] row: populacja){
			populacja.add(row);
		}
		this.populacja = populacja;
	}

	public LinkedList<Object[]> getPopulacjaPoOceniePrzystosowania() {
		return populacjaPoOceniePrzystosowania;
	}

	public void setPopulacjaPoOceniePrzystosowania(LinkedList<Object[]> populacjaPoOceniePrzystosowania) {
		this.populacjaPoOceniePrzystosowania = populacjaPoOceniePrzystosowania;
	}

}
