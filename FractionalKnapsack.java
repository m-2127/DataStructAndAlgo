import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class FractionalKnapsack {
    private static double getOptimalValue(double capacity, double[][] values, double[] weights) {
		
		DecimalFormat df_obj = new DecimalFormat("#.####");
		
		double remainingCapacity = capacity;
		double finalValue = 0.0000;
		
		for (int i = values.length-1; i >= 0; i--) {
			
			if(remainingCapacity < (values[i][1])){
				finalValue += Double.parseDouble(df_obj.format((values[i][0])*remainingCapacity));
				return finalValue;
			}
			else{
				finalValue += Double.parseDouble(df_obj.format((values[i][0])*(values[i][1])));
				remainingCapacity -= (values[i][1]);
			}
        }

        return finalValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = (double)scanner.nextInt();
        double[] values = new double[n];
		double[][] valuePerUnit = new double[n][2];
        double[] weights = new double[n];
		double tmpValue, tmpWeight, currentValue, currentWeight, x,y;
		
        for (int i = 0; i < n; i++) {
            tmpValue = (double)scanner.nextInt();
            tmpWeight = (double)scanner.nextInt();
			weights[i] = tmpWeight;
			
			double[] valAndWeight = new double[2];
			valAndWeight[0] = tmpValue/tmpWeight;
			valAndWeight[1] = tmpWeight;
			
			valuePerUnit[i] = valAndWeight;
        }
		
		//Arrays.sort(valuePerUnit);
		Arrays.sort(valuePerUnit, (a, b) -> Double.compare(a[0], b[0]));
		
		for (int i = 0; i < valuePerUnit.length; i++) {
  
            // accessing each element of array
            //x = valuePerUnit[i][0];
			//y = valuePerUnit[i][1];
            //System.out.print(x + " - " + y + " ");
        }
		//System.out.print("\n");
		
        System.out.println(getOptimalValue(capacity, valuePerUnit, weights));
    }
} 
