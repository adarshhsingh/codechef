package augChallenge14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
 
class CRAWA {
 
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		// TODO Auto-generated method stub
		int testcases = Integer.parseInt(br.readLine());
		int a[]={3,2,1};
		Arrays.sort(a,0,2);
		System.out.println(a[0]);
		String inp[];
		long x , y ;
		boolean flag ;
		while(testcases-->0)
		{
			inp=br.readLine().split(" ");
			x = Long.parseLong(inp[0]);
			y = Long.parseLong(inp[1]);
			flag=false;
			if(x==0 && y==0)flag=true;
			if(x>0 && x%2==1 && y>=-(x-1) && y<=(x+1) )flag=true;
			else if(x<0 && x%2==0 && y>=x && y<=-x )flag=true;
			else if(y>0 && y%2==0 && (x>=-y && x<=(y-1) ))flag=true;
			else if(y<0 && y%2==0 && (x>=y && x<=(-y+1) ))flag=true;
			System.out.println(flag?"YES":"NO");
		}
		
	}
}