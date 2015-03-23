package novChallenge;



/*
 * Chef has recently learnt Function and Addition. He is too exited to teach this to his friend Churu. 
 * Chef and Churu are very fast friends, they share their knowledge whenever they meet. 
 * Chef use to give a lot of exercises after he teaches some concept to Churu.
 * Chef has an array of N numbers. He also has N functions. Each function will return the sum of all numbers in the array from Li to Ri. 
 * So Chef asks churu a lot of queries which are of two types.
 * Type 1: Change the xth element of the array to y. 
 * Type 2: Return the sum of all functions from m to n.

Now Churu has started to solve, but Chef realize that it is tough for him to decide whether Churu is correct or not. So he needs your help , will you help him out ?
Input Format

First Line is the size of the array i.e. N 

Next Line contains N space separated numbers Ai denoting the array

Next N line follows denoting Li and Ri for each functions.

Next Line contains an integer Q , number of queries to follow.

Next Q line follows , each line containing a query of Type 1 or Type 2.

1 x y : denotes a type 1 query,where x and y are integers

2 m n : denotes a type 2 query where m and n are integers
Output Format

For each query of type 2 , output as asked above.
Constraints

1 ≤ N ≤ 105

1 ≤ Ai ≤ 109

1 ≤ Li ≤ N

Li ≤ Ri ≤ N

1 ≤ Q ≤ 105

1 ≤ x ≤ N

1 ≤ y ≤ 109

1 ≤ m ≤ N

m ≤ n ≤ N
Subtask

Subtask 1: N ≤ 1000 , Q ≤ 1000 , 10 points
Subtask 2: R-L ≤ 10 , all x will be distinct ,10 points
Subtask 3: Refer to constraints above , 80 points
Sample Input

5

1 2 3 4 5

1 3

2 5

4 5

3 5

1 2

4

2 1 4

1 3 7

2 1 4

2 3 5
Sample Output

41

53

28
Explanation

Functions values initially : 

F[1] = 1+ 2 + 3 = 6

F[2] = 2 + 3 + 4 + 5 = 14

F[3] = 4+5 = 9

F[4] = 3+4+5 = 12

F[5] = 1+2 = 3

Query 1: F[1] + F[2] + F[3] + F[4] = 41

After Update , the Functions are :

F[1] = 10 , F[2] = 18 , F[3] = 9 , F[4] = 16 , F[5] = 3

Query 3: F[1] + F[2] + F[3] + F[4] = 53

Query 4: F[3]+F[4]+F[5] = 28
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FNCS {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static Map <Integer , List<Integer>> AdjacencyList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	  public static void addEdge(int source , int destination)  {
		  if(source > AdjacencyList.size() || destination > AdjacencyList.size())  {
			  System.out.println("The vertex entered is not present");
			  return;
		  }
		  List<Integer> slist = AdjacencyList.get(source);
		  slist.add(destination);
	}
	  
	  public static List<Integer> outEdges(int source) {
			  List<Integer> slist = AdjacencyList.get(source);
			  return slist;
		}
	private static void compute()throws IOException {
	
		int n = Integer.parseInt(br.readLine());
		
		String inp[]=br.readLine().split(" ");
		long a[]=new long[n];
		long f[]=new long[n];
		int range[][]=new int[n][2];

		AdjacencyList = new HashMap<Integer, List<Integer>>();
		for( int i=0; i<n; i++) {
			a[i]=Integer.parseInt(inp[i]);
			AdjacencyList.put(i, new LinkedList<Integer>());
		}
		
		Stree segmentTree = new Stree(n);
		segmentTree.constructStree(a);
		for( int i=0; i<n; i++) {
			inp = br.readLine().split(" ");
			range[i][0]  = Integer.parseInt(inp[0])-1;
			range[i][1]  = Integer.parseInt(inp[1])-1;
			for(int j=range[i][0];j<=range[i][1];j++){
				addEdge(j, i);
			}
			f[i] = segmentTree.getSum(range[i][0], range[i][1]);
		}
	
		Stree segmentTreeF = new Stree(n);
		segmentTreeF.constructStree(f);
		int q = Integer.parseInt(br.readLine());
		int type;
		int x,y;
		while( q-- > 0) {
			inp=br.readLine().split(" ");
			type = Integer.parseInt(inp[0]);
			x = Integer.parseInt(inp[1]);
			y = Integer.parseInt(inp[2]);
			switch(type) {
			
			case 1:
				x--;
				long prev=a[x];
				segmentTree.update(y, x, a);
				List<Integer> list = outEdges(x);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Integer i = (Integer) iterator.next();
					long update = f[i]+(y-prev);
					segmentTreeF.update(update, i, f);
					
				}
				break;
			case 2: x--;y--;pw.println(segmentTreeF.getSum(x, y));
				break;
			}
		}
		
	}
}
class Stree {
	long[] tree;
	int maxsize;
	int height;
	
	final int START_INDEX=0;
	final int END_INDEX;
	final int ROOT=0;
	
	Stree(int size) {
		height = (int) Math.ceil((Math.log(size)/Math.log(2)));
		maxsize = 2 * (int)Math.pow(2, height);
		tree = new long[maxsize-1];
		END_INDEX = size - 1;
	}
	
	private int left(int p) { return (p*2)+1 ; }
	private int right(int p) { return (p*2)+2 ; }
	private int mid(int s, int e) { return (s+e)/2 ; }
	
	public void constructStree( long a[]) { constructStreeUtil(a, START_INDEX, END_INDEX, ROOT);}

	private long constructStreeUtil(long[] a, int startIndex,
			int endIndex, int current) {
		if( startIndex == endIndex) {
			tree[current] = a[startIndex];
			return tree[current];
		}
		int mid = mid(startIndex, endIndex);
		tree[current] = constructStreeUtil(a, startIndex, mid, left(current))
							+ constructStreeUtil(a, mid+1, endIndex, right(current));
		return tree[current];
	}
	
	public long getSum( int qStart, int qEnd) {
		if ( qStart<0 || qStart>tree.length) { return -1;}
		return getSumUtil(START_INDEX, END_INDEX, qStart, qEnd, ROOT);
	}

	private long getSumUtil(int startIndex, int endIndex, int qStart,
			int qEnd, int current) {
		
		if( qStart <= startIndex && qEnd >= endIndex ) { return tree[current]; }
		
		if( qStart > endIndex || qEnd < startIndex) { return 0; }
		
		int mid = mid(startIndex, endIndex);
		return getSumUtil(startIndex, mid, qStart, qEnd, left(current)) 
				 + getSumUtil(mid+1, endIndex, qStart, qEnd, right(current));				
	}
	
	public void update( long update, int updatePos , long arr[]) {
		long updateDiff = update - arr[updatePos];
		arr[updatePos] = update;
		updateUtil(START_INDEX, END_INDEX, updateDiff, updatePos, ROOT);
	}

	private void updateUtil(int startIndex, int endIndex, long updateDiff,
			int updatePos, int current) {
		
		if( updatePos < startIndex || updatePos > endIndex) return;
		
		tree[current] += updateDiff;
		
		if(startIndex != endIndex) {
			int mid = mid(startIndex, endIndex);
			updateUtil(startIndex, mid, updateDiff, updatePos, left(current));
			updateUtil(mid+1, endIndex, updateDiff, updatePos, right(current));
		}
	}
}/*
5
1 2 3 4 5
1 3
2 5
4 5
3 5
1 2
4
2 1 4
1 3 7
2 1 4
2 3 5*/