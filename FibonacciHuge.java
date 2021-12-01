import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
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
					return list.get((int)(n % divisorLength));
				}
				else{
					list.add((list.get(list.size() - 2) + (list.get(list.size() - 1))) % m);
				}
			}
        }
		
		return list.get(list.size() - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
