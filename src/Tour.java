import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    // Holds one tour of cities
    private ArrayList <City> tour = new ArrayList<>();
    // Cache
    private double fitness = 0;
    private int distance = 0;

    // Constructs an empty tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }

    public Tour(ArrayList<City> tour){
        this.tour = tour;
    }

    // Creates a random tour
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // mutation
        Collections.shuffle(tour);
    }


    public City getCity(int tourPosition) {
        return tour.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tour has been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }


    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    // Gets the total distance of the tour (loop through cities and sum up distance between them)
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;

            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {

                City fromCity = getCity(cityIndex);
                City destinationCity;
                // if we are on the last city of the tour set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the cities
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    public int tourSize() {
        return tour.size();
    }

    public boolean containsCity(City city){
        return tour.contains(city);
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}