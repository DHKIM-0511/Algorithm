package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란치기_16987 {
	static int N,ans;
	static egg[] eggs;
	static class egg {
		int s,w;

		public egg(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new egg[N]; 
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			eggs[i] = new egg(S, W);
		}
		ans = Integer.MIN_VALUE;
		back(0,0);
		System.out.println(ans);
	}
	private static void back(int cur,  int sum) {
		//최근에든게 마지막꺼
		if(cur == N) {
			ans = Math.max(ans, sum);
			return;
		}
		//지금 든게 깨짐 or 다 깨짐
		if(eggs[cur].s <=0 || sum == N-1) {
			back(cur+1, sum);
			return;
		}
		int cnt = sum;
		for(int i = 0 ; i < N ; i++) {
			if(i == cur) continue;
			if(eggs[i].s <= 0 ) continue; // 타겟 깨짐
			
			eggs[cur].s -= eggs[i].w;
			eggs[i].s -= eggs[cur].w;
			
			if(eggs[i].s <=0) sum++;
			if(eggs[cur].s <=0) sum++;
			
			back(cur+1, sum);
				
			eggs[cur].s += eggs[i].w;
			eggs[i].s += eggs[cur].w;
			sum = cnt;
		}
	}
}	
