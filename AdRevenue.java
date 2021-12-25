import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class AdRevenue {
    private static long getOptimalRevenue(int[] revenue, int[] clicks) {
		
		long finalRevenue = 0;
		
		for (int i = revenue.length-1; i >= 0; i--)	
			finalRevenue += (long)revenue[i]*(long)clicks[i];

        return finalRevenue;
    }

    public static void main(String args[]) {
		
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] revenue = new int[n];
		int[] clicks = new int[n];
		
        for (int i = 0; i < n; i++) {
            revenue[i] = scanner.nextInt();
        }
		
		for (int i = 0; i < n; i++) {
            clicks[i] = scanner.nextInt();
        }
		
		Arrays.sort(revenue);
		Arrays.sort(clicks);
		
        System.out.println(getOptimalRevenue(revenue, clicks));
    }
} 
