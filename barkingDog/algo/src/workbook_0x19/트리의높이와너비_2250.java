package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의높이와너비_2250 {
    static int n,root,colno;
    static int[] lc ,rc;
    static int[][] colLR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        colLR= new int[n+1][2];
        lc = new int[n+1];
        rc = new int[n+1];
        boolean[] isRoot = new boolean[n+1];

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            lc[p] = l;
            rc[p] = r;

            if(l != -1) isRoot[l] = true;
            if(r != -1) isRoot[r] = true;
        }
        for(int i = 1 ; i <= n ; i++){
            if(!isRoot[i]){
                root = i;
                break;
            }
        }
        //중위순회 : lc감 -> 열번호 줌 -> 오른쪽 감
        int maxW = 0, maxD = 0;
        inorder(root, 0);
        for(int d = 0 ; d < n ; d++){
            int[] p = colLR[d];
            if(p[0] + p[1] == 0 )break;
            int w = p[1] - p[0] + 1;
            if(maxW < w){
                maxW = w;
                maxD = d;
            }
        }
        System.out.println((maxD+1) + " " + maxW);
    }

    private static void inorder(int cur, int d) {
        if (cur == -1) return;
        inorder(lc[cur], d + 1);
        colno++;
        int[] p = colLR[d];
        if (p[0] == 0|| colno < p[0]) p[0] = colno;
        if (p[1] == 0|| colno > p[1]) p[1] = colno;
        inorder(rc[cur], d + 1);
    }
}
