package solutions_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991 {
    static int n;
    static int[] lc = new int[30];
    static int[] rc = new int[30];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l != '.') lc[root - 'A' + 1] = l - 'A' + 1;
            if (r != '.') rc[root - 'A' + 1] = r - 'A' + 1;
        }
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb);
    }
    static void preorder(int cur) {
        sb.append((char)(cur + 'A' - 1));
        if (lc[cur] != 0) preorder(lc[cur]);
        if (rc[cur] != 0) preorder(rc[cur]);
    }

    static void inorder(int cur) {
        if (lc[cur] != 0) inorder(lc[cur]);
        sb.append((char)(cur + 'A' - 1));
        if (rc[cur] != 0) inorder(rc[cur]);
    }

    static void postorder(int cur) {
        if (lc[cur] != 0) postorder(lc[cur]);
        if (rc[cur] != 0) postorder(rc[cur]);
        sb.append((char)(cur + 'A' - 1));
    }
}
