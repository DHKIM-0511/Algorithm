package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘_14226 {
	static int S,ans;
	static class emoticon{
		int dis,clip , sec;

		public emoticon(int dis, int clip, int sec) {
			super();
			this.dis = dis;
			this.clip = clip;
			this.sec = sec;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		ans = 0;
		boolean[][] visited = new boolean[1001][1001];
		
		Queue<emoticon> q = new LinkedList<>();
		q.add(new emoticon(1,0,0));
		visited[1][0]=true;
		
		
		while(!q.isEmpty()) {
			emoticon cur = q.poll();
			
			if(cur.dis == S) {
				ans = cur.sec;
				break;
			}
			//화면 복사
			if(!visited[cur.dis][cur.dis]) { 
			visited[cur.dis][cur.dis] = true;
			q.add(new emoticon(cur.dis, cur.dis, cur.sec+1));
			}
			//붙여넣기
			if(cur.clip > 0 && cur.dis+cur.clip < 1001 && !visited[cur.dis+cur.clip][cur.clip]) {
				visited[cur.dis+cur.clip][cur.clip] = true;
				q.add(new emoticon(cur.dis+cur.clip, cur.clip, cur.sec+1));
			}
			
			//삭제
			if(cur.dis > 0 && !visited[cur.dis-1][cur.clip]) {
				visited[cur.dis-1][cur.clip]=true;
				q.add(new emoticon(cur.dis-1, cur.clip, cur.sec+1));
			}
		}
		
		System.out.println(ans);
	}
}
