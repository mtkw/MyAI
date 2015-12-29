package genetiks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MetodyGenetyczne {

	private int[] potomek = new int[5];
	private List<int[]> potomkowieLista = new ArrayList<>();

	public int[] reprodukcja(int[] genom) {
		potomek = (int[]) genom;
		return potomek;
	}

	public List<int[]> krzyzowanie(int[] rodzic1, int[] rodzic2) {
		Random r = new Random();
		int punktPrzeciecia = r.nextInt(rodzic1.length - 1) + 1;
		int liczbaElementow = rodzic1.length - punktPrzeciecia;

		int[] klon1 = (int[]) rodzic1.clone();
		int[] klon2 = (int[]) rodzic2.clone();

		System.arraycopy(klon1, punktPrzeciecia, klon2, punktPrzeciecia, liczbaElementow);
		System.arraycopy(rodzic2, punktPrzeciecia, klon1, punktPrzeciecia, liczbaElementow);

		// Testy Szczegó³owe wyœwietlaj¹ce poprawnoœæ mechaniznmu krzy¿owania

		// System.out.println("Punkt Przeciêcia : " + punktPrzeciecia);
		// System.out.println("Liczba Elementow do kopiowania : " +
		// liczbaElementow);

		// System.out.println("Potomek 1: " + Arrays.toString(klon1));
		// System.out.println("Potomek 2: " + Arrays.toString(klon2));

		potomkowieLista.add(klon1);
		potomkowieLista.add(klon2);

		return potomkowieLista;
	}

	public int[] mutacja(int[] genom) {
		Random r = new Random();
		int gen = r.nextInt(genom.length - 1);

		int[] klon = (int[]) genom.clone();

		// System.out.println(Arrays.toString(klon));

		if (klon[gen] == 1) {
			klon[gen] = 0;
		} else {
			klon[gen] = 1;
		}
		// System.out.println("Gen podlegajacy mutacji : " + gen);
		// System.out.println(Arrays.toString(klon));

		potomek = (int[]) klon;

		return potomek;
	}

	public int[] getPotomek() {
		return potomek;
	}

	public void setPotomek(int[] potomek) {
		this.potomek = potomek;
	}

	public List<int[]> getPotomkowieLista() {
		return potomkowieLista;
	}

	public void setPotomkowieLista(List<int[]> potomkowieLista) {
		this.potomkowieLista = potomkowieLista;
	}

}
