package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 보호필름2 {
    static int ans, d, w, k;
    static int[][] map,copy;
    static List<Integer> needChange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[d][w];
            copy = new int[d][w];
            needChange = new ArrayList<Integer>();

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = Integer.MAX_VALUE;
            DFS(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void DFS(int idx, int cnt) {
    	if(cnt >= ans )
    		return;
    	
    	// 성능이 통과인지 아닌지 판단.
        if (idx == d ) {
        	if(isPass()) ans = Math.min(ans, cnt);
            return;
        } else {  // 약물 투입
        	DFS(idx+1 , cnt);
            for (int j = 0; j < w; j++) map[idx][j] = 0;
            DFS(idx + 1, cnt + 1); // A 투입 후 다시 검사
            for (int j = 0; j < w; j++) map[idx][j] = 1;
            DFS(idx + 1, cnt + 1); // B 투입 후 다시 검사
            for (int i = 0; i < w; i++) map[idx][i] = copy[idx][i];
        }
    }

    private static boolean isPass() { 
		boolean flag = false; //A
		int aCnt = 0 ;
		int bCnt = 0 ;
		needChange.clear();
		a:for(int i = 0 ; i < w ; i++) {
			for(int j = 0 ; j < d ; j++) {
				if(map[j][i] == 0) { //A
					aCnt++;
					flag = false;
				}else {
					bCnt++;
					flag = true;
				}
				if(j > 0) {
					if(map[j][i] != map[j-1][i]) {
						if(flag) aCnt = 0;
						else bCnt = 0;
					}
				}
				if(aCnt == k) {
					aCnt=0;
					bCnt=0;
					continue a; // 한 열 통과
				}else if (bCnt == k) {
					aCnt=0;
					bCnt=0;
					continue a;
				}
			}
			//통과 못한 열idx 추가.
			needChange.add(i);
			aCnt=0;
			bCnt=0;
		}
//		System.out.println("NeedChange : "+needChange.toString());
		if(needChange.size() > 0) {
			return false;
		}else
			return true;
	}
}
