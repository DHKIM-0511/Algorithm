package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 줄세우기_2605 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		
		for(int i = 1; i <= n ; i++) 
			list.add(i-Integer.parseInt(st.nextToken()),i);
		for(int i = 1 ; i <= n ; i++)
			System.out.print(list.get(i)+" ");
	}
}
//42531