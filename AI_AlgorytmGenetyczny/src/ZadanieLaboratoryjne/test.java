package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Populacja p = new Populacja();
		FunkcjaPrzystosowania f = new FunkcjaPrzystosowania();
		KoloRuletki kolo = new KoloRuletki();
		
		p.utworzenieFenotypu(2047, 11);
//		System.out.println(p.getFenotyp().size());
		
		p.inicjacjaPopulacji(p.getFenotyp(), 10);
//		
//		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getFirst(), 0.5, 2.0));
//		System.out.println(p.dekodowanieChromosomu(p.getFenotyp().getLast(), 0.5, 2.0));
		
//		System.out.println(Arrays.toString(p.getFenotyp().getFirst()));
//		
		p.ocenaPrzystosowaniaChromosomu(p.getPopulacja());
		
		kolo.prawdopodobienstwoWyboru(p.getPopulacjaPoOceniePrzystosowania());
		
//		
//		
		for(Object[] row: kolo.getKoloRuletki()){
			System.out.println(Arrays.toString(row));
		}
		
//		kolo.prawdopodobienstwoWyboru(p.getPopulacjaPoOceniePrzystosowania());
		
		
//		for(Integer[] row: p.getPopulacja()){
//			System.out.println(Arrays.toString(row));
//		}
		//
		//System.out.println(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		//
		//f.wyznaczenie_warto�ci_funckji_przystosowania(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		//System.out.println("Warto�� Funkcji dla Punktu " + p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0) + " wynosi: " + f.getWartoscFunckji());

//		p.inicjacja(p.getPopulacja(), 10);
//		System.out.println("Wielko�� Zainicjalizowanej Populacji: " + p.getZainicjowanaPopulacja().size());
//		for(Integer[] row: p.getZainicjowanaPopulacja()){
//			System.out.println(Arrays.toString(row));
//		}
	}

}
