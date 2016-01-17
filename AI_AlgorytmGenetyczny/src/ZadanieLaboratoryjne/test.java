package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Populacja p = new Populacja();
		FunkcjaPrzystosowania f = new FunkcjaPrzystosowania();
		KoloRuletki kolo = new KoloRuletki();
		
		p.utworzenieFenotypu(2000, 11);
//		System.out.println(p.getFenotyp().size());
		
//		p.inicjacjaPopulacji(p.getFenotyp(), 100);
//		
		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getFirst(), 0.5, 2.0));
		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getLast(), 0.5, 2.0));
//		
//		p.ocenaPrzystosowaniaChromosomu(p.getPopulacja());
//		
//		
//		for(Object[] row: p.getPopulacjaPoOceniePrzystosowania()){
//			System.out.println(Arrays.toString(row));
//		}
//		
//		kolo.prawdopodobienstwoWyboru(p.getPopulacjaPoOceniePrzystosowania());
		
		
//		for(Integer[] row: p.getPopulacja()){
//			System.out.println(Arrays.toString(row));
//		}
		//
		//System.out.println(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		//
		//f.wyznaczenie_wartoœci_funckji_przystosowania(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		//System.out.println("Wartoœæ Funkcji dla Punktu " + p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0) + " wynosi: " + f.getWartoscFunckji());

//		p.inicjacja(p.getPopulacja(), 10);
//		System.out.println("Wielkoœæ Zainicjalizowanej Populacji: " + p.getZainicjowanaPopulacja().size());
//		for(Integer[] row: p.getZainicjowanaPopulacja()){
//			System.out.println(Arrays.toString(row));
//		}
	}

}
