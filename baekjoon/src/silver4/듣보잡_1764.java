package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 듣보잡_1764 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < n ; i ++) {
			map.put(br.readLine(), 1);
		}
		
		for(int i = 0 ; i < m ; i++) {
			String tmp = br.readLine();
			if(map.containsKey(tmp)) pq.add(tmp);
		}
		int size = pq.size();
		System.out.println(size);
		
		for(int i = 0 ; i < size ; i++) {
			System.out.println(pq.poll());
		}
	}
}
