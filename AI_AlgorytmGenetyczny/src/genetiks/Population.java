package genetiks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {

	List<int[]> population = new ArrayList<>();

	public List<int[]> createPopulation(List<int[]> fenotyp, int popSize) {

		for (int i = 0; i < popSize; i++) {
			Random r = new Random();
			int position = r.nextInt(fenotyp.size() - 1);
			population.add(fenotyp.get(position));
		}

		return population;
	}

	public List<int[]> getPopulation() {
		return population;
	}

	public void setPopulation(List<int[]> population) {
		this.population = population;
	}

}
