package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Whoisinthemiddle_6840 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i< 3 ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		pq.poll();
		System.out.println(pq.poll());
	}
}
