package genetiks;

import java.util.Arrays;
import java.util.Random;

public class test {

	public static void main(String[] args) {

		Fenotyp fenotyp = new Fenotyp();
		Population pop = new Population();
		MetodyGenetyczne mg = new MetodyGenetyczne();

		fenotyp.createStringFenotyp(0, 31);
		
		fenotyp.convertStringToIntTab(fenotyp.getFenotypStringList());
		
		pop.createPopulation(fenotyp.getFenotypIntTab(), 2);
		
		System.out.println("Wielkoœæ Populacji :" + pop.getPopulation().size());
		for(int[] row: pop.getPopulation()){
			System.out.println("Osobnik : " + Arrays.toString(row));
		}
		
		System.out.println("Próba reprodukcji");
		mg.reprodukcja(pop.getPopulation().get(0));
		System.out.println("Rodzic : " + Arrays.toString(pop.getPopulation().get(0)));
		System.out.println("Potomek : " + Arrays.toString(mg.getPotomek()));
		
		System.out.println("Próba krzy¿owania");
		System.out.println("Rodzic 1 : " + Arrays.toString(pop.getPopulation().get(0)));
		System.out.println("Rodzic 2 : " + Arrays.toString(pop.getPopulation().get(1)));
		mg.krzyzowanie(pop.getPopulation().get(0), pop.getPopulation().get(1));
		for(int[] row: mg.getPotomkowieLista()){
			System.out.println("Potomek : " + Arrays.toString(row));
		}
		System.out.println("Próba mutacji");
		mg.mutacja(pop.getPopulation().get(0));	
		System.out.println(Arrays.toString(mg.getPotomek()));
	}

}
