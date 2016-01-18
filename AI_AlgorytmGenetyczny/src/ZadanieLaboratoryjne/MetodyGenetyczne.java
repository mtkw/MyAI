package ZadanieLaboratoryjne;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import sun.awt.windows.WLightweightFramePeer;

public class MetodyGenetyczne {

	private LinkedList<Object[]> potomstwo;
	private LinkedList<LinkedList<Object[]>> pary;

	/*
	 * Prawdopodobienstwo wyst¹pienie ka¿dej z trzech mo¿liwych metod
	 * genetycznych Parametry w postaci int-ów Suma wszystkich trzech parametrów
	 * = 100
	 */
	public LinkedList<Object[]> ustawienieParametrow(int pk, int pr, int pm, LinkedList<Object[]> pulaRodzicielska) {
		potomstwo = new LinkedList<>();
		
		podzialPopulacjiNaPary(pulaRodzicielska);
//		System.out.println(pary.size());

		for (LinkedList<Object[]> row : pary) {
			int wylosowanaLiczba = (int) row.getLast()[0];
			if (wylosowanaLiczba >= 0 && wylosowanaLiczba <= pk) {
//				System.out.println("KRZYZOWANIE");
				dodanieDoListyPotomkow(krzyzowanie(row));
			}
			if (wylosowanaLiczba > pk && wylosowanaLiczba <= pk + pr) {
//				System.out.println("REPRODUKCJA");
				dodanieDoListyPotomkow(reprodukcja(row));
			}
			if (wylosowanaLiczba > pk + pr && wylosowanaLiczba <= 100) {
//				System.out.println("MUTACJA");
				dodanieDoListyPotomkow(mutacja(row));
			}
			// System.out.println(potomstwo.size());
		}
//		System.out.println("KONIEC ITERACJI ----->>>>");
		// System.out.println("POTOMSTWO W MG: " + potomstwo.size());
		return potomstwo;
	}

	private LinkedList<Object[]> krzyzowanie(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();

		Object[] rodzic1 = paraRodzicielska.getFirst();
		Object[] rodzic2 = paraRodzicielska.get(1);
		Object[] rodzic2Clone = rodzic2.clone();

		Random r = new Random();
		int punktKrzyzowania = r.nextInt(rodzic1.length - 1) + 1;
		int liczbaElementow = rodzic1.length - punktKrzyzowania;

		// System.out.println("RODZIC 1 : " + Arrays.toString(rodzic1));
		// System.out.println("RODZIC 2 : " + Arrays.toString(rodzic2));

		System.arraycopy(rodzic1, punktKrzyzowania, rodzic2, punktKrzyzowania, liczbaElementow);
		System.arraycopy(rodzic2Clone, punktKrzyzowania, rodzic1, punktKrzyzowania, liczbaElementow);
		// System.out.println("PUNKT KRZYZOWANIA: " + punktKrzyzowania);

		// System.out.println("RODZIC 1 PO KRZYZOWANIU: " +
		// Arrays.toString(rodzic1));
		// System.out.println("RODZIC 2 PO KRZYZOWANIU: " +
		// Arrays.toString(rodzic2));

		potomkowie.add(rodzic1);
		potomkowie.add(rodzic2);
		return potomkowie;
	}

	private LinkedList<Object[]> mutacja(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();
		for (int i = 0; i < 2; i++) {
			Random r = new Random();
			int genPodlegajacyMutacji = r.nextInt(paraRodzicielska.get(i).length - 1) + 1;
			Object[] zmutowanyOsobnik = paraRodzicielska.get(i);
			if ((int) zmutowanyOsobnik[genPodlegajacyMutacji] == 0) {
				zmutowanyOsobnik[genPodlegajacyMutacji] = 1;
			} else {
				zmutowanyOsobnik[genPodlegajacyMutacji] = 0;
			}
			potomkowie.add(zmutowanyOsobnik);
		}

		return potomkowie;
	}

	private LinkedList<Object[]> reprodukcja(LinkedList<Object[]> paraRodzicielska) {
		LinkedList<Object[]> potomkowie = new LinkedList<>();
		potomkowie.add(paraRodzicielska.getFirst());
		potomkowie.add(paraRodzicielska.get(1));

		return potomkowie;
	}

	/*
	 * Ka¿ada utworzona para ma odrazu przypisan¹ wylosowan¹ liczbê Liczba ta
	 * okreœla zgodnie z parametrami zadania jakiej meotdzie zostanie poddana
	 * dana para Krzyo¿waniu, mutacji czy reprodukcji
	 */
	public LinkedList<LinkedList<Object[]>> podzialPopulacjiNaPary(LinkedList<Object[]> pulaRodzicielska) {

		pary = new LinkedList<>();

		int halfSize = pulaRodzicielska.size() / 2;

		for (int i = 0; i < halfSize; i++) {
			LinkedList<Object[]> pojedynczaPara = new LinkedList<>();

			Random r = new Random();
			Object[] wylosowanaLiczba = { r.nextInt(100) };
			pojedynczaPara.add(pulaRodzicielska.get(i));
			pojedynczaPara.add(pulaRodzicielska.get(i + halfSize));
			pojedynczaPara.add(wylosowanaLiczba);
			pary.add(pojedynczaPara);
		}

		return pary;
	}

	private void dodanieDoListyPotomkow(LinkedList<Object[]> potomkowiePoMetodachGenetycznych) {
		for (Object[] row : potomkowiePoMetodachGenetycznych) {
			potomstwo.add(row);
		}
	}

	public LinkedList<Object[]> getPotomstwo() {
		return potomstwo;
	}

	public void setPotomstwo(LinkedList<Object[]> potomstwo) {
		this.potomstwo = potomstwo;
	}

}
