package ZadanieLaboratoryjne;

public class AlgorytmGenetyczny {

	private Populacja populacja = new Populacja();
	private FunkcjaPrzystosowania fn = new FunkcjaPrzystosowania();
	private KoloRuletki ruletka = new KoloRuletki();
	private MetodyGenetyczne metody = new MetodyGenetyczne();

	private int licznik_epok = 0;

	/*
	 * fenotyp_size -> wielko�� przesztrzeni przeszukiwania chromosom_size ->
	 * wielko�� pojedynczego osobnika ilo�� bit�w go opisuj�ca pop_size ->
	 * wielko�� populacji dla pojedynczej epoki pk -> prawdopodobienstow
	 * wyst�pienia krzyzowania pr -> prawdopodobienstwo wyst�pienia reprodukcji
	 * pm -> prawdopodobienstwo wystapienia mutacji liczba_epok -> liczba epok
	 * algorytmu genetycznego
	 * 
	 */
	public void algorytmGenetyczny(int fenotyp_size, int chromosom_size, int pop_size, int pk, int pr, int pm,
			int liczba_epok) {
		
		//Utworzenie zbioru przeszukiwa� danego problemu i okreslenie wielko�ci chromosomu 
		populacja.utworzenieFenotypu(fenotyp_size, chromosom_size);

		//G��wna p�tla algorytmu warunkiem stopu jest osi�gni�cie okre�lonej liczby epok
		while (liczba_epok >= licznik_epok) {

			// Podczas pierwszej iteracji zostanie zainicjowana nowa populacja
			// Za ka�dym kolejnym razem bedzie pobierana populacaja potomk�w
			// powsta�a po wykonaniu metod genetycznych
			if (populacja.getPopulacja() == null) {
				populacja.inicjacjaPopulacji(populacja.getFenotyp(), pop_size);
			} else {
				populacja.setPopulacja(metody.getPotomstwo());
			}

			// Ocena przystosowania osobnik�w
			populacja.ocenaPrzystosowaniaChromosomu(populacja.getPopulacja());

			// Selekcja osobnik�w do dalszych proces�w i przydzielenie wycink�w
			// ko�a dla kazdego z nich
			ruletka.prawdopodobienstwoWyboru(populacja.getPopulacjaPoOceniePrzystosowania());
			ruletka.losowanieOsobnikowKolaRuletki(ruletka.getKoloRuletki());			
			System.out.println(ruletka.getWylosowaneOsobniki().size());
			// Zastosowanie operator�w genetycznych
			metody.ustawienieParametrow(pk, pr, pm, ruletka.getWylosowaneOsobniki());
			
//			System.out.println(metody.getPotomstwo().size());

			// Ustawienie nowej populacji poczatkowej jako powsta�e potomstwo
			populacja.getPopulacja().clear();
			// populacja.setPopulacja(metody.getPotomstwo());

			licznik_epok++;
		}

	}
}
