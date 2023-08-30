package gold5;

import java.io.*;
import java.util.*;
//		두 나라의 인구 차이가 L이상 R이하 인경우 인구 이동 시작
//		두 국가의 인구이동중 = 연합( 각 연합의 인구수 = 연합의 인구수 / 칸의 개수 )
//		인구 이동이 없을때까지 지속

public class 인구이동_16234_sample {
	static int n,l,r;
	static int[][] map;
	static int[][] union;
	static ArrayList<Dot> arrList = new ArrayList<Dot>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static int cnt=0;
	static int area=1;
	static int sum=0;
	
	static class Dot {
		int x;
		int y;
		Dot(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		union = new int[n+1][n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			area = 1;
			sum = 0;
			init_union(); // 연합을 계속해서 초기화 해줌.
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(union[i][j]==0) {
						// 국경선을 공유하는 두나라의 인구차이가 l~r인지 확인 (BFS 영역나누기)
						BFS(i,j);
						
						if(arrList.size()>1) {
							int next_num = sum/arrList.size();							
							for(int k=0; k<arrList.size(); k++) {
								map[arrList.get(k).x][arrList.get(k).y] = next_num;
							}
						}					
						area++;
					}					
				}
			}
			
			if(area - 1 == n*n) { // 국경선이 하나도 안열렸을 경우 -> area의 수와 행렬 칸의 수가 같음
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	public static void BFS(int a, int b) {
		sum = 0;
		arrList.clear();
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(a,b));
		union[a][b]=area;
		arrList.add(new Dot(a,b));
		sum+=map[a][b];
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int x = d.x;
			int y = d.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(union[nx][ny]==0 && (Math.abs(map[nx][ny]-map[x][y])>=l && Math.abs(map[nx][ny]-map[x][y])<=r)) {
						q.offer(new Dot(nx,ny));
						union[nx][ny]=area;
						
						arrList.add(new Dot(nx,ny));
						sum+=map[nx][ny];
					}
				}
			}
		}
	}
	
	public static void sum_people(int num) {
		arrList.clear();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(union[i][j]==num) {
					arrList.add(new Dot(i,j));
					sum += map[i][j];
				}
			}
		}
	}

	public static void init_union() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				union[i][j]=0;
			}
		}
	}
}

	


