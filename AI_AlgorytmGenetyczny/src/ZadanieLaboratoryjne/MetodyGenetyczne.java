package ZadanieLaboratoryjne;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MetodyGenetyczne {

	private LinkedList<Object[]> potomstwo;
	private LinkedList<LinkedList<Object[]>> pary = new LinkedList<>();

	/*
	 * Prawdopodobienstwo wyst¹pienie ka¿dej z trzech mo¿liwych metod
	 * genetycznych Parametry w postaci int-ów Suma wszystkich trzech parametrów
	 * = 100
	 */
	public LinkedList<Object[]> ustawienieParametrow(int pk, int pr, int pm, LinkedList<Object[]> pulaRodzicielska) {
		potomstwo = new LinkedList<>();

		podzialPopulacjiNaPary(pulaRodzicielska);
		
		for(LinkedList<Object[]> row: pary){
				int wylosowanaLiczba = (int)row.getLast()[0];
				if(wylosowanaLiczba >= 0 && wylosowanaLiczba <= pk){
					System.out.println("KRZYZOWANIE");
					krzyzowanie(row);
				}if(wylosowanaLiczba > pk && wylosowanaLiczba <= pk+pr){
					System.out.println("REPRODUKCJA");
					reprodukcja(row);
				}if(wylosowanaLiczba > pk+pr && wylosowanaLiczba <= 100){
					System.out.println("MUTACJA");
					mutacja(row);
				}
		}

		return potomstwo;
	}

	private LinkedList<Object[]> krzyzowanie(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();

		return potomkowie;
	}

	private LinkedList<Object[]> mutacja(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();

		return potomkowie;
	}

	private LinkedList<Object[]> reprodukcja(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();

		return potomkowie;
	}

	/*
	 * Ka¿ada utworzona para ma odrazu przypisan¹ wylosowan¹ liczbê 
	 * Liczba ta okreœla zgodnie z parametrami zadania jakiej meotdzie zostanie poddana dana para
	 * Krzyo¿waniu, mutacji czy reprodukcji
	 */
	public LinkedList<LinkedList<Object[]>> podzialPopulacjiNaPary(LinkedList<Object[]> pulaRodzicielska) {

		for (int i = 0; i < pulaRodzicielska.size(); i += 2) {
			LinkedList<Object[]> pojedynczaPara = new LinkedList<>();
			
			
			Random r = new Random();
			Object[] wylosowanaLiczba = {r.nextInt(100)};
			
			pojedynczaPara.add(pulaRodzicielska.get(i));
			pojedynczaPara.add(pulaRodzicielska.get(i + 1));
			pojedynczaPara.add(wylosowanaLiczba);
			pary.add(pojedynczaPara);
		}

		return pary;
	}

}
