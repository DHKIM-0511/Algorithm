package workbook_0x0D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 이차원배열과연산_17140 {
    static int R,C,K,ans;
    static int n = 3,m = 3;
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <=m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (map[R][C] != K && ans <= 100){
            boolean isChange = false;
            if(n < m){
                change();
                isChange = true;
            }
            for(int i = 1 ; i <= n ; i++) sort(map[i]);
            if(isChange) change();
            ans++;
        }
        System.out.println(ans > 100? -1 : ans);
    }

    private static void sort(int[] arr) {
        int[] cntArr = new int[101];
        for(int i = 1 ; i <= m ; i++){
            cntArr[arr[i]]++;
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= 100 ; i++){
            if(cntArr[i] ==0) continue;
            list.add(new int[] {cntArr[i], i});
        }

//        list.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        int idx = 0 ;
        for(int[] a : list){
            if(idx == 100) break;
            arr[++idx] = a[1];
            arr[++idx] = a[0];
        }
        m = Math.max(m, idx);
        Arrays.fill(arr, idx+1, m+1, 0);
    }

    private static void change() {
        int max = Math.max(n,m);

        for(int i = 1; i <= max ; i ++){
            for(int j = i + 1 ; j <= max ; j++){
                int tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }
        int tmp = n;
        n = m;
        m = tmp;
    }
}
