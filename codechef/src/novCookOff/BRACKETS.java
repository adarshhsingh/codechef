package novCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BRACKETS {
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
		String inp;
		char a[];
		int bal=0;
		int maxB=0;
		while( t-->0 ) {
		
			bal=0;
			maxB=0;
			inp = br.readLine();
			a=inp.toCharArray();
			for(int i=0;i<inp.length();i++)
			{
				if(a[i]=='(') bal++;
				else bal--;
				maxB = (maxB<bal)?bal:maxB;
			}
			char[] open = new char[maxB];
			char[] close = new char[maxB];
			
			Arrays.fill(open, '(');
			Arrays.fill(close, ')');
			String openR = new String(open);
			String closeR = new String(close);
			
			pw.println(openR+closeR);
		}
	}
}
