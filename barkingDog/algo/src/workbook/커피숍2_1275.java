package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 커피숍2_1275 {
    static int n,q;
    static long[] input,tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        input = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        //새그먼트 트리 사이즈
        int h = (int) Math.ceil(Math.log(n)/Math.log(2)); // 높이
        int treeSize = (int) Math.pow(2,h+1);
        tree = new long[treeSize];
        treeInit(0,n-1,1);

        StringBuilder sb = new StringBuilder();
        while (q-- >0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            if(x > y){
                int tmp = x;
                x = y;
                y = tmp;
            }
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());

            long sum = preSum(0,n-1,1,x,y);
            sb.append(sum).append("\n");

            long diff = b - input[a];
            update(0,n-1,1,a,diff);
            input[a] = b;
        }
        System.out.println(sb);
    }

    private static long treeInit(int s,int e,int cur) {
        if(s == e){
            return tree[cur] = input[s];
        }
        int mid = (s+e)/2;
        return tree[cur] = treeInit(s,mid,cur*2) + treeInit(mid+1, e, cur*2+1);
    }

    private static void update(int s, int e, int cur, int idx, long diff) {
        if(s <= idx && idx <=e){
            tree[cur] += diff;
        }else return;

        if( s == e )return;
        int mid = (s+e)/2;
        update(s,mid,cur*2,idx,diff);
        update(mid+1,e,cur*2+1,idx,diff);
    }

    private static long preSum(int s, int e, int cur, int l, int r) {
        if(e < l || r < s) return 0;
        if(l <= s && e <= r){
            return tree[cur];
        }

        int mid = (s+e)/2;
        return preSum(s,mid,cur*2,l,r) + preSum(mid+1, e, cur*2+1,l,r);
    }
}
