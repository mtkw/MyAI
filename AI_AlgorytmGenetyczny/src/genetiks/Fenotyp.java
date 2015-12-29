package genetiks;

import java.util.ArrayList;
import java.util.List;

//Reprezentacja zbioru liczb z przedzia³u [0...31], którê satanowi¹ przestrzeñ poszukiwania zadania
//Liczby dziesiêtne musz¹ zostaæ zapisane w formie binarnej
//Najlepiej w postacie Tablicy 5 elementowej poniewa¿ ka¿da libcza bêdzie zapisana na 5 bitach

public class Fenotyp {

	private List<String> fenotypStringList = new ArrayList<>();
	private List<int[]> fenotypIntTab = new ArrayList<>();

	public List<String> createStringFenotyp(int start, int end) {

		for (int i = start; i <= end; i++) {
			String bit = Integer.toBinaryString(i);
			if (bit.length() < 5) {
				int size = bit.length();

				switch (size) {
				case 1:
					String add = "0000";
					String after = add.concat(bit);
					fenotypStringList.add(after);
					break;
				case 2:
					String add2 = "000";
					String after2 = add2.concat(bit);
					fenotypStringList.add(after2);
					break;
				case 3:
					String add3 = "00";
					String after3 = add3.concat(bit);
					fenotypStringList.add(after3);
					break;
				case 4:
					String add4 = "0";
					String after4 = add4.concat(bit);
					fenotypStringList.add(after4);
					break;
				}
			}
			else {
				fenotypStringList.add(bit);
			}
		}
		return fenotypStringList;
	}

	public List<int[]> convertStringToIntTab(List<String> fenotyp) {

		for (String str : fenotyp) {
			int[] bitTab = new int[5];

			for (int i = 0; i < str.length(); i++) {
				String subString = str.substring(i, i+1);
				bitTab[i] = Integer.parseInt(subString);
			}
			fenotypIntTab.add(bitTab);
		}

		return fenotypIntTab;
	}

	public List<String> getFenotypStringList() {
		return fenotypStringList;
	}

	public void setFenotypStringList(List<String> fenotypStringList) {
		this.fenotypStringList = fenotypStringList;
	}

	public List<int[]> getFenotypIntTab() {
		return fenotypIntTab;
	}

	public void setFenotypIntTab(List<int[]> fenotypIntTab) {
		this.fenotypIntTab = fenotypIntTab;
	}

}
