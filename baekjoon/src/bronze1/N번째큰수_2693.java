package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2693 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
				
		for(int t = 1 ; t <= tc ;t ++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 10 ; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			pq.poll();
			pq.poll();
			System.out.println(pq.poll());
		}
		
	}
}
