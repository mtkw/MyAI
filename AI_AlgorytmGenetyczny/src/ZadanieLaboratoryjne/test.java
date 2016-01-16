package ZadanieLaboratoryjne;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Populacja p = new Populacja();
		
		p.utworzeniePopulacji(5, 11);
		
		
		for(Integer[] row: p.getPopulacja()){
			System.out.println(Arrays.toString(row));
		}


	}

}
