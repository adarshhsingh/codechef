package novChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class POWERMUL {
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
		int t = Integer.parseInt(br.readLine());
		String inp[];
		int n, m, q, r, i;
		long ans;
		long arr[]=new long[100001];
		while( t-->0 ) {
		
			inp = br.readLine().split(" ");
			 n = Integer.parseInt(inp[0]);
			 m = Integer.parseInt(inp[1]);
			 q = Integer.parseInt(inp[2]);
			
			 for(i=0;i<100000;i++) {
				 arr[i]=fastExpo(i+1, i+1);
			 }
			 long f[]=new long[n+1];
			 f[1]=1;
			 i = 2;
			 while(i <= n) {
				 f[i] = f[i-1]*fastExpo(i,i);
				 ++i;
			 }
			 while( q-- > 0) {
				 r = Integer.parseInt(br.readLine());
				 ans = (f[n]/(f[r]*f[n-r]))%m;
				 pw.println(ans);
			}

			 
		}
	}

	private static long fastExpo(int n, int m) {
		long res = 1;
		while( m > 0){
			if( m%2 == 1 )res = (res * n);
			n = (n*n);
			m = m/2;
		}
		return res;
	}
}