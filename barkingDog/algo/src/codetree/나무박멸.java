package codetree;

import java.util.*;
import java.io.*;

public class 나무박멸 {
	static int n,m,k,c,ans;
	static int[][] map; // 0 = 빈칸,  1 ~ 100 = 나무 그루 수, -1 = 벽
	static int[][] impossible; // 제초제가 있는 칸
	static int[] dr = {-1,1,0,0,-1,-1,1,1} , dc= {0,0,-1,1,-1,1,1,-1}; //상하좌우 좌상 우상 우하 좌하
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		impossible = new int[n+1][n+1];
		
		for(int i =1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int year = 1 ; year<= m ; year++) {
			//성장
			//인접 4칸 중 나무가 있는 칸의 수 만큼 나무 성장 (동시)
			int[][] afterGrow = getNewMap(year);
			
			//나무의 번식 진행
			int[][] afterPropagation = propagateTrees(afterGrow,year);
			
			for(int i = 1; i<= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					map[i][j] = afterPropagation[i][j];
				}
			}
			System.out.println(year+"해의 번식 후===========");
			printMap();	
			//억제
			ans += vaccineApplcate(year);
			
		}
		
		//m년간 박멸한 총 나무 수
		System.out.println(ans);
	
	}
	//제초제 투하
	static int vaccineApplcate(int y) {
		Node target = new Node(-1, -1);
		int maxValue = 0;
		//백신 투하시 박멸될 나무 수와 위치 구하기
		for(int i  = 1; i<= n ; i++) {
			for(int j = 1; j <= n ;j++) {
				if(map[i][j] <= 0) continue; // 시작지점이 벽이거나 나무가 없으면 의미없다
				
				int cnt= map[i][j];
				
				List<Integer> tmp = new ArrayList<>();
				for(int v = 1 ; v <= k ; v++) {
					for(int d = 4 ; d < 8 ; d++) {
						if(tmp.contains(d)) continue;
						int nr = i + dr[d] * v;
						int nc = j + dc[d] * v;
						
						if(OOB(nr,nc) ) continue; // 벽이어도 의미 없다
						//빈칸이면 해당칸은 적용하고 퍼지지는 말아야함
						if(map[nr][nc] == 0 || map[nr][nc] == -1) { 
							tmp.add(d);
						}
						if(map[nr][nc] == -1) continue; 
 						cnt += map[nr][nc];
					}
				}
				if( cnt > maxValue) {
					maxValue = cnt;
					target = new Node(i, j);
				}
			}
		}
		if(target.r == -1) return 0;
		//백신 투하
		impossible[target.r][target.c] = y+c;
		map[target.r][target.c] = 0;
		
		List<Integer> tmp = new ArrayList<>();
		
		
		for(int v = 1 ; v <= k ; v++) {
			for(int d = 4 ; d < 8 ; d++) {
				if(tmp.contains(d)) continue;
				int nr = target.r + dr[d] * v;
				int nc = target.c + dc[d] * v;
				
				if(OOB(nr,nc) ) continue; // 벽이어도 의미 없다
				//빈칸이면 해당칸은 적용하고 퍼지지는 말아야함
				if(map[nr][nc] == 0 || map[nr][nc] == -1) { 
					tmp.add(d);
				}
				impossible[nr][nc] = y+c;
				if(map[nr][nc] != -1)map[nr][nc] = 0;
			}
		}
		
		System.out.println("백신 투하 직후 =========");
		printMap();
		return maxValue;
	}
	
	//나무의 번식
	static int[][] propagateTrees(int[][] trees, int y){
		int[][] newMap = new int[n+1][n+1];
		
		for(int i = 1; i<= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				newMap[i][j] = trees[i][j];
			}
		}
		
		System.out.println(y+"년의 제초제 기간");
		for(int i = 1; i<= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				System.out.print(impossible[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n ; j++) {
				if(trees[i][j] <= 0 || impossible[i][j] >= y) continue;
				
				//인접 4칸중 다른 나무, 벽, 제초제가 없을때 가능
				int cnt = 0;
				List<Node> list = new ArrayList<>();
				for(int k = 0 ; k < 4 ; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(OOB(nr,nc)) continue;
					if(trees[nr][nc] == 0 && impossible[nr][nc] < y) {
						cnt++;
						list.add(new Node(nr,nc));
					}
				}
				if(cnt == 0) continue;
				//해당 칸에 번식
				int v = (trees[i][j] / cnt);
				for(Node n : list) {
					newMap[n.r][n.c] += v;
				}
			}
		}
		
		return newMap;
	}
	
	//나무의 성장
	static int[][] getNewMap(int y){
		int[][] newMap = new int[n+1][n+1];
		
		for(int i =1 ; i <= n ; i++) {
			for(int j = 1; j <= n ; j++) {
				
				if(map[i][j] == -1) { // 벽 정보 저장
					newMap[i][j] = -1;
					continue;
				}
				if(map[i][j] == 0 || impossible[i][j] >= y) continue; // 빈칸, 제초제 스킵
				
				int cnt = 0;
				for(int k = 0 ; k < 4; k++) { // 인접 4칸의 나무가 있는 칸 카운팅
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(OOB(nr,nc) || map[nr][nc] <= 0 || impossible[i][j] >= y) continue;
					cnt++;
				}
				newMap[i][j] = map[i][j] + cnt;
			}
		}

		return newMap;
	}
	static void printMap () {
		for(int i = 1; i<= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
}
