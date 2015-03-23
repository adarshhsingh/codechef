package jan15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * Chef is playing a game. Currently in the game, he is at a 
 * field full of stones. There are total N kinds of
stones. There is unlimited supply of each kind of stone.
Chef knows that one stone of kind i needs Ai minutes to pick 
it from the ground and it will give Chef a profit of
Bi Rs.
Chef has K minutes of free time. During this free time, Chef
 want to pick stones so as to maximize his profit.
But he can not pick stones of different kinds, he has to pick
 stones of a single kind.
Please help Chef to find the maximal possible profit.
Input

First line contains single longeger T denoting the number of test cases.
First line of each test case contains two longegers N and K.
Next line contains N longegers Ai denoting the time needed to pick
 one stone of kind i.
Next line contains N longegers Bi denoting the profit due to picking
 ithth stone.
Output

For each test case, prlong a single line containing maximal possible
 profit.
Constralongs

1 ≤ T ≤ 5
1 ≤ N ≤ 105
1 ≤ K ≤ 109
1 ≤ Ai, Bi ≤ 109
Subtasks

Subtask N ≤ 5, T ≤ 2 Polongs: 30
Subtask N ≤ 105, T ≤ 5 Polongs: 70
Example

Input:
1
3 10
3 4 5
4 4 5

Output:
12
Explanation

If Chef picks stones of first kind he can pick 3 stones, he will
 get a profit of 3*4 = 12 Rs. 
If Chef picks stones of second kind he can pick 2 stones, he will
 get a profit of 2*4 = 8 Rs. 
If Chef picks stones of third kind he can pick 2 stones, he will
 get a profit of 2*5 = 10 Rs.
So the maximum possible profit is 12.
 */

public class CHEFSTON {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final Scanner sc = new Scanner(System.in);
	private static final PrintWriter pw = new PrintWriter(System.out);
    static long testcases;
    static String inp[];
    static String in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		testcases = Long.parseLong(br.readLine());
		boolean flag = false;
		long  k;
		int ans;
		
		while(testcases-- > 0) {
			inp = br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			k = Long.parseLong(inp[1]);
			long a[]=new long[n];
			long b[]=new long[n];
			inp = br.readLine().split(" ");
			for( int i=0; i<n; i++) {
				a[i]= Long.parseLong(inp[i]);
			}
			inp = br.readLine().split(" ");
			for( int i=0; i<n; i++) {
				b[i]= Long.parseLong(inp[i]);
			}
			ans = 0;
			for( int i=1; i<n; i++) {
				if((k/a[ans])*b[ans] < (k/a[i])*b[i]) ans = i;
			}
			pw.println((k/a[ans])*b[ans]);
		}
	}
}
