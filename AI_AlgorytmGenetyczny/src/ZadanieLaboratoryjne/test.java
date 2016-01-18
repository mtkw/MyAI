package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		AlgorytmGenetyczny algorytm = new AlgorytmGenetyczny();
		
		algorytm.algorytmGenetyczny(2047, 11, 10, 75, 23, 2, 10);
		
		
//		Populacja p = new Populacja();
//		FunkcjaPrzystosowania f = new FunkcjaPrzystosowania();
//		KoloRuletki kolo = new KoloRuletki();
//		MetodyGenetyczne mg = new MetodyGenetyczne();
//		
//		p.utworzenieFenotypu(2047, 11);
////		System.out.println(p.getFenotyp().size());
//		
//		p.inicjacjaPopulacji(p.getFenotyp(), 10);
////		
////		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getFirst(), 0.5, 2.0));
////		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getLast(), 0.5, 2.0));
//		
////		System.out.println(Arrays.toString(p.getFenotyp().getFirst()));
////		
//		p.ocenaPrzystosowaniaChromosomu(p.getPopulacja());
//		
//		kolo.prawdopodobienstwoWyboru(p.getPopulacjaPoOceniePrzystosowania());
//		
//		kolo.losowanieOsobnikowKolaRuletki(kolo.getKoloRuletki());
//		
//		System.out.println("INPUT SIZE: " + kolo.getWylosowaneOsobniki().size());
//		
//		mg.ustawienieParametrow(75, 20, 5, kolo.getWylosowaneOsobniki());
//
////		for(Object[] row: kolo.getWylosowaneOsobniki()){
////			System.out.println(Arrays.toString(row));
////		}
////		System.out.println(kolo.getSredniaWartoscPrzystosowaniaRodzicow());
////		
////		
////		for(Object[] row: kolo.getKoloRuletki()){
////			System.out.println(Arrays.toString(row));
////		}
//		
////		kolo.prawdopodobienstwoWyboru(p.getPopulacjaPoOceniePrzystosowania());
//		
//		
////		for(Integer[] row: p.getPopulacja()){
////			System.out.println(Arrays.toString(row));
////		}
//		//
//		//System.out.println(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
//		//
//		//f.wyznaczenie_wartoœci_funckji_przystosowania(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
//		//System.out.println("Wartoœæ Funkcji dla Punktu " + p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0) + " wynosi: " + f.getWartoscFunckji());
//
////		p.inicjacja(p.getPopulacja(), 10);
////		System.out.println("Wielkoœæ Zainicjalizowanej Populacji: " + p.getZainicjowanaPopulacja().size());
////		for(Integer[] row: p.getZainicjowanaPopulacja()){
////			System.out.println(Arrays.toString(row));
//		}
	}

}
