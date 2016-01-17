package ZadanieLaboratoryjne;

import java.math.BigDecimal;

/*
 * f(x) = [e^x * sin(10 * PI * x) + 1] / x
 */
public class FunkcjaPrzystosowania {
	
	private Double wartoscFunckji;

	public Double wyznaczenie_wartoœci_funckji_przystosowania(Double punktPrzestrzeniPrzeszukiwan){
		
		BigDecimal wartosc;
		
		wartosc = new BigDecimal(((Math.pow(Math.E, punktPrzestrzeniPrzeszukiwan) * Math.sin(Math.toRadians(10 * Math.PI * punktPrzestrzeniPrzeszukiwan))) + 1) / punktPrzestrzeniPrzeszukiwan);
		BigDecimal dokladnosc = wartosc.setScale(3, BigDecimal.ROUND_HALF_UP);
		wartoscFunckji = dokladnosc.doubleValue();
		
		return wartoscFunckji;
	}

	public Double getWartoscFunckji() {
		return wartoscFunckji;
	}

	public void setWartoscFunckji(Double wartoscFunckji) {
		this.wartoscFunckji = wartoscFunckji;
	}
	
}
