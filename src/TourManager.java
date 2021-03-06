import java.util.ArrayList;

public class TourManager {

    // List of cities without any connections
    private static ArrayList<City> destinationCities = new ArrayList<>();


    public static void addCity(City city) {
        destinationCities.add(city);
    }


    public static City getCity(int index){
        return destinationCities.get(index);
    }


    public static int numberOfCities(){
        return destinationCities.size();
    }
}