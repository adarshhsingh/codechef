package novChallenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 class RBTREE {
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
		int q = Integer.parseInt(br.readLine());
		String inp[];
		String query;
		int x , y ;
		int ans = 0;
		boolean blackRoot = true;
		boolean evenBlack = true;
		while( q-->0 ) {
			//Input 
			inp = br.readLine().split(" ");
			query = inp[0];
			if("Qi".equals(inp[0])) {
				blackRoot = !blackRoot;		
			}
			else {
			
				if( "Qb".equals(inp[0])) {
			
					x = Integer.parseInt(inp[1]);
					y = Integer.parseInt(inp[2]);
					if( blackRoot == true )
						ans = countLevelNode(x,y,0);
					else 
						ans = countLevelNode(x,y,1);
				} else {
					x = Integer.parseInt(inp[1]);
					y = Integer.parseInt(inp[2]);
					if( blackRoot == true )
						ans = countLevelNode(x,y,1);
					else 
						ans = countLevelNode(x,y,0);
				}
				pw.println(ans);
				}
		}
		
	}
 
	private static int countLevelNode(int x, int y, int l) {
		int count = 0; boolean flag = true;
		if( x == y && (int)(Math.log(x)/Math.log(2))%2 == l) count++;
		int prevx =  0;
		int prevy = 0;
		while( x != y ) {
			if( (int)(Math.log(x)/Math.log(2))%2 == l && prevx!=x){
				count++;
				prevx = x;
			}
			if( (int)(Math.log(y)/Math.log(2))%2 == l && prevy !=y){
				count++;
				prevy = y;
			}
			flag = true;
			if( x > y ) { 
				x/=2;
			} else if( y > x ) {
				y/=2;
			}
			
		}
		if((int)(Math.log(x)/Math.log(2))%2 == l && !flag) count++;
		return count;		
	}
} 