package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Populacja p = new Populacja();
		
		p.utworzeniePopulacji(2, 11);
		
		
		for(Integer[] row: p.getPopulacja()){
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println(p.dekodowanieChromosomu(p.getPopulacja().get(2), 0.5, 2.0));


	}

}
