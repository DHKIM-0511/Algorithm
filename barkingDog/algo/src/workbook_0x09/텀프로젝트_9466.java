package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_9466 {
    static int N,cnt;
    static int[] vote;
    static boolean[] team;
    static boolean[] finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < TC ;t++){
            N = Integer.parseInt(br.readLine());
            finished = new boolean[N+1];
            team = new boolean[N+1];
            vote = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1 ; i <= N ; i++){
                int s = Integer.parseInt(st.nextToken());
                vote[i]=s;
            }

            cnt = 0;
            for(int i = 1 ; i <= N ; i++){
                teamMaker(i);
            }
            System.out.println(N-cnt);
        }
    }

    private static void teamMaker(int student) {
        if(team[student]) return;

        team[student] = true;
        int next = vote[student];

        if(!team[next]){
            teamMaker(next);
        }else{
            if(!finished[next]){
                //싸이클 확인
                cnt++;
                while (next != student){
                    cnt++;
                    next = vote[next];
                }
            }
        }
        finished[student] = true;
    }
}
