package augChallenge14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
 
class Solution {
 
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
        //int t=Integer.parseInt(br.readLine()); 
        String inp[];
        inp=br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int price = Integer.parseInt(inp[1]); 
        inp=br.readLine().split(" ");
        int pos[]=new int[n];
        for(int i=0;i<n;i++)pos[i]=Integer.parseInt(inp[i]);
        int cost=price;
        int d=0;
        int start=pos[0];
        int petrol=0;
        for(int i=0;i<n;i++)
        {
            d=pos[i]-start;
            if(d*d<=price) petrol=d*d; 
            else {cost+=(price+petrol);start=pos[i];petrol=0;}
        }
        cost+=petrol;
        pw.println(cost);
    }
}