package genetiks;

import java.util.HashMap;
import java.util.List;

public class KoloRuletki {

	private int sumaWartosciKola = 0;
	private HashMap<Integer, Double> mapaKola = new HashMap<>();

	public HashMap<Integer, Double> utworzKoloRuletki(List<Integer> zdekodowanaLista, int sumaWartosciKola) {
		for (Integer row : zdekodowanaLista) {
			double powierzchniaKola = (sumaWartosciKola / row) * 100;
			mapaKola.put(row, powierzchniaKola);
		}
		return mapaKola;
	}

	public int obliczenieKola(List<Integer> zdekodowanaLista) {
		for (Integer row : zdekodowanaLista) {
			sumaWartosciKola += row;
		}
		return sumaWartosciKola;
	}

	public int getSumaWartosciKola() {
		return sumaWartosciKola;
	}

	public void setSumaWartosciKola(int sumaWartosciKola) {
		this.sumaWartosciKola = sumaWartosciKola;
	}

	public HashMap<Integer, Double> getMapaKola() {
		return mapaKola;
	}

	public void setMapaKola(HashMap<Integer, Double> mapaKola) {
		this.mapaKola = mapaKola;
	}

}
