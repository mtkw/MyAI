package ZadanieLaboratoryjne;

public class AlgorytmGenetyczny {

	private Populacja populacja = new Populacja();
	private FunkcjaPrzystosowania fn = new FunkcjaPrzystosowania();
	private KoloRuletki ruletka = new KoloRuletki();
	private MetodyGenetyczne metody = new MetodyGenetyczne();
	
	private int licznik_epok = 0;

	/*
	 * fenotyp_size -> wielkoœæ przesztrzeni przeszukiwania chromosom_size ->
	 * wielkoœæ pojedynczego osobnika iloœæ bitów go opisuj¹ca pop_size ->
	 * wielkoœæ populacji dla pojedynczej epoki
	 * pk -> prawdopodobienstow wyst¹pienia krzyzowania
	 * pr -> prawdopodobienstwo wyst¹pienia reprodukcji
	 * pm -> prawdopodobienstwo wystapienia mutacji
	 * liczba_epok -> liczba epok algorytmu genetycznego
	 *  
	 */
	public void algorytmGenetyczny(int fenotyp_size, int chromosom_size, int pop_size, int pk, int pr, int pm,
			int liczba_epok) {
		
		populacja.utworzenieFenotypu(fenotyp_size, chromosom_size);
		
		while(liczba_epok >= licznik_epok){
			
			//Podczas pierwszej iteracji zostanie zainicjowana nowa populacja 
			//Za ka¿dym kolejnym razem bedzie pobierana populacaja potomków powsta³a
			//Po wykonaniu metod genetycznych
			if(populacja.getPopulacja() == null){
//				System.out.println("Inicjacja Pocz¹tkowej Populacji");
				populacja.inicjacjaPopulacji(populacja.getFenotyp(), pop_size);
			}else{
//				System.out.println("Wybór Kolejnego Pokolenia " + populacja.getPopulacja().size());
				populacja.getPopulacja();
			}
			
			//Ocena przystosowania osobników
			populacja.ocenaPrzystosowaniaChromosomu(populacja.getPopulacja());
			
			//Selekcja osobników do dalszych procesów  i przydzielenie wycinków ko³a dla kazdego z nich
			ruletka.prawdopodobienstwoWyboru(populacja.getPopulacjaPoOceniePrzystosowania());
			ruletka.losowanieOsobnikowKolaRuletki(ruletka.getKoloRuletki());
			//System.out.println("AVG: " + ruletka.getSredniaWartoscPrzystosowaniaRodzicow());
			
			//Zastosowanie operatorów genetycznych
			metody.ustawienieParametrow(pk, pr, pm, ruletka.getWylosowaneOsobniki());
			
			//Ustawienie nowej populacji poczatkowej jako powsta³e potomstwo
			populacja.getPopulacja().clear();
			populacja.setPopulacja(metody.getPotomstwo());
			System.out.println(metody.getPotomstwo().size());
			
			licznik_epok++;
		}

	}
}
