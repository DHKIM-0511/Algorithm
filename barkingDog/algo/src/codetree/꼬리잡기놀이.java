package codetree;

import java.io.*;
import java.util.*;


public class 꼬리잡기놀이 {
	static int n,m,k,ans;
	static int[][] map;
	static HashMap<Integer, Team> teamInfo = new HashMap<>();
	static int[] dr = {0,-1,0,1}, dc= {1,0,-1,0}; // 우 상 좌 하
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
				
		map = new int[n+1][n+1];
		for(int i = 1; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//팀 나누기
		boolean[][] vis = new boolean[n+1][n+1];
		int tNum = 5;
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n ; j++) {
				if(vis[i][j]) continue;
				if(map[i][j] == 1)setTeam(i,j,vis,tNum++);
			}
		}
		
		//게임 진행
		for(int round = 0 ; round < k ; round++) { // dir 판단
			//1. 팀이동
			moveTeam();
			
			//2. 공을 던진다
			//반시계 방향으로 = //dir이 2,3 일때 역방향으로 진행함
			int num = throwBall(round);
			if(num == -1) continue; // 아무도 안맞음
			
			//3. 공을 획득한 팀은 방향을 바꾼다
			Team t = teamInfo.get(num);
			List<Node> tmp = new ArrayList<>();
			for(int i = t.list.size()-1 ; i >= 0 ; i--) tmp.add(t.list.get(i));
			t.list.clear();
			for(Node n : tmp) t.list.add(n);
		}
		System.out.println(ans);
	}
	static void printMap(){
		for(int i =1 ; i<= n ; i++) {
			for(int j =1 ; j<= n ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int throwBall(int round) {
		int dir = (round / n) % 4;
		int idx = round%n + 1;
		
		int tNum = -1;
		System.out.println("idx: " + idx);
		System.out.println("dir: " + dir);
		//3. 공이 가장 처음 만나는 사람의 팀이 점수를 얻는다
		if(dir ==0) {
			out:
			for(int i = 1 ; i <= n ; i++) {
				if(map[idx][i] > 4) {
					tNum = map[idx][i];
					Team t = teamInfo.get(tNum);
					
					for(int j = 0; j < t.list.size() ; j++) {
						Node n = t.list.get(j);
						if(idx == n.r && i == n.c) {
							ans += (j+1) * (j+1);
							System.out.println((j+1)+"번이 맞았다!");
							break out;
						}
					}
				}
			}
			
		}else if (dir == 1) {
			out:
			for(int i = n ; i >= 1 ; i--) {
				if(map[i][idx] > 4) {
					tNum = map[i][idx]; 
					Team t = teamInfo.get(tNum);
					
					for(int j = 0; j < t.list.size() ; j++) {
						Node n = t.list.get(j);
						
						if(idx == n.c && i == n.r) {
							ans += (j+1) * (j+1);
							System.out.println((j+1)+"번이 맞았다!");
							break out;
						}
					}
				}
			}
			
		}else if(dir == 2) {
			out:
			for(int i = n ; i >= 1 ; i--) {
				
				if(map[n - idx+1][i] > 4) {
					tNum = map[n-idx+1][i]; 
					Team t = teamInfo.get(tNum);
					
					for(int j = 0; j < t.list.size() ; j++) {
						Node node = t.list.get(j);
						if(n-idx+1 == node.r && i == node.c) {
							ans += (j+1) * (j+1);
							System.out.println((j+1)+"번이 맞았다!");
							break out;
						}
					}
				}
			}
			
		}else {
			out:
			for(int i = 1 ; i <= n ; i++) {
				if(map[i][n-idx+1] > 4) {
					tNum = map[i][n-idx+1]; 
					Team t = teamInfo.get(tNum);
					
					for(int j = 0; j < t.list.size() ; j++) {
						Node node = t.list.get(j);
						if(n-idx+1 == node.c && i == node.r) {
							ans += (j+1) * (j+1);
							System.out.println((j+1)+"번이 맞았다!");
							break out;
						}
					}
				}
			}
		}
		
		return tNum;
	}
	
	static void moveTeam() {
		//1. 각 팀 머리사람 방향으로, 경로대로 이동 모든 팀 동시에
		//꼬리 사람을 poll하고 해당위치 map에 4를 저장한다
		//head의 다음 index를 찾고 해당 인덱스에 팀number를 쓴다
		System.out.println("변경 전 ===============");
		printMap();
		for(int i = 5 ; i< teamInfo.size()+5 ; i++) {
			Team t = teamInfo.get(i);
			int n = t.idx;
			
			Node tail = t.list.remove(t.list.size()-1);
			map[tail.r][tail.c] = 4;
			Node head = t.list.get(0);
			
			for(int  j= 0 ; j < 4 ; j++) {
				int nr = head.r + dr[j];
				int nc = head.c + dc[j];
				
				if(OOB(nr,nc)) continue;
				if(map[nr][nc] == 4) {
					t.list.add(0, new Node(nr,nc));
					map[nr][nc] = n;
					break;
				}
			}
		}
		System.out.println("변경 후 ===============");
		printMap();
	}
	static void setTeam(int startR,int startC, boolean[][] vis, int num) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node (startR, startC));
		vis[startR][startC] = true;
		
		Team t = new Team(num);
		List<Node> body = new ArrayList<>();
		Node tail = new Node(-1,-1);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(map[cur.r][cur.c] == 1) t.list.add(cur);
			else if(map[cur.r][cur.c] == 2) body.add(cur);
			else if(map[cur.r][cur.c] == 3) {
				tail = cur;
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(OOB(nr,nc) || map[nr][nc] == 0|| map[nr][nc] == 4 || vis[nr][nc]) continue;
				
				if(map[cur.r][cur.c] == 1 && map[nr][nc] == 2) {
					q.offer(new Node(nr, nc));
					vis[nr][nc] = true;
				}else if(map[cur.r][cur.c] == 2 && (map[nr][nc] == 2 || map[nr][nc] == 3)){
					q.offer(new Node(nr, nc));
					vis[nr][nc] = true;
				}
			}
		}
		if(tail.r == -1) {
			//팀을 짜지 못한 오류 발생
			return;
		}
		
		map[t.list.get(0).r][t.list.get(0).c] = num;
		for(Node n : body) {
			map[n.r][n.c] = num;
			t.list.add(n);
		}
		
		map[tail.r][tail.c] = num;
		t.list.add(tail);
		teamInfo.put(num, t);
	}
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	static class Team{
		//구성원
		List<Node> list = new LinkedList<>();
		int idx;
		Team(int idx){
			this.idx = idx;
		}
	}
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r =r;
			this.c =c;
		}
	}
}
