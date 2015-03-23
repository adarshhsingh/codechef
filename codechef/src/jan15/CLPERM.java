package jan15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CLPERM {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		int n , k;
		long ans;
		while(testcases-- > 0) {
			inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			k = Integer.parseInt(inp[1]);
			if(k==0){ pw.println(((getSum(0, n+1)+1)%2==0)?"Mom":"Chef"); continue;}
			int arr[]=new int[k];
			
			inp = br.readLine().split(" ");
			for( int i =0;i<inp.length;i++) arr[i] = Integer.parseInt(inp[i]);
			Arrays.sort(arr);
			ans = getMaxReachable(arr,n) + 1;
			//pw.print(ans+"-");
			pw.println((ans%2==0)?"Mom":"Chef");	
		}
	}

	private static long getMaxReachable(int[] k, int n) {
		long max = 0;
		int l = 0, r = 0;
		int i;
		long s;
		
		for(i=0; i<k.length; i++) {
			l = r;
			r = k[i];
			s = getSum(l,r);
			max += s;
			if(max<r) return max;
		}
		l = r;
		r = n+1;
		s = getSum(l,r);
		max += s;
		return max;
	}

	private static long getSum(long l, long r) {
		return (r*(r-1))/2 - (l*(l+1))/2;
	}
}
