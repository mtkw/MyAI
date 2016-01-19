package ZadanieLaboratoryjne;

public class AlgorytmGenetyczny {

	private Populacja populacja = new Populacja();
	private FunkcjaPrzystosowania fn = new FunkcjaPrzystosowania();
	private KoloRuletki ruletka = new KoloRuletki();
	private MetodyGenetyczne metody = new MetodyGenetyczne();
	private Object[] najlepszy;

	private int licznik_epok = 0;

	/*
	 * fenotyp_size -> wielkoœæ przesztrzeni przeszukiwania chromosom_size ->
	 * wielkoœæ pojedynczego osobnika iloœæ bitów go opisuj¹ca pop_size ->
	 * wielkoœæ populacji dla pojedynczej epoki pk -> prawdopodobienstow
	 * wyst¹pienia krzyzowania pr -> prawdopodobienstwo wyst¹pienia reprodukcji
	 * pm -> prawdopodobienstwo wystapienia mutacji liczba_epok -> liczba epok
	 * algorytmu genetycznego
	 * 
	 */
	public void algorytmGenetyczny(int fenotyp_size, int chromosom_size, int pop_size, int pk, int pr, int pm,
			int liczba_epok) {

		// Utworzenie zbioru przeszukiwañ danego problemu i okreslenie wielkoœci
		// chromosomu
		populacja.utworzenieFenotypu(fenotyp_size, chromosom_size);

		// G³ówna pêtla algorytmu warunkiem stopu jest osi¹gniêcie okreœlonej
		// liczby epok
		while (liczba_epok >= licznik_epok) {

			// Podczas pierwszej iteracji zostanie zainicjowana nowa populacja
			// Za ka¿dym kolejnym razem bedzie pobierana populacaja potomków
			// powsta³a po wykonaniu metod genetycznych
			if (populacja.getPopulacja().isEmpty()) {
				populacja.inicjacjaPopulacji(populacja.getFenotyp(), pop_size);
//				System.out.println(populacja.getPopulacja().isEmpty());

			} else {
//				System.out.println("Ustawienie Potomstwa");
				populacja.setPopulacja(metody.getPotomstwo());
			}
//			 System.out.println("---------------------------------------------"+populacja.getPopulacja().size());

			// Ocena przystosowania osobników
			populacja.ocenaPrzystosowaniaChromosomu(populacja.getPopulacja());

			// Selekcja osobników do dalszych procesów i przydzielenie wycinków
			// ko³a dla kazdego z nich
			ruletka.prawdopodobienstwoWyboru(populacja.getPopulacjaPoOceniePrzystosowania());
//			System.out.println("WIELKOŒÆ POPULACJI W ALGORYTMIE: " + populacja.getPopulacja().size());
			ruletka.losowanieOsobnikowKolaRuletki(ruletka.getKoloRuletki());
			// System.out.println(ruletka.getWylosowaneOsobniki().size());
			// Zastosowanie operatorów genetycznych
			metody.ustawienieParametrow(pk, pr, pm, ruletka.getWylosowaneOsobniki());

			// System.out.println(metody.getPotomstwo().size());
//			metody.getPotomstwo().clear();
			// Ustawienie nowej populacji poczatkowej jako powsta³e potomstwo
//			populacja.getPopulacja().clear();
			// populacja.setPopulacja(metody.getPotomstwo());
			licznik_epok++;
			System.out.println(ruletka.getSuma());
//			System.out.println("--->");
		}

	}
}
