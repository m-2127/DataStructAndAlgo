import java.util.*;


public class Change {
	
	static int denominations = 0;
	
	static Stack<Integer> stack = new Stack<Integer>();
	
    private static int getChange(int m, int n) {
        //write your code here
		if((m%n) == 0){
			denominations += (m/n);
			return denominations;
		}
		
		denominations += (m/n);
		return getChange((m%n), stack.pop());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
		int coins[] = {1,5,10};
		
		for(int coin : coins){
			stack.push(coin);
		}

        System.out.println(getChange(m, stack.pop()));

    }
}

