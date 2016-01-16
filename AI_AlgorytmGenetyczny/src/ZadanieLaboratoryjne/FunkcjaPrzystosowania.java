package ZadanieLaboratoryjne;
/*
 * f(x) = [e^x * sin(10 * PI * x) + 1] / x
 */
public class FunkcjaPrzystosowania {
	
	private Double wartoscFunckji = 0.0;

	public Double wyznaczenie_wartoœci_funckji_przystosowania(Double punktPrzestrzeniPrzeszukiwan){
		
		wartoscFunckji = (((Math.pow(Math.E, punktPrzestrzeniPrzeszukiwan) * Math.sin(Math.toRadians(10 * Math.PI * punktPrzestrzeniPrzeszukiwan))) + 1) / punktPrzestrzeniPrzeszukiwan);
		
		return wartoscFunckji;
	}

	public Double getWartoscFunckji() {
		return wartoscFunckji;
	}

	public void setWartoscFunckji(Double wartoscFunckji) {
		this.wartoscFunckji = wartoscFunckji;
	}
	
}
