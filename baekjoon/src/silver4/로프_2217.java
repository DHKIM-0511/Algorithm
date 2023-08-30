package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 로프_2217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i< n ; i++) pq.add(Integer.parseInt(br.readLine()));
		
		int max = Integer.MIN_VALUE;
		//오름차순으로 진행할때
		//i번째 로프를 사용한다고 하면 그 이후의 모든 로프를 사용하는게 최대값임
		//이를 부르트 포스로 구현
		for(int i = 0 ; i < n ; i++) max = Math.max(max, pq.poll()*(n-i));
		
		System.out.println(max);
	}
}
