package silver1;

import java.io.*;
import java.util.*;

public class 절댓값힙_11286 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if(a == b) return o1-o2;
				else return a - b;
			}
		});
		
		for(int i = 0 ; i < n ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp != 0) {
				pq.add(tmp);
			}
			else {
				if(pq.size()>0) System.out.println(pq.poll());
				else System.out.println(0);
			}
		}
	}
}
