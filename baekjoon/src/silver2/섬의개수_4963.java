package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 섬의개수_4963 {
	static class idx {
		int r , c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if(r == 0 && c == 0 ) break;
			
			int ans = 0;
			
			int[][] map = new int[r][c];
			boolean[][] visited = new boolean[r][c];
			Stack<idx> stack = new Stack<>();
			List<idx> list = new ArrayList<>();
			
			for(int i = 0 ; i < r ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j< c ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						list.add(new idx(i, j));
					}
				}
			}
			
			for(int i = 0 ; i< list.size() ; i++) {
				if(!visited[list.get(i).r][list.get(i).c]) {
					stack.push(list.get(i));
					
					while(!stack.isEmpty()) {
						idx cur = stack.pop();
						
						if(visited[cur.r][cur.c]) continue;
						visited[cur.r][cur.c] = true;
						
						int[] dr = {-1 , -1 , 0 , 1 , 1, 1 , 0 , -1};
						int[] dc = {0  ,  1 , 1 , 1 , 0 ,-1,-1 , -1};
						
						for(int j = 0 ; j< 8 ; j++) {
							int nr = cur.r + dr[j];
							int nc = cur.c + dc[j];
							
							if(nr >=0 && nr < r && nc >= 0 && nc < c ) {
								if(map[nr][nc] == 1 && !visited[nr][nc]) { // 이어진 땅이 있는 경우
									stack.push(new idx(nr, nc));
								}
							}
						}
					}
					ans++;
				}
			}
			
			System.out.println(ans);
		}
	}
}
