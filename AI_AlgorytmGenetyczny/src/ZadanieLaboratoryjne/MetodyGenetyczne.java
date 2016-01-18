package ZadanieLaboratoryjne;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MetodyGenetyczne {

	private LinkedList<Object[]> potomstwo = new LinkedList<>();
	private LinkedList<LinkedList<Object[]>> pary = new LinkedList<>();

	/*
	 * Prawdopodobienstwo wyst¹pienie ka¿dej z trzech mo¿liwych metod
	 * genetycznych Parametry w postaci int-ów Suma wszystkich trzech parametrów
	 * = 100
	 */
	public LinkedList<Object[]> ustawienieParametrow(int pk, int pr, int pm, LinkedList<Object[]> pulaRodzicielska) {

		podzialPopulacjiNaPary(pulaRodzicielska);

		for (LinkedList<Object[]> row : pary) {
			int wylosowanaLiczba = (int) row.getLast()[0];
			if (wylosowanaLiczba >= 0 && wylosowanaLiczba <= pk) {
				// System.out.println("KRZYZOWANIE");
				krzyzowanie(row);
			}
			if (wylosowanaLiczba > pk && wylosowanaLiczba <= pk + pr) {
				// System.out.println("REPRODUKCJA");
				reprodukcja(row);
			}
			if (wylosowanaLiczba > pk + pr && wylosowanaLiczba <= 100) {
				// System.out.println("MUTACJA");
				mutacja(row);
			}
		}
		System.out.println("OUTPU SIZE: " + potomstwo.size());
		return potomstwo;
	}

	private LinkedList<Object[]> krzyzowanie(LinkedList<Object[]> paraRodzicielska) {
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

		potomstwo.add(rodzic1);
		potomstwo.add(rodzic2);
		return potomstwo;
	}

	private LinkedList<Object[]> mutacja(LinkedList<Object[]> paraRodzicielska) {

		for (int i = 0; i < 2; i++) {
			Random r = new Random();
			int genPodlegajacyMutacji = r.nextInt(paraRodzicielska.get(i).length - 1) + 1;
			Object[] zmutowanyOsobnik = paraRodzicielska.get(i);
			if ((int) zmutowanyOsobnik[genPodlegajacyMutacji] == 0) {
				zmutowanyOsobnik[genPodlegajacyMutacji] = 1;
			} else {
				zmutowanyOsobnik[genPodlegajacyMutacji] = 0;
			}
			potomstwo.add(zmutowanyOsobnik);
		}

		return potomstwo;
	}

	private LinkedList<Object[]> reprodukcja(LinkedList<Object[]> paraRodzicielska) {

		potomstwo.add(paraRodzicielska.getFirst());
		potomstwo.add(paraRodzicielska.get(1));

		return potomstwo;
	}

	/*
	 * Ka¿ada utworzona para ma odrazu przypisan¹ wylosowan¹ liczbê Liczba ta
	 * okreœla zgodnie z parametrami zadania jakiej meotdzie zostanie poddana
	 * dana para Krzyo¿waniu, mutacji czy reprodukcji
	 */
	public LinkedList<LinkedList<Object[]>> podzialPopulacjiNaPary(LinkedList<Object[]> pulaRodzicielska) {

		for (int i = 0; i < pulaRodzicielska.size(); i += 2) {
			LinkedList<Object[]> pojedynczaPara = new LinkedList<>();

			Random r = new Random();
			Object[] wylosowanaLiczba = { r.nextInt(100) };

			pojedynczaPara.add(pulaRodzicielska.get(i));
			pojedynczaPara.add(pulaRodzicielska.get(i + 1));
			pojedynczaPara.add(wylosowanaLiczba);
			pary.add(pojedynczaPara);
		}

		return pary;
	}

	public LinkedList<Object[]> getPotomstwo() {
		return potomstwo;
	}

	public void setPotomstwo(LinkedList<Object[]> potomstwo) {
		this.potomstwo = potomstwo;
	}

}
