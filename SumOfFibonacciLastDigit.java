import java.util.*;

public class SumOfFibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(long n) {
        if (n <= 1)
            return (int)n;

        int previous = 0;
        int current  = 1;
		int sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            int tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current;
			sum = (sum + current) % 10;
        }

        return sum;
    }
		
	private static long getFibonacciLastDigit(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
		long divisorLength = 1;
		
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(0L);
		list.add(1L);

        for (long i = 0; i < n - 1; ++i) {
			
			if (i < 2){
				long tmp_previous = previous;
				previous = current;
				current = tmp_previous + current; // i + 2 th fibonacci number
			
				list.add(current % m);
			}
            else{
				if((list.get(list.size() - 2) == 0) && (list.get(list.size() - 1) == 1)){
					divisorLength = list.size() -2;
					
					long sum = 0;
					
					for (int k = 0; k < divisorLength + 1; k++){
						sum += list.get(k);
					}
					
					sum = sum % 10;
					sum *= (n/divisorLength);
					
					for (int j = (int)(n % divisorLength) ; j >= 0; j--){
						sum += list.get(j);
					}
					
					return sum%10;
				}
				else{
					list.add((list.get(list.size() - 2) + (list.get(list.size() - 1))) % m);
				}
			}
        }
		
		divisorLength = list.size();
					
		long sum = 0;
		
		for (int k = 0; k < divisorLength ; k++){
			sum = (sum % 10) + (list.get(k) % 10);
		}
		
		return sum%10;
	
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long c = getFibonacciLastDigit(n, 10);
        System.out.println(c);
    }
}

