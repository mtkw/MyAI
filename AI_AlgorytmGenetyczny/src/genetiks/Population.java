package genetiks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;

public class Population {

	List<Integer[]> population = new ArrayList<>();
	private Map<Integer[], Integer> bitAndIntPopulation = new HashMap<Integer[], Integer>();

	public List<Integer[]> createPopulation(List<Integer[]> fenotyp, int popSize) {

		for (int i = 0; i < popSize; i++) {
			Random r = new Random();
			int position = r.nextInt(fenotyp.size() - 1);
			population.add(fenotyp.get(position));
		}

		return population;
	}

	public Map<Integer[], Integer> decodeBitReprezentation(List<Integer[]> population) {
		for (Integer[] person : population) {
			int pot = population.get(0).length - 1;
			int intValue = 0;
			for (int i = 0; i < person.length; i++) {
				intValue += (int) (person[i] * Math.pow(2, pot));
				pot--;
			}
			System.out.println("Bite Representation and int Value : " + Arrays.toString(person) + " : " + intValue);
			bitAndIntPopulation.put(person, intValue);
		}

		return bitAndIntPopulation;
	}

	//Próba pobrania klucza z podanej wartoœci
	public Integer[] getKey(Integer value){
	    for(Integer[] key : bitAndIntPopulation.keySet()){
	        if(bitAndIntPopulation.get(key).equals(value)){
	            return key; //return the first found
	        }
	    }
	    return null;
	}

	public List<Integer[]> getPopulation() {
		return population;
	}

	public void setPopulation(List<Integer[]> population) {
		this.population = population;
	}

	public Map<Integer[], Integer> getBitAndIntPopulation() {
		return bitAndIntPopulation;
	}

	public void setBitAndIntPopulation(Map<Integer[], Integer> bitAndIntPopulation) {
		this.bitAndIntPopulation = bitAndIntPopulation;
	}

}
