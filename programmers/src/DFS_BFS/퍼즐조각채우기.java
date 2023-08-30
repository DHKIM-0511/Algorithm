package DFS_BFS;

public class 퍼즐조각채우기 {
	public static void main(String[] args) {
		int[][] game_board= {
				{1,1,0,0,1,0},
				{0,0,1,0,1,0},
				{0,1,1,0,0,1},
				{1,1,0,1,1,1},
				{1,0,0,0,1,0},
				{0,1,1,1,0,0}};
		
		int[][] table = {
				{1,0,0,1,1,0},
				{1,0,1,0,1,0},
				{0,1,1,0,1,1},
				{0,0,1,0,0,0},
				{1,1,0,1,1,0},
				{0,1,0,0,0,0}};
		
		solution(game_board , table);
	}

	private static int solution(int[][] game_board, int[][] table) {
		int answer = -1;
		int n =table.length; // 행의 길이
		
        boolean[][] visited = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		if(table[i][j] == 1)
        			structure(new int[] {i,j});
        	}
        }
        
        
        return answer;
	}

	private static void structure(int[] start) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int i = 0 ; i < 4 ; i++) {
			int nr = start[0] + dr[i];
			int nc = start[1] + dc[i];
			
//			if()
		}
	}
}
