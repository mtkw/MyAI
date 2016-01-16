package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Populacja p = new Populacja();
		FunkcjaPrzystosowania f = new FunkcjaPrzystosowania();
		
		p.utworzeniePopulacji(2, 11);
		
		
		for(Integer[] row: p.getPopulacja()){
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		
		f.wyznaczenie_wartoœci_funckji_przystosowania(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));
		System.out.println("Wartoœæ Funkcji dla Punktu " + p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0) + " wynosi: " + f.getWartoscFunckji());

	}

}
