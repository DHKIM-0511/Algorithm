package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 우주탐사선_17182 {
    static final int INF = 0x3f3f3f3f;
    static int n,k,ans = Integer.MAX_VALUE;
    static int[][] distMap;
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distMap = new int[n][n];
        isUsed = new boolean[n];
        for(int i = 0 ; i < n ; i++) Arrays.fill(distMap[i], INF);
        for(int i = 0 ; i < n ; i++){
            st =new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                distMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(distMap[i][j] > distMap[i][k]+distMap[k][j]){
                        distMap[i][j] = distMap[i][k]+distMap[k][j];
                    }
                }
            }
        }
        isUsed[k] = true;
        getDist(0,new int[n-1]);
        System.out.println(ans);
    }
    private static void getDist(int cnt,int[] sel) {
        if(cnt == n-1){
            int d = distMap[k][sel[0]];

            for(int i = 1; i < n-1 ; i++){
                d += distMap[sel[i-1]][sel[i]];
            }
            ans = Math.min(ans, d);
            return;
        }
        for(int i =0 ; i < n ; i++){
            if(isUsed[i]) continue;
            isUsed[i] =true;
            sel[cnt] = i;
            getDist(cnt+1,sel);
            isUsed[i] =false;
        }
    }

    static class Node{
        int e,v;
        Node(int e,int v){
            this.e=e;
            this.v=v;
        }
    }
}
