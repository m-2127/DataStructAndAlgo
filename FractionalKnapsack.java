import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class FractionalKnapsack {
    private static double getOptimalValue(double capacity, double[] values, double[] weights) {
        //write your code here
		
		//double value, weight, currentValue, currentWeight;
		//double[] unitValues = new double[n];
		
		DecimalFormat df_obj = new DecimalFormat("#.####");
		
        /*for (int i = 0; i < (values.length-1); i++) {
            currentValue = values[i+1];
            currentWeight = weights[i+1];
			value = values[i];
			weight = weights[i];
			
			for(int j = i+1; i > 0 ; i--){
				if ((currentValue/currentWeight) < (value/weight)){
					double tmpValue = values[i]; 
					double tmpWeight = weights[i];
					values[i] = values[i+1];
					weights[i] = weights[i+1];
					values[i+1] = tmpValue;
					weights[i+1] = tmpWeight;
				}
			}
			//unitValues[i] = df_obj.format(value/weight);
        }*/
		
		//Arrays.sort(unitValues, Collections.reverseOrder());
		double remainingCapacity = capacity;
		double finalValue = 0.0000;
		
		for (int i = values.length-1; i >= 0; i--) {
			
			if(remainingCapacity < weights[i]){
				finalValue += Double.parseDouble(df_obj.format((values[i]/weights[i])*remainingCapacity));
				return finalValue;
			}
			else{
				finalValue += Double.parseDouble(df_obj.format((values[i]/weights[i])*weights[i]));
				remainingCapacity -= weights[i];
			}
        }

        return finalValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = (double)scanner.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];
		double value, weight, currentValue, currentWeight;
		
        for (int i = 0; i < n; i++) {
            values[i] = (double)scanner.nextInt();
            weights[i] = (double)scanner.nextInt();
			
			if(i==0){
				continue;
			}
			
			currentValue = values[i];
            currentWeight = weights[i];
			value = values[i-1];
			weight = weights[i-1];
			
			for(int j = i; i > 0 ; i--){
				if ((currentValue/currentWeight) < (value/weight)){
					double tmpValue = values[i]; 
					double tmpWeight = weights[i];
					values[i] = values[i-1];
					weights[i] = weights[i-1];
					values[i-1] = tmpValue;
					weights[i-1] = tmpWeight;
				}
			}
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
