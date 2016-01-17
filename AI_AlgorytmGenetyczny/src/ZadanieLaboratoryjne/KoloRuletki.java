package ZadanieLaboratoryjne;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class KoloRuletki {

	private LinkedList<Object[]> koloRuletki;
	private LinkedList<Object[]> wylosowaneOsobniki = new LinkedList<>();
	private Double suma = 0.0;

	/*
	 * Kolo ruletki zawiera Liste Obiektów Ka¿dy obiekt ma zakodowane 1.
	 * Chromosom w formie binarnej [11 pierwszych elementow] 2. Wartoœæ funkcji
	 * przystosowania dla danego chromosomu [12 element] 3. Prawdopodobienstwo
	 * wyboru danego chromosomu [13 element]
	 */
	public LinkedList<Object[]> prawdopodobienstwoWyboru(LinkedList<Object[]> ocenionaPopulacja) {
		koloRuletki = new LinkedList<>();

		sumaWartosciFunkcjiPrzystosowania(ocenionaPopulacja);
		BigDecimal wartoscPrawdopodobienstwa;
		Double prawdopodobienstwo = 0.0;
		Double start = 0.0;
		for (Object[] row : ocenionaPopulacja) {
			Object[] wektor = new Object[14];
			prawdopodobienstwo = ((Double) row[11] / suma) * 100;
			wartoscPrawdopodobienstwa = new BigDecimal(prawdopodobienstwo);
			BigDecimal dokladnosc = wartoscPrawdopodobienstwa.setScale(3, BigDecimal.ROUND_HALF_UP);
			for (int i = 0; i < row.length; i++) {
				wektor[i] = row[i];
			}
			// zakres kola nalezacy do kazdego chromosomu
			wektor[12] = start;
			wektor[13] = dokladnosc.doubleValue() + start;
			koloRuletki.add(wektor);

			start += dokladnosc.doubleValue();
		}

		return koloRuletki;
	}

	public LinkedList<Object[]> losowanieOsobnikowKolaRuletki(LinkedList<Object[]> koloRuletki) {
		for (int i = 0; i < koloRuletki.size(); i++) {
			Random r = new Random();
			double wylosowanaLiczba = r.nextInt(100);
			for(Object[] chromosom: koloRuletki){
				if(wylosowanaLiczba >= (double)chromosom[12] && wylosowanaLiczba <= (double)chromosom[13]){
					System.out.println("WYLOSOWANA LICZBA TO: " + wylosowanaLiczba);
					System.out.println(Arrays.toString(chromosom));
				}
			}
		}
		return wylosowaneOsobniki;
	}

	private Double sumaWartosciFunkcjiPrzystosowania(LinkedList<Object[]> ocenionaPopulacja) {
		for (Object[] wartoscFunkcjiPrzystosowania : ocenionaPopulacja) {
			suma += (Double) wartoscFunkcjiPrzystosowania[11];
		}
		return suma;
	}

	public LinkedList<Object[]> getKoloRuletki() {
		return koloRuletki;
	}

	public void setKoloRuletki(LinkedList<Object[]> koloRuletki) {
		this.koloRuletki = koloRuletki;
	}

}
