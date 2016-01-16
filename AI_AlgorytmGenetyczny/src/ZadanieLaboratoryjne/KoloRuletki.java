package ZadanieLaboratoryjne;

import java.util.LinkedList;

public class KoloRuletki {
	
	private LinkedList<Object[]> koloRuletki;
	private Double suma = 0.0;
	
	/*
	 * Kolo ruletki zawiera Liste Obiektów 
	 * Ka¿dy obiekt ma zakodowane
	 * 1. Chromosom w formie binarnej [11 pierwszych elementow]
	 * 2. Wartoœæ funkcji przystosowania dla danego chromosomu [12 element]
	 * 3. Prawdopodobienstwo wyboru danego chromosomu [13 element]
	 */
	public LinkedList<Object[]> prawdopodobienstwoWyboru(LinkedList<Object[]> ocenionaPopulacja){
		koloRuletki = new LinkedList<>();
		
		sumaWartosciFunkcjiPrzystosowania(ocenionaPopulacja);
		
		Double prawdopodobienstwo = 0.0;
		for(Object[] row: ocenionaPopulacja){
			Object[] wektor = new Object[13];
			prawdopodobienstwo = ((Double)row[11] / suma) * 100;
			for(int i = 0; i < row.length; i++){
				wektor[i] = row[i];
			}
			wektor[12] = prawdopodobienstwo;
			koloRuletki.add(wektor);
		}
		
		return koloRuletki;
	}
	
	
	private Double sumaWartosciFunkcjiPrzystosowania(LinkedList<Object[]> ocenionaPopulacja){
		for(Object[] wartoscFunkcjiPrzystosowania: ocenionaPopulacja){
			suma += (Double)wartoscFunkcjiPrzystosowania[11];
		}
		return suma;
	}

}
