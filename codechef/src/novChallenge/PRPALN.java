package novChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PRPALN {
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
		while( t-- > 0) {
			arr = br.readLine().toCharArray();
			int l=0, r=arr.length-1;
			boolean flag = true;
			
			while(l<r) {
				if(arr[l]==arr[r]) {
					l++;r--;
				} else {
					flag=false;
					break;
				}
			}
			if( flag == false )
				flag = checkPalin(l+1,r,arr) || checkPalin(l,r-1,arr);
			
			pw.println((flag)?"YES":"NO");
		}
	}

	private static boolean checkPalin(int l, int r, char[] arr) {
		while(l<r) {
			if(arr[l]==arr[r]) {
				l++;r--;
			} else
				return false;
		}
		return true;
	}
}
