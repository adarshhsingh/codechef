package dec14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CAPPLE {
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
		int num[]=new int[100001];
		String inp[];
		int len;
		int count;
		int x;
		while(testcases-- > 0 ) {
			br.readLine();
			inp = br.readLine().split(" ");
			len = inp.length;
			count = 0;
			Arrays.fill(num, 0);
			for (int i = 0; i < len; i++) {
				x = Integer.parseInt(inp[i]);
				if( num[x] == 0 ) {
					count++;
					num[x] = 1;
				}
			}
			pw.println(count);
		}
	}
}
