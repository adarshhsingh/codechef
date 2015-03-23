package novCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class pair {
	int num;
	char alp;

}
public class PETERSEN {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static Map <Integer , List<Integer>> AdjacencyList ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	  public static void addEdge(int source , int destination)  {
		
		  List<Integer> slist = AdjacencyList.get(source);
		  slist.add(destination);
		 // AdjacencyList.put(source,slist);
	}
	  
	private static void compute()throws IOException {
	
		int  t = Integer.parseInt(br.readLine());
		char a[];
		StringBuilder path1 = new StringBuilder();
		StringBuilder path2 = new StringBuilder();

		String alp = "ABCDEABCDE";
		String connect[]={"1,4,5","0,6,2","1,7,3","2,8,4","3,9,0","0,7,8","1,8,9","2,5,9","3,5,6","4,6,7"};
		
		
		while(t-- > 0) {
			
			a = br.readLine().toCharArray();
			
			boolean p1 = true;
			boolean p2 = true;
			char cur;
			int prev1 = alp.indexOf(a[0]);
			int prev2 = alp.lastIndexOf(a[0]);
			path1.append(prev1);
			path2.append(prev2);
			int i = 1;
			int x,y;
			while((p1 || p2) && i<a.length) {
				
				cur = a[i];
				
				if( p1 ) {
					x = alp.indexOf(cur);
					y = alp.lastIndexOf(cur);
					if(connect[prev1].contains(x+"")) {
						path1.append(x);
						prev1 = x;
					}
					else if(connect[prev1].contains(y+"")) {
						path1.append(y);
						prev1 = y;
					}
					else {
						p1 = false;
					}
				}
				
				if( p2 ) {
					x = alp.indexOf(cur);
					y = alp.lastIndexOf(cur);
					if(connect[prev2].contains(x+"")) {
						path2.append(x);
						prev2 = x;
					}
					else if(connect[prev2].contains(y+"")) {
						path2.append(y);
						prev2 = y;
					}
					else {
						p2 = false;
					}
				}
				
				++i;
			}
			
			if( !p1 && !p2) {
				pw.println(-1);
			} else if( p1 ) {
				pw.println((path1.toString()));
			} else {
				pw.println(path2.toString());
			}
			
			path1.delete(0, path1.length());
			path2.delete(0, path2.length());
		}
	}
}
