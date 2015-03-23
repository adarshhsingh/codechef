package dec14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class XORSUB {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	private static int testcases ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute()throws IOException {
		testcases = Integer.parseInt(br.readLine());
		int n;
		int k;
		int l;
		int x;
		String[] inp;
		while( testcases-- > 0) {
			inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			k = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			int[][] a=new int[n+1][n+1];
			a[0][1] = k;
			for( int i=1; i < n+1; i++ ) {
				l = 1;
				
				for( int j=1; a[i-1][j]!=0; j++) {
					x =  xor(a[i-1][j],a[i][0]);
					if(x > a[i-1][j]) {
						a[i][l] = x;
						l++;
					}
					a[i][l] = a[i-1][j];
					l++;
				}
			}	
		}
	}

	private static int xor(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}
