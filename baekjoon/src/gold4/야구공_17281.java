package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구공_17281 {
	static int N , ans , out = 0;
	static int[][] player;
	static int[] lineUp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 이닝 수
		player = new int[N][10];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1 ; j < 10 ; j++) player[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[10];
		lineUp = new int[10];
		
		lineUp[4] = 1; 
		visited[4] = true;
		
		setLineUp(2);
		
		System.out.println(ans);
	}
	private static void setLineUp(int player) {
		if(player == 10) {
    		int score = play();
    		ans = Math.max(ans, score);
    		return;
    	}
    	for(int i=1; i<=9; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			
    			lineUp[i] = player;
    			setLineUp(player + 1);
    			
    			visited[i] = false;
    		}
    	}
	}
	private static int play() {
		int sum = 0;
		
		//타자 순서
    	int idx = 1;
    	for(int i = 0; i <N ; i++) {
    		int inningScore = 0;
    		out = 0;
    		boolean[] base = new boolean[4];

    		while(out < 3) {
    			switch(player[i][lineUp[idx]]) {
		    		case 0:
		    			out++;
		    			break;
		    		case 1:
		    			inningScore += Single(base);
		    			break;
		    		case 2:
		    			inningScore += Double(base);
		    			break;
		    		case 3:
		    			inningScore += Triple(base);
		    			break;
		    		case 4:
		    			inningScore += HomeRun(base);
		    			break;
    			}
    			idx++;
    			if(idx >= 10) {
    				idx = 1;
    			}
    		}
    		sum += inningScore;
    	}
    	return sum;
	}
	private static int Single(boolean[] base) {
		int cnt = 0;
		if(base[2]) { 
			base[2] = false;
			cnt++;
		}
		if(base[1]) {
			base[1] = false;
			base[2] = true;
		}
		if(base[0]) {
			base[0] = false;
			base[1] = true;
		}
		base[0] = true;
		return cnt;
	}
	private static int Double(boolean[] base) {
		int cnt = 0;
		if(base[2]) { 
			base[2] = false;
			cnt++;
		}
		if(base[1]) {
			base[1] = false;
			cnt++;
		}
		if(base[0]) {
			base[0] = false;
			base[2] = true;
		}
		base[1] = true;
		return cnt;
	}
	private static int Triple(boolean[] base) {
		int cnt = 0;
		if(base[2]) { 
			base[2] = false;
			cnt++;
		}
		if(base[1]) {
			base[1] = false;
			cnt++;
		}
		if(base[0]) {
			base[0] = false;
			cnt++;
		}
		base[2] = true;
		return cnt;
	}
	private static int HomeRun(boolean[] base) {
		int cnt = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			if(base[i]) { 
				base[i] = false;
				cnt++;
			}
		}
		cnt++;
		return cnt;
	}
}
