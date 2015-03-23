package octChallenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PRLADDU {
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
		
		int n;
		long v, b ;
		int D[]=new int[100000];
		String inp[];
		while(t-->0) {
			v=0;
			b=0;
			n= Integer.parseInt(br.readLine());
			inp=br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				
				D[i]=Integer.parseInt(inp[i]);
				
				v = (long)v+D[i];
				b = b+Math.abs(v);
			}
			pw.println(b);
		}
	}
}