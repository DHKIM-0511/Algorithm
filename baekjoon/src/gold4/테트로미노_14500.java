package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
	static int N,M;
	static int[][]map;
	static class idx{
		int r,c;

		public idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				ans = Math.max(ans, getScore(new idx(i, j)));
			}
		}
		System.out.println(ans);
	}

	private static int getScore(idx cur) {
		int sum = 0;
		//1자 테트로미노
		if(M - cur.c >= 4) {
			int tmp = 0;
			for(int i = 0 ; i < 4 ; i++) {
				tmp += map[cur.r][cur.c+i];
			}
			sum = Math.max(sum, tmp);
		}
		if(N - cur.r >= 4) {
			int tmp = 0;
			for(int i = 0 ; i < 4 ; i++) {
				tmp += map[cur.r+i][cur.c];
			}
			sum = Math.max(sum, tmp);
		}
		
		//네모 테트로미노
		if(M - cur.c >= 2 && N - cur.r >= 2) {
			int tmp = 0;
			for(int i = 0 ; i < 2 ; i++) {
				for(int j = 0 ; j < 2 ; j++) {
					tmp += map[cur.r+i][cur.c+j];
				}
			}
			sum = Math.max(sum, tmp);
		}
			
		//ㄴ자 테트로미노
		if(M - cur.c >= 2 && N - cur.r >= 3) {
			int tmp = 0;
			for(int i = 0 ; i < 3 ; i++) {
				if( i == 2) {
					for(int j = 0 ; j < 1 ; j++) {
						tmp += map[cur.r+i][cur.c+j];
					}
				}
				else tmp += map[cur.r+i][cur.c];
			}
			sum = Math.max(sum, tmp);
		}
		
		//ㄱㄴ자 테트로미노
		if(M - cur.c >= 2 && N - cur.r >= 3) {
			int tmp = 0;
			for(int i = 0 ; i < 2 ; i++) {
				for(int j = 0 ; j < 2 ; j++) {
					tmp += map[cur.r+i][cur.c+j];
				}
			}
			sum = Math.max(sum, tmp);
		}
		//ㅜ자 테트로미노
		if(M - cur.c >= 3 && N - cur.r >= 2) {
			int tmp = 0;
			for(int i = 0 ; i < 2 ; i++) {
				for(int j = 0 ; j < 2 ; j++) {
					tmp += map[cur.r+i][cur.c+j];
				}
			}
			sum = Math.max(sum, tmp);
		}
		
		return sum;
	}
}
