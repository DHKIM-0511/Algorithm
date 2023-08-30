package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {
	static int N, ans;
	static int[] input;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MIN_VALUE;
		find(0, new int[N]);
		System.out.println(ans);
	}
	private static void find(int cnt, int[] sel) {
		if(cnt == N) {
			int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(sel[i] - sel[i + 1]);
            }
            ans = Math.max(sum, ans);
		}else {
			for(int i = 0 ; i < N ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					sel[cnt] = input[i];
					find(cnt+1 , sel);
					visited[i] = false;
				}
			}
		}
	}
}
