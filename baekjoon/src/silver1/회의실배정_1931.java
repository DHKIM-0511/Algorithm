package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
	static class meet implements Comparable<meet>{
		int s,e;

		public meet(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(meet o) {
			if(this.e - o.e != 0) return this.e - o.e; //끝나는 시간이 빠른것 -> 시작시간이 빠른것
			else return this.s - o.s;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<meet> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.add(new meet(s, e));
		}
		int cnt = 0;
		int now = 0;
		while(!pq.isEmpty()) {
			meet cur = pq.poll();
			
			if(cur.s < now) continue;
			
			now = cur.e;
			cnt++;
		}
		System.out.println(cnt);
	}
}
