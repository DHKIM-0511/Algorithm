package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0 ;
			
		PriorityQueue<Integer> list = new PriorityQueue<>();
		
		for(int i = 0 ; i < n ; i++)
			list.offer(Integer.parseInt(br.readLine()));
		
		while(list.size()!=1) {
			int a = list.poll();
			int b = list.poll();
			sum += a+b;
			list.offer(a+b);
		}
		System.out.println(sum);
		
	}
}
