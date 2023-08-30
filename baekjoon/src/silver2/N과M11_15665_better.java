package silver2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M11_15665_better {
    static int[] arr;
    static int[] sol;
    public static StringBuilder sb = new StringBuilder();

    static void Sol(int n, int m, int L) {
        int visit = 0;
        if (L == m) {
            for (int val : sol) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = 0; i <= n; i++) {
                if (visit != arr[i]) {
                    sol[L] = arr[i];
                    visit = arr[i];
                    Sol(n, m, L + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n+1];
        sol = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
            Arrays.sort(arr);
            Sol(n, m, 0);
        System.out.println(sb);

        }
    }

