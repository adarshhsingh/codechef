package octChallenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CHEFGR {
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
		int n,m;
		int max=0;
		int arr[]=new int[100];
		while(t-->0) {
			max=0;
			inp=br.readLine().split(" ");
			n=Integer.parseInt(inp[0]);
			m=Integer.parseInt(inp[1]);
			inp=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(inp[i]);
				max=(arr[i]>max)?arr[i]:max;
			}
			for(int i=0;i<n;i++){
				m-=max-arr[i];
			}
			if(m>0 && m%n==0)m=0;
			pw.println((m==0)?"Yes":"No");
		}
			
	}
 
}
