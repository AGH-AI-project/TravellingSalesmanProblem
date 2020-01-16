public class Population {

    // Holds population of tours
    Tour[] tours;

    public Population(int populationSize, boolean initialise) { //populationSize - amount of tours
        tours = new Tour[populationSize];
        // If we need to initialise a population of tours do so
        if (initialise) {
            // create tours
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }


    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }

    // Gets a single tour from population
    public Tour getTour(int index) {
        return tours[index];
    }

    // Gets the best tour in the population
    public Tour getFittest() {
        Tour fittest = tours[0];

        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return tours.length;
    }
}