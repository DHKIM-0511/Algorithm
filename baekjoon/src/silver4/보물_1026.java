package silver4;

import java.io.*;
import java.util.*;

public class 보물_1026 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< n ; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< n ; i++) B[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(B);
		
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			ans+= A[i] * B[n-i-1];
		}
		System.out.println(ans);
	}
}
