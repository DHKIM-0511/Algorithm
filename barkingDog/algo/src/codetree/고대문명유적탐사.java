package codetree;

import java.io.*;
import java.util.*;

public class 고대문명유적탐사 {
    static int k , m;
    static int[][] map = new int[6][6];
    static int[][] copyMap = new int[6][6];
    static int[] dr = {-1,1,0,0}, dc={0,0,-1,1};
    static Queue<Integer> hNum = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i<= 5 ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< m ; i++) hNum.offer(Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        for(int t = 0 ;t < k ; t++){
            //탐사 진행
            //3 x 3격자를 선택, 회전을해서 유물을 획득한다
            // 가장 유물 획득 가치가 높고, 열이 작고, 행이 작은 순서로
            int[] info = getInfo();

            if(info[0] == -1) break; // 획득 불가면 종료
            int sum = 0;

            //1회 실행
            for(int i = 0 ; i <= info[2] ; i++){
                rotate(info[0], info[1]);
            }
            boolean[][] vis = new boolean[6][6];
            for(int i = 1 ; i<= 5; i++){
                for(int j =1 ; j<= 5 ; j++){
                    if(vis[i][j]) continue;
                    sum += getSum(i,j,vis,map[i][j]);
                }
            }

            for(int i = 1 ; i <= 5 ; i++){
                for(int j =1 ;j <= 5 ; j++){
                    if(map[6-j][i] == 0){
                        map[6-j][i] = hNum.poll();

                    }
                }
            }

            //연쇄 실행
            while (totCheck()){
                //유물 획득
                vis = new boolean[6][6];
                for(int i = 1 ; i<= 5; i++){
                    for(int j =1 ; j<= 5 ; j++){
                        if(vis[i][j]) continue;
                        sum += getSum(i,j,vis,map[i][j]);
                    }
                }
                for(int i = 1 ; i <= 5 ; i++){
                    for(int j =1 ;j <= 5 ; j++){
                        if(map[6-j][i] == 0){
                            map[6-j][i] = hNum.poll();

                        }
                    }
                }
            }

            sb.append(sum).append(" ");
        }
        System.out.println(sb);
    }
    private static int getSum(int r, int c, boolean[][] vis,int t) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> path = new ArrayList<>();

        vis[r][c] = true;
        q.offer(new int[]{r,c});

        int cnt = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();

            cnt++;
            for(int i = 0 ; i <4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(OOB(nr,nc)|| vis[nr][nc] || t != map[nr][nc]) continue;
                int[] next = new int[]{nr,nc};
                q.offer(next);
                path.add(next);
                vis[nr][nc] =true;
            }
        }

        if(cnt >= 3){
            path.add(new int[]{r,c});

            for(int[] idx : path){
                map[idx[0]][idx[1]] = 0;
            }

            return cnt;
        }

        return 0;
    }

    private static boolean totCheck() {
        int val = 0;
        boolean[][] vis = new boolean[6][6];
        for(int i = 1 ; i<= 5; i++){
            for(int j =1 ; j<= 5 ; j++){
                if(vis[i][j]) continue;
                val += getValue(i,j,vis,map[i][j],map);
            }
        }
        return val > 0 ;
    }

    private static void rotate(int r,int c) {
        //회전
        int[][] tmp = new int[3][3];

        for(int i = 0 ;i < 3; i ++){
            for(int j =0 ; j< 3 ; j++){
                tmp[i][j] = map[r+i][c+j];
            }
        }

        for(int i = 0 ;i < 3; i ++){
            for(int j =0 ; j< 3 ; j++){
                map[r+i][c+j] = tmp[2-j][i];
            }
        }
    }

    private static int[] getInfo() {
        int[] info = {-1,-1,-1};

        int value = 0;
        for(int k = 0 ; k < 3; k++){
            for(int i = 1; i <= 3 ; i++){
                for(int j =1 ; j<= 3 ; j++){
                    initCopyMap();

                    int tmp = check(j,i,k);
                    if(tmp > value){
                        value = tmp;
                        info[0] = j;
                        info[1] = i;
                        info[2] = k;

                    }
                }
            }
        }

        return info;
    }

    private static int check(int r, int c,int k) {
        //회전
        for(int t = 0 ; t <= k ; t++){
            int[][] tmp = new int[3][3];

            for(int i = 0 ;i < 3; i ++){
                for(int j =0 ; j< 3 ; j++){
                    tmp[i][j] = copyMap[r+i][c+j];
                }
            }

            for(int i = 0 ;i < 3; i ++){
                for(int j =0 ; j< 3 ; j++){
                    copyMap[r+i][c+j] = tmp[2-j][i];
                }
            }
        }

        //가능한 유물가치
        int val = 0;
        boolean[][] vis = new boolean[6][6];
        for(int i = 1 ; i<= 5; i++){
            for(int j =1 ; j<= 5 ; j++){
                if(vis[i][j]) continue;
                val += getValue(i,j,vis,copyMap[i][j],copyMap);
            }
        }

        return val;
    }

    private static int getValue(int r, int c, boolean[][] vis,int t, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        vis[r][c] = true;
        q.offer(new int[]{r,c});

        int cnt = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();

            cnt++;
            for(int i = 0 ; i <4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(OOB(nr,nc)|| vis[nr][nc] || t != map[nr][nc]) continue;
                q.offer(new int[]{nr,nc});
                vis[nr][nc] =true;
            }
        }

        return cnt >= 3 ? cnt : 0;
    }

    private static void initCopyMap() {
        for(int i = 1; i <= 5 ; i++){
            for(int j = 1; j<= 5; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static boolean OOB(int r,int c){
        return r < 1 || r > 5 || c < 1 || c > 5;
    }
}
