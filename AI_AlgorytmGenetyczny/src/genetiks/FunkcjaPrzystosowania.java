package genetiks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FunkcjaPrzystosowania {
	
	private int value = 0;
	private int intValue = 0;

	public int f(int intValue) {

		value = (2 * intValue) + 1;

		return value;
	}

	//Nale¿y zmodyfikowaæ ¿eby metoda operowa³a na liœcie elementów!!!!
	public int bitToInt(int[] osobnik) {
		int pot = osobnik.length - 1;
		System.out.println(Arrays.toString(osobnik));
		for (int i = 0; i < osobnik.length; i++) {
			intValue += (int) (osobnik[i] * Math.pow(2, pot));
			pot--;
		}
		System.out.println(intValue);
		return intValue;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

}
