import java.util.*;
import java.io.*;

public class CarFueling {
	
    static int computeMinRefills(int dist, int tank, int[] stops) {
		
		ArrayList<Integer> refills = new ArrayList<Integer>();
		refills.add(0);
		
		int remaining = tank;
		
		if(dist <= tank)
			return 0;
		
		for(int i = 1; i < (stops.length) ; i++){
			if(remaining < (stops[i] - stops[i-1])){
				return -1;
			}
			else{
				remaining -= (stops[i] - stops[i-1]);
			}
			
			if (i != stops.length-1){
				if(remaining < (stops[i+1] - stops[i])){
					refills.add(stops[i]);
					remaining = tank;
				}
			}
		}
		
        return refills.size()-1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
		stops[0] = 0;
        for (int i = 1; i < n+1; i++) {
            stops[i] = scanner.nextInt();
        }
		stops[n+1] = dist;

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
