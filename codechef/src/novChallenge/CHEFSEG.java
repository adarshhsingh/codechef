package novChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CHEFSEG {
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
		while( t-->0 ) {
		
			inp = br.readLine().split(" ");
			double x = Double.parseDouble(inp[0]);
			double k = Double.parseDouble(inp[1]);
			
			int base = (int)(Math.log(k)/Math.log(2));
			long k1 = (long) Math.pow(2, base);
			double a = (k-k1)*2 +1;
			double b = x;
			double c = Math.pow(2, base+1);
			double d = a*b/c;
			pw.printf("%.7f\n",d);
		}
	}
}
