import java.util.Scanner;
import java.util.HashMap;

public class Fibonacci {
	
  HashMap<Integer, Long> fibonacci = new HashMap<Integer, Long>();
	
  long calc_fib(int n) {
    if (n <= 1){
      return n;
	}
	else{
		
		if (fibonacci.get(n-1) == null)
			fibonacci.put(n-1, calc_fib(n - 1));
		
		if (fibonacci.get(n-2) == null)
			fibonacci.put(n-2, calc_fib(n - 2));
		
		return fibonacci.get(n-1) + fibonacci.get(n - 2);
	}
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
	
	Fibonacci fb = new Fibonacci();

    System.out.println(fb.calc_fib(n));
  }
}
