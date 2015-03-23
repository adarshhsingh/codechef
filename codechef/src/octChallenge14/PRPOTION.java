package octChallenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRPOTION {
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
		int r, g, b, m = 0;
		int mr = 0, mg=0, mb=0;
		int x = 0;
		String inp[];
		while(t-->0) {
		inp=br.readLine().split(" ");
		r=Integer.parseInt(inp[0]);
		g=Integer.parseInt(inp[1]);
		b=Integer.parseInt(inp[2]);
		m=Integer.parseInt(inp[3]);
		mr=mg=mb=0;
		x=0;
		inp=br.readLine().split(" ");
		for(int i=0;i<r;i++) {
			x=Integer.parseInt(inp[i]);
			mr = (x>mr)?x:mr;
		}
		inp=br.readLine().split(" ");
		for(int i=0;i<g;i++) {
			x=Integer.parseInt(inp[i]);
			mg = (x>mg)?x:mg;
		}
		inp=br.readLine().split(" ");
	    for(int i=0;i<b;i++) {
			x=Integer.parseInt(inp[i]);
			mb = (x>mb)?x:mb;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>( 3, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		q.add(mr);
		q.add(mg);
		q.add(mb);
		
		while(q.peek()!=0 && m!=0) {
			x=q.poll();
			x=x/2;
			q.add(x);
			m--;
		}
		pw.println(q.peek());
	}
	}
}
