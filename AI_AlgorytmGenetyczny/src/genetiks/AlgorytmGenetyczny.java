package genetiks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorytmGenetyczny {

	private Fenotyp fenotyp = new Fenotyp();
	private FunkcjaPrzystosowania funkcja = new FunkcjaPrzystosowania();
	private MetodyGenetyczne metody = new MetodyGenetyczne();
	private Population populacja = new Population();

	List<int[]> test = new ArrayList<>();

	/*
	 * Utworzenie ca³ej przestrzeni przeszukiwañ do zadania
	 * w formie binarnejs
	 */
	public void utworzenieFenotypu(int start, int end) {
		fenotyp.createStringFenotyp(start, end);
		fenotyp.convertStringToIntTab(fenotyp.getFenotypStringList());
	}

	public static void main(String[] args) {

		AlgorytmGenetyczny ag = new AlgorytmGenetyczny();
		
		ag.utworzenieFenotypu(0, 31);
		System.out.println(Arrays.toString(ag.test.get(30)));
		
	}

}
