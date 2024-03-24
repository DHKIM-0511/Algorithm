package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무재테크_16235 {
    static int n,m,k;
    static int[][] s2d2,map;
    static ArrayList<Integer>[][] tree;
    static int[] dr = {-1,1,0,0,-1,-1,1,1}, dc = {0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        s2d2 = new int[n+1][n+1];
        map = new int[n+1][n+1];
        tree = new ArrayList[n+1][n+1];

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++){
                s2d2[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
                tree[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int r= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            int age= Integer.parseInt(st.nextToken());

            tree[r][c].add(age);
        }

        while (k--> 0){
            for(int i =1 ; i <= n ; i++){
                for(int j = 1; j <= n ; j++){
                    springSummer(i,j);
                }
            }
            for(int i =1 ; i <= n ; i++){
                for(int j = 1; j <= n ; j++){
                    fallWinter(i,j);
                }
            }
        }
        System.out.println(getTreeCnt());
    }

    private static void fallWinter(int r,int c) {
        //가을
        for(int age: tree[r][c]){
            if(age % 5 == 0){
                for(int dir = 0 ; dir < 8 ; dir++){
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if(nr < 1 || nr > n || nc < 1 || nc > n) continue;
                    tree[nr][nc].add(0,1);
                }
            }
        }

        //겨울
        map[r][c] += s2d2[r][c];
    }

    private static void springSummer(int r,int c) {
        List<Integer> copyTree = tree[r][c];
        Collections.sort(copyTree,((o1, o2) -> o2-o1));
        //봄
        int idx = copyTree.size()-1;
        for(; idx >= 0 ; idx--){
            if(map[r][c] < copyTree.get(idx)) break;
            map[r][c] -= copyTree.get(idx);
            copyTree.set(idx, copyTree.get(idx)+1);
        }
        //여름
        for(int i = 0 ; i <= idx ; i++){
            map[r][c] += copyTree.get(i)/2;
        }
        copyTree.subList(0, idx+1).clear();
    }
    private static int getTreeCnt() {
        int cnt =0;
        for(int i = 1 ; i<= n ; i++){
            for(int j =1  ; j <= n ; j++){
                cnt+= tree[i][j].size();
            }
        }
        return cnt;
    }
}
