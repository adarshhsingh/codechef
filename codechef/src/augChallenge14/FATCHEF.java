package augChallenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FATCHEF {
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
		int n,m;
		char x;
		int y;
		long ans=1;
		long MOD=1000000009;
		long count=0;
		String inp[];
		while(t-->0) {
			ans=1;
			inp=br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			m = Integer.parseInt(inp[1]);
			char arr[]=new char[n];
			//System.out.println(arr[0]);
			for(int i=0;i<m;i++) {
				inp=br.readLine().split(" ");
				x = inp[0].charAt(0);
				y = Integer.parseInt(inp[1]);
				arr[y-1] = x;
			}
			char prev='\u0000';
			count=1;
			for(int i=0;i<n;i++) {				
				if(arr[i]=='\u0000'){
					count++;
					continue;
				}else if( prev!='\u0000' &&  arr[i]!=prev) {
					ans = (ans)*(count)%MOD;
				}
				count=1;
				prev=arr[i];	
			}
			pw.println(ans);
		}
	}
}
