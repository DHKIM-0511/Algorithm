package silver1;

import java.io.*;
import java.util.*;

public class 신입사원_1946 {
	static class person implements Comparable<person>{
		int doc , itv;

		public person(int doc, int itv) {
			super();
			this.doc = doc;
			this.itv = itv;
		}
		@Override
		public int compareTo(person o) {
			return this.doc - o.doc;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				
		int t = Integer.parseInt(br.readLine());
		for(int tc =1 ; tc <= t ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			List<person> list = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int itv = Integer.parseInt(st.nextToken());
				
				list.add(new person(doc, itv));
			}
			Collections.sort(list); //서류 오름차순
			
			int ans = 1; //서류 꼴등은 고려 안함
			int min = list.get(0).itv; 
			
			for(int i = 1 ; i < n ; i++) { // 서류 뒤에서 2등부터 고려
				if(list.get(i).itv < min) { 
					
					ans++;
					min=list.get(i).itv; // 이전까지 나온 최소값보다 작으면 통과
				}
			}
			
			System.out.println(ans);
		}
	}
}
