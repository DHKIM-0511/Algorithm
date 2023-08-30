package silver2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M12_15666 {
	static int N,M;
    static int[] arr;
    static int[] sol;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N+1];
        sol = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
            Arrays.sort(arr);
            Sol(N, M, 0,0);
        System.out.println(sb);

    }
    static void Sol(int n, int m, int L,int idx) {
        int visit = 0;
        if (L == m) {
            for (int val : sol) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = idx; i <= n; i++) {
                if (visit != arr[i]) {
                    sol[L] = arr[i];
                    visit = arr[i];
                    Sol(n, m, L + 1,i);
                }
            }
        }
    }
}

