package jan15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ONEKING {
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
		int n,i;
		while(testcases-- > 0) {
			
			n  = Integer.parseInt(br.readLine());
			int king[][]=new int[n][2];
			boolean alive[] = new boolean[n];
			
			i=0;
			while(i<n) {
				inp = br.readLine().split(" ");
				king[i][0]= Integer.parseInt(inp[0]);
				king[i][1]= Integer.parseInt(inp[1]);
				alive[i]=true;
				i++;
			}
			Arrays.sort(king, new Comparator<int[]>() {
				@Override
				public int compare(int a[], int b[]) {
					return a[0]-b[0];
				}
			});
			
			Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
			for(i=0;i<2001;i++){
				map.put(i, new ArrayList<Integer>());
			}
			
			List<Integer> temp ;
			for( i=0;i<n;i++) {
				for(int x =king[i][0];x<=king[i][1];x++) {
					temp = map.get(x);
					temp.add(i);
				}	
			}
			
			List<Integer> max = new ArrayList<Integer>();
			List<Integer> m ;
			int bomb=0;
			// counting
			for( i=0;i<n;i++) {
				if(alive[i]) {
				    bomb++;
				    max.clear();
					for(int x =king[i][0];x<=king[i][1];x++) {
					    m = map.get(x);
					    if(m.size() > max.size()) { 
					    	max.clear();
					        max.addAll(m);
					    }
					}
					for (Iterator<Integer> iterator = max.iterator(); iterator.hasNext();) {
						Integer k = (Integer) iterator.next();
						alive[k] = false;
						for(int x = king[k][0];x<=king[k][1];x++) {
							map.get(x).remove(k);
						}
					}	
				}
			}
			pw.println(bomb);
			
			
		}
	}
}
