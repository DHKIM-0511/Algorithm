package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 핸드폰요금_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = 0, M = 0;

        for(int i = 0 ; i < N ; i++){
            int t = Integer.parseInt(st.nextToken());

            Y += (t / 30 + 1) * 10;
            M += (t / 60 + 1) * 15;
        }
        if(Y == M){
            System.out.println("Y M "+Y);
        }else if(Y < M){
            System.out.println("Y "+Y);
        }else{
            System.out.println("M "+M);
        }
    }
}
