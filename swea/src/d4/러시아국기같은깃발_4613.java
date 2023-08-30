package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 러시아국기같은깃발_4613 {
	static char[][] flag;
	static int n;
	static int m;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			
			flag = new char[n][m];
			//주어진 배열입력
			for(int i = 0 ; i < n ; i++) {
				String tmp = br.readLine();
				for(int j = 0 ; j < m ; j++) {
					flag[i][j] = tmp.charAt(j);
				}
			}
			
			makeFlag('W', 0, 0);
			
			int minCnt = n * m + 1;
			int size = queue.size();
			//최소값 출력
			for (int i = 0; i < size; i++) {
				int value = queue.poll();
				minCnt = (value < minCnt) ? value : minCnt;
			}
			System.out.println("#"+tc+" "+minCnt);
		}
		
	}
	
	public static void makeFlag(char color, int line, int sum) {
		
		int cnt = sum;
		
		for (int c = 0; c < m; c++) {
			if (flag[line][c] != color) cnt++; 			
		}
		
		if (line == n - 1) {
			queue.offer(cnt);
			return;
		}
		
		if (color == 'W' && line < n - 3) {
			makeFlag('W', line + 1, cnt);
			makeFlag('B', line + 1, cnt);
		} else if (color == 'W' && line == n - 3) {	
			makeFlag('B', line + 1, cnt);
		} else if (color == 'B' && line < n - 2) {
			makeFlag('B', line + 1, cnt);
			makeFlag('R', line + 1, cnt);
		} else if (color == 'B' && line == n - 2) {
			makeFlag('R', line + 1, cnt);
		} else {
			makeFlag('R', line + 1, cnt);
		}
	}
}
 // 교수님 풀이
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//         
//        int T = sc.nextInt();
//        for(int tc=1; tc<=T; tc++) {
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//             
//            char[][] map = new char[N][M];

//            for(int r=0; r<N; r++) {
//                String str = sc.next();
//                char[] arr = str.toCharArray();
//                for(int c=0; c<M; c++) {
//                    map[r][c] = arr[c];
//                }
//            }
//             
//            int min = Integer.MAX_VALUE;
//            for(int b=1; b<N-1; b++) {
//                for(int r=1; r<N; r++) {
//                    int cnt = 0;
//                     
//                    // [0, b)
//                    for(int i=0; i<b; i++) {
//                        for(int j=0; j<M; j++) {
//                            if(map[i][j] != 'W') cnt++;
//                        }
//                    }
//                    // [b, r)
//                    for(int i=b; i<r; i++) {
//                        for(int j=0; j<M; j++) {
//                            if(map[i][j] != 'B') cnt++;
//                        }
//                    }
//                     
//                    // [r, N)
//                    for(int i=r; i<N; i++) {
//                        for(int j=0; j<M; j++) {
//                            if(map[i][j] != 'R') cnt++;
//                        }
//                    }
//                     
//                    if (cnt < min) {
//                        min = cnt;
//                    }
//                }
//            }
//            System.out.println("#"+tc+" "+min);
//        }
//    }
//}