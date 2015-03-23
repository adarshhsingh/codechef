package novChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class DISCHAR {
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
		char arr[];
		int alphabet[]=new int[26];
		int ans;
		while( t-- > 0 ) {
			Arrays.fill(alphabet, 0);
			ans = 0;
			arr=br.readLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if(alphabet[arr[i]-'a']==0) {
					alphabet[arr[i]-'a']++;
					ans++;
				}
			}
			pw.println(ans);
		}
	}
}
