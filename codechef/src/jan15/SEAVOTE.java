package jan15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SEAVOTE {
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
		int n , sumB, i, count, b;
		float diff, threshold;
		boolean flag = true;
		while( testcases-- > 0 )  {
			n = Integer.parseInt(br.readLine());
			inp = br.readLine().split(" ");
			i = 0;
			sumB = 0;
			count = 0;
			flag = true;
			while(i<n) {
				b = Integer.parseInt(inp[i]);
				if(b > 0) {count++; sumB+=b;}
				if(b > 100) {flag = false; break;}
				i++;
			}
			diff = sumB - 100;
			threshold = diff / count ; 
			if( sumB < 100 || threshold >= 1) flag = false;
			pw.println(flag?"YES":"NO");
		}
	}
}
