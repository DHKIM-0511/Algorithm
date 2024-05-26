package codetree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 놀이기구탑승 {
    static int n;
    static int[][] map;
    static int[] dr = {-1,1,0,0} , dc={0,0,-1,1};
    static HashMap<Integer, Student> students = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for(int i = 0 ; i < n * n ; i++){
            st  = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Student cur = new Student(id,a,b,c,d);
            students.put(id, cur);

            //탑승
            enter(cur);
        }

        printScore();
    }

    private static void printScore() {
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int cur = map[i][j];

                int cnt = 0;
                for(int d = 0 ; d < 4 ; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(OOB(nr,nc)) continue;

                    if(students.get(cur).like.contains(map[nr][nc])) cnt++;
                }
                if(cnt == 0) continue;
                ans += Math.pow(10, cnt-1);
            }
        }

        System.out.println(ans);
    }

    private static void enter(Student s) {

        int likeCnt = 0;
        int emptyCnt = 0;
        int[] loc = {25,25};

        for(int i = 0 ;i  < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != 0 ) continue;
                int lc = 0;
                int ec = 0;

                for(int d = 0 ; d < 4 ; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(OOB(nr,nc)) continue;
                    if(map[nr][nc] == 0) ec++;
                    else if(s.like.contains(map[nr][nc])) lc++;
                }

                if(lc > likeCnt){
                    likeCnt = lc;
                    emptyCnt = ec;
                    loc[0] = i;
                    loc[1] = j;
                    continue;
                }
                if(lc == likeCnt && ec > emptyCnt){
                    emptyCnt = ec;
                    loc[0] = i;
                    loc[1] = j;
                    continue;
                }
                if(lc == likeCnt && ec == emptyCnt && i < loc[0]){
                    loc[0] = i;
                    loc[1] = j;
                    continue;
                }
                if(lc == likeCnt && ec == emptyCnt && i == loc[0] && j < loc[1]){
                    loc[0] = i;
                    loc[1] = j;
                }
            }
        }
//        System.out.println(s.id+" loc");
//        System.out.println(loc[0] +" " + loc[1]);
//        System.out.println();
        map[loc[0]][loc[1]] = s.id;
    }

    static boolean OOB(int r,int c){
        return r < 0 || r >= n || c < 0 || c >=n;
    }
    static class Student{
        int id;
        List<Integer> like =new ArrayList<>();
        Student(int id, int a,int b,int c,int d){
            this.id=id;
            this.like.add(a);
            this.like.add(b);
            this.like.add(c);
            this.like.add(d);
        }
    }
}
