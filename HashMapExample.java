import java.util.HashMap;

public class HashMapExample {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    private static HashMap<Integer, String> capitalCities = new HashMap<Integer, String>();

    // Add keys and values (Country, City)
    capitalCities.put(1, "London");
    capitalCities.put(2, "Berlin");
    capitalCities.put(3, "Oslo");
	capitalCities.put(4, "Washington");
    capitalCities.put(4, "Washington DC");
	
    System.out.println(capitalCities);
  }
}