package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 이상한윷놀이 {
    static int n,k,ans;
    static ArrayList<Node>[][] map;
    static int[][] colorMap;
    static int[] dr = {0,0,0,-1,1}, dc ={0,1,-1,0,0,}; // 0 우 좌 상 하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1][n+1];
        colorMap = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1 ; j<= n ; j++){
                colorMap[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i = 1 ; i <= k ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Node(i, d));
        }

        int turn =0;
        ans = -1;

        while (turn++ <= 1000){

            boolean b = simulate();

            if(b){
                ans = turn;
                break;
            }
        }
        System.out.println(ans);
    }

    private static boolean simulate() {

        for(int i = 1 ; i <= k ; i++){
            int[] info = findInfo(i);

            int dir = info[2];
            int nr = info[0] + dr[dir];
            int nc = info[1] + dc[dir];

            boolean reverse = false;

            if(OOB(nr,nc) || colorMap[nr][nc] == 2){
                dir = (dir % 2 == 0) ? dir-1 : dir+1;
                nr = info[0] + dr[dir];
                nc = info[1] + dc[dir];

                if(OOB(nr,nc) || colorMap[nr][nc] == 2){
                    nr = info[0];
                    nc = info[1];
                } else if (colorMap[nr][nc] == 1) {
                    reverse = true;
                }
            } else if (colorMap[nr][nc] == 1) {
                reverse =true;
            }
            ArrayList<Node> infoList = popInfo(info[0],info[1],i);
            infoList.set(0, new Node(i,dir));
            move(nr,nc,infoList,reverse);

            if(map[nr][nc].size()>=4) return true;
        }
        return false;
    }

    private static void move(int r, int c, ArrayList<Node> infoList, boolean reverse) {
        if(reverse) Collections.reverse(infoList);

        for(int i = 0 ; i < infoList.size() ; i++){
            map[r][c].add(infoList.get(i));
        }
    }

    private static ArrayList<Node> popInfo(int r, int c, int id) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i = 0 ; i < map[r][c].size() ; i++){
            int num = map[r][c].get(i).id;

            if(num == id){
                for(int j = i ; j < map[r][c].size() ; j++){
                    nodeList.add(map[r][c].get(j));
                }
                for(int j = map[r][c].size()-1 ; j >= i ; j--){
                    map[r][c].remove(j);
                }
                break;
            }
        }
        return nodeList;
    }

    private static int[] findInfo(int id) {
        for(int i = 1 ; i <= n ; i++ ){
            for(int j = 1; j <= n ; j++){
                for(int k = 0 ; k < map[i][j].size() ; k++){
                    int num = map[i][j].get(k).id;
                    int dir = map[i][j].get(k).d;

                    if(num == id) return new int[]{i,j,dir};
                }
            }
        }

        return new int[]{-1,-1,-1};
    }


    static boolean OOB(int r,int c){
        return r < 1 || r > n || c < 1 || c > n;
    }
    static class Node{
        int id,d;
        Node(int id,int d){
            this.id=id;
            this.d=d;
        }
    }
}
