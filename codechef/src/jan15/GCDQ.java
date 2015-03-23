package jan15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class GCDQ {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final Scanner sc = new Scanner(System.in);
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
		int n , q , nc , qc , l , r;
		int i=0;
		while(testcases-- >0) {
		
			inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			int a[]=new int[n];
			q = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			i=0;
			while(i<n){
				a[i]= Integer.parseInt(inp[i]);
				i++;
			}
			GCDSegmentTree st = new GCDSegmentTree(a.length);
			st.constructSegmentTree(a);
			i =0 ;
			while( i < q) {
				i++;
				inp = br.readLine().split(" ");
				l = Integer.parseInt(inp[0]);
				r = Integer.parseInt(inp[1]);
				//pw.println(gcdUtilBRUTEFORCE(a, 0, n, l-1, r-1));
				
				pw.println(st.gcdBySkipingLtoR(l-1, r-1));
				
			}
		}
	
	
	}
	
static int gcd(int n , int m) {
	if(n%m==0)return m;
	else return gcd(m,n%m);
	}
static int gcdUtilBRUTEFORCE(int a[], int s, int n, int l, int r) {
	int hcf;
	int i=0;
	if(l == 0) {
		hcf = a[r+1];
	} else {
		hcf = a[0];
	}
	for( i=0;i<=l-1;i++) {
		if(hcf < a[i])
			hcf = gcd(a[i],hcf);
		else 
			hcf = gcd(hcf,a[i]);
	}
	for( i=r+1;i<=n-1;i++) {
		if(hcf < a[i])
			hcf = gcd(a[i],hcf);
		else 
			hcf = gcd(hcf,a[i]);
	}
	return hcf;
}
}

class GCDSegmentTree {
	int height;
	int size;
	int tree[];
	int maxsize;
	
	final int STARTINDEX = 0;
	final int ENDINDEX;
	final int ROOT = 0;
	
	GCDSegmentTree(int size) {
		this.size=size;
		height = (int)Math.ceil(Math.log(size)/Math.log(2));
		maxsize =(int)( 2 * Math.pow(2, height));
		tree = new int[maxsize];
		ENDINDEX = size-1;
	}
	
	public int gcdBySkipingLtoR(int l ,int r) {
		int l1 = getGCD(0,l-1);
		int r1 = getGCD(r+1,ENDINDEX);
		//System.out.println(l1+" "+r1);;
		return gcd(l1,r1);
	}
	
	public int getGCD(int queryStart , int queryEnd) {
		if( queryStart > ENDINDEX || queryEnd < STARTINDEX ) {
			return 0;
		}
		return getGCDUtil(STARTINDEX, ENDINDEX, queryStart, queryEnd, ROOT);
	}
	
	private int getGCDUtil(int startIndex, int endIndex, int queryStart,
			int queryEnd, int current) {

		
		if( startIndex >= queryStart && endIndex <= queryEnd) {
			return tree[current];
		}
		if( endIndex < queryStart || startIndex > queryEnd) {
			return 0;
		}
		
		int mid = (startIndex+endIndex)/2;
		return gcd(getGCDUtil(startIndex,mid,queryStart,queryEnd,current*2+1),getGCDUtil(mid+1,endIndex,queryStart,queryEnd,current*2+2));
	}

	public void constructSegmentTree(int[] a) {
		 constructSegmentTreeUtil(a,STARTINDEX,ENDINDEX,ROOT);
//		 for(int i=0;i<tree.length;i++) {
//			 System.out.print(tree[i]+ " , ");
//
//		 }
//		 System.out.println();
	}
	 
	int constructSegmentTreeUtil(int[] arr, int startIndex,
			int endIndex, int current) {
		if( startIndex == endIndex ){
			tree[current] = arr[startIndex];
			return tree[current];
		}
		
		int mid = (startIndex+endIndex)/2;
		tree[current] = gcd(constructSegmentTreeUtil(arr, startIndex, mid, current*2+1),constructSegmentTreeUtil(arr, mid+1, endIndex, current*2+2));
		return tree[current];
	}
	
	int gcd(int n , int m) {
		if(n<m) return gcd(m,n);
		if(m==0)return n;
		if(n%m==0)return m;
		else return gcd(m,n%m);
	}
}
