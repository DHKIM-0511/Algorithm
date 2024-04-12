package codetree;

import java.io.*;
import java.util.*;

public class 예술성 {
	static int n,ans;
	static int[][] map;
	static List<Group> groups = new ArrayList<>();
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int turn = 0 ; turn <= 3 ; turn++) {
			//예술 점수 구함
			groups.clear();
			setGroup();
			for(int i = 0 ; i <groups.size()-1 ; i ++) {
				for(int j = i+1 ; j < groups.size() ; j++) {
					ans += getPoint(i,j);
				}
			}
			

			if(turn == 3) break;
			//회전		
			int[][] newMap = rotate();
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = newMap[i][j];
				}
			}
		}
		System.out.println(ans);
		
	}
	static int[][] rotate() {
		//가운데 십자는 반시계방향으로 돌린다.
		int[][] newMap = new int[n][n];
		int r = n/2;
		int c = n/2;
		
		int[] newRow = new int[n];
		int[] newCol = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			newRow[i] = map[i][c];
			newCol[i] = map[r][i];
		}
		
		for(int i = 0 ; i < n ; i++) {
			newMap[r][i] = newRow[i];
			newMap[i][c] = newCol[n-i-1];
		}
		
		
		//나머지 주변 네모는 시계 방향으로 돌린다.
		int[][] tmp = new int[n/2][n/2];
		//좌상 복사
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				newMap[i][j] = tmp[(n/2)-j-1][i];
			}
		}
		
		//우상 복사
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				tmp[i][j] = map[i][j + (n/2)+1];
			}
		}
		
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				newMap[i][j + (n/2)+1] = tmp[(n/2)-j-1][i];
			}
		}
		
		//좌하 복사
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				tmp[i][j] = map[i + (n/2)+1][j];
			}
		}
		
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				newMap[i+ (n/2)+1][j] = tmp[(n/2)-j-1][i];
			}
		}
		
		//우하 복사
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				tmp[i][j] = map[i+ (n/2)+1][j+ (n/2)+1];
			}
		}
		
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n/2 ; j++) {
				newMap[i+ (n/2)+1][j+ (n/2)+1] = tmp[(n/2)-j-1][i];
			}
		}
		return newMap;
	}
	
	static void setGroup() {
		boolean[][] vis = new boolean[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				
				if(vis[i][j]) continue;
				// BFS로 그룹 생성 
				 Queue<Node> q = new LinkedList<>();
				 q.offer(new Node(i,j));
				 vis[i][j] = true;
				 
				 int t = map[i][j];
				 Group group = new Group();
				 while(!q.isEmpty()) {
					 Node cur = q.poll();
					 
					 group.l.add(cur);
					 
					 for(int k = 0 ;k < 4 ; k++) {
						 int nr = cur.r +dr[k];
						 int nc = cur.c +dc[k];
						 
						 if(OOB(nr,nc) || vis[nr][nc]) continue;
						 if(t != map[nr][nc]) continue;
						 
						 q.offer(new Node(nr,nc));
						 vis[nr][nc] = true;
					 }
				 }
				 groups.add(group);
			}
		}
		
	}
	static int getPoint(int a,int b) {
		// 예술 점수 = 모든 그룹쌍의 조화로움의 합, 조화로움 은 다음과 같다
		// (그룹 a에 속한 칸의 수 + 그룹 b에 속한 칸의 수 ) x 그룹 a를 이루고 있는 숫자 값 x 
		// 그룹 b를 이루고 있는 숫자 값 x 그룹 a와 그룹 b가 서로 맞닿아 있는 변의 수
		Group A = groups.get(a);
		Group B = groups.get(b);
		
		
		int edgeCnt = getEdgeCnt(A,B);
		if(edgeCnt == 0) return 0;
		
		int sum = A.l.size() + B.l.size();
		int aNum = map[A.l.get(0).r][A.l.get(0).c];
		int bNum = map[B.l.get(0).r][B.l.get(0).c];

		return sum * aNum * bNum * edgeCnt;
	}
	static int getEdgeCnt(Group A, Group B) {
		//두 그룹간 맞닿은 변의 수
		//조합을 통해 거리가 1인 노드쌍의 수를 구한다
		
		int cnt = 0;
		for(int i = 0 ; i < A.l.size() ; i++) {
			for(int j = 0 ; j < B.l.size() ; j++) {
				if(getDist(A.l.get(i), B.l.get(j)) == 1) cnt++;
			}
		}
		return cnt;
	}
	static int getDist(Node a, Node b) {
		return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
	}
	
	static boolean OOB(int r,int c) {
		return r < 0 || r >= n || c < 0 || c >= n;
	}
	static class Group{
		List<Node> l = new ArrayList<>();
	}
	
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r=r;
			this.c=c;
		}
	}

}
