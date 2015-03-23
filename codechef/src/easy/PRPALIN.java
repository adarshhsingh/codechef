package easy;
/*
An integer is said to be a palindrome if it is equal to its
reverse. For example, 79197 and 324423 are palindromes. In this task
you will be given an integer N, 1 ≤ N ≤ 1000000. You must find
the smallest integer M ≥ N such that M is a prime number and M is a
palindrome.
For example, if N is 31 then the answer is 101.
Input

A single integer N, (1 ≤ N ≤ 1000000), on a single line.
Output

Your output must consist of a single integer, the smallest prime
palindrome greater than or equal to N.
Example

Input:
31
Output:
101
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
public class PRPALIN {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute()throws IOException {
	
		int arr[]=new int[1003002];
		boolean prime[]=new boolean[1003002];
		Arrays.fill(prime, true);
		prime[1]=false;
		int i,j;
		
		 //get all prime set
		for( i=2;i*i<1003002;i++) {
			if(prime[i]) {
				for(j=i*2;j<1003002;j=j+i) {
					prime[j]=false;
				}
			}
		}
		
		int prevPrimePalin = 1003001;
		for (j = 1000000; j >=1 ; j--) {
			if(prime[j] && isPalin(j)) {
				prevPrimePalin=j;
			}
			arr[j]=prevPrimePalin;
		}
		
		i = Integer.parseInt(br.readLine());
		pw.println(arr[i]);
	}

	private static boolean isPalin(int j) {
		String a = ""+j;
		StringBuffer sb = new StringBuffer(""+j);
		sb.reverse();
		String b = sb.toString();
		return a.equals(b);
	}
}
