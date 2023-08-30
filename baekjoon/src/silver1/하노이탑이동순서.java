package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 하노이탑이동순서 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println((int)Math.pow(2, n)-1);
		
		hanoi(n , 1 , 3);
		System.out.println(sb);
	}
	private static void hanoi (int n , int from , int to) {
		
		int mid = 6-from-to;
		
		if(n==1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		if(n>=2) {
			hanoi(n-1, from , mid);
			hanoi(1, from , to);
			hanoi(n-1, mid , to);
		}
	}
}
