package genetiks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class test {

	public static void main(String[] args) {

		Fenotyp fenotyp = new Fenotyp();
		Population pop = new Population();
		MetodyGenetyczne mg = new MetodyGenetyczne();
		FunkcjaPrzystosowania f = new FunkcjaPrzystosowania();
		KoloRuletki kolo = new KoloRuletki();

		fenotyp.createStringFenotyp(0, 31);
		
		fenotyp.convertStringToIntTab(fenotyp.getFenotypStringList());
		
		pop.createPopulation(fenotyp.getFenotypIntTab(), 2);
		for(Integer[] row: pop.getPopulation()){
			System.out.println(Arrays.toString(row));
		}
		
		pop.decodeBitReprezentation(pop.getPopulation());
		System.out.println(pop.getBitAndIntPopulation().get(pop.getPopulation().get(0)));
		System.out.println(pop.getBitAndIntPopulation().get(pop.getPopulation().get(1)));
		

//		Iterator iterator = pop.getBitAndIntPopulation().keySet().iterator();

//		while (iterator.hasNext()) {
//		   String key = iterator.next().toString();
//		   Integer value = pop.getBitAndIntPopulation().get(key);
//
//		   System.out.println(key + " " + value);
//		}
		
//		f.f(pop.getPopulation().get(0));
//		f.bitToInt(pop.getPopulation().get(0));
//		f.f(f.getIntValue());
//		System.out.println(f.getIntValue());
		
//		System.out.println("Wielko�� Populacji :" + pop.getPopulation().size());
//		for(int[] row: pop.getPopulation()){
//			System.out.println("Osobnik : " + Arrays.toString(row));
//		}
//		
//		System.out.println("Pr�ba reprodukcji");
//		mg.reprodukcja(pop.getPopulation().get(0));
//		System.out.println("Rodzic : " + Arrays.toString(pop.getPopulation().get(0)));
//		System.out.println("Potomek : " + Arrays.toString(mg.getPotomek()));
//		
//		System.out.println("Pr�ba krzy�owania");
//		System.out.println("Rodzic 1 : " + Arrays.toString(pop.getPopulation().get(0)));
//		System.out.println("Rodzic 2 : " + Arrays.toString(pop.getPopulation().get(1)));
//		mg.krzyzowanie(pop.getPopulation().get(0), pop.getPopulation().get(1));
//		for(int[] row: mg.getPotomkowieLista()){
//			System.out.println("Potomek : " + Arrays.toString(row));
//		}
//		System.out.println("Pr�ba mutacji");
//		mg.mutacja(pop.getPopulation().get(0));	
//		System.out.println(Arrays.toString(mg.getPotomek()));
	}

}
