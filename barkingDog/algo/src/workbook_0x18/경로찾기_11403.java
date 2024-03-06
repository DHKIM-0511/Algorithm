package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 경로찾기_11403 {
    static int n;
    static int[][] map = new int[105][105];
    static boolean[] visited = new boolean[105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                sb.append(dfs(i,j)).append(" ");
                Arrays.fill(visited, false);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int start, int finish) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()){
            int cur = stack.pop();

            if(visited[cur]) continue;
            if (cur != start) visited[cur] = true;

            for(int i = 0 ; i < n ; i++){
                if(visited[i]) continue;
                if(map[cur][i] == 1){
                    if(i == finish) return 1;
                    stack.push(i);
                }
            }
        }
        return 0;
    }
}
