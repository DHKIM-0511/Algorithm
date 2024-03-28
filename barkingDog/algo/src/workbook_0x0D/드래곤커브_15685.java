package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {
    static int N,ans;
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> dirList = new ArrayList<>();
            dirList.add(d%4);
            map[r][c] = 1;

            while (g-- > 0){
                int size = dirList.size();
                for(int j = size-1 ; j >= 0 ; j--){
                    dirList.add((dirList.get(j) + 1)% 4);
                }
            }

            for(int dir : dirList){
                if(dir == 0) c++;
                else if(dir == 1) r--;
                else if(dir == 2) c--;
                else if(dir == 3) r++;
                if(r < 0 || r > 100 || c < 0 || c > 100) continue;
                map[r][c]=1;
            }
        }
        for(int i = 0 ; i < 100 ; i ++){
            for(int j = 0 ; j < 100 ; j++){
                if(map[i][j] == 1 &&
                    map[i+1][j] == 1 &&
                    map[i][j+1] == 1 &&
                    map[i+1][j+1] == 1
                ) ans++;
            }
        }
        System.out.println(ans);
    }
}
