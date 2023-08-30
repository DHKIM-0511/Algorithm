package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 차집합_1822 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int An = Integer.parseInt(st.nextToken()); 
		int Bn = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < An ; i++) A.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < Bn ; i++) { 
			int num = Integer.parseInt(st.nextToken());
			if(A.contains(num))A.remove(num);
		}
		
		System.out.println(A.size());
		for(int i : A) System.out.print(i+" ");
	}
}
