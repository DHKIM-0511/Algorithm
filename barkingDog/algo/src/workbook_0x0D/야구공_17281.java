package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구공_17281 {
    static int N,ans;
    static int sel[] = new int[10], data[][] = new int[51][10];
    static boolean[] isUsed = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < 10 ; j ++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sel[4] = 1;
        isUsed[1] = true;

        setMember(1);
        System.out.println(ans);
    }

    private static void setMember(int cnt ) {
        if(cnt == 10){
            getScore();
            return;
        }
        if(cnt==4){
            setMember(cnt+1);
            return;
        }
        for(int i = 2 ; i < 10 ; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true;
            sel[cnt] = i;
            setMember(cnt +1);
            isUsed[i] = false;
        }
    }

    private static void getScore() {
        int score = 0;
        int idx = 1;
        for (int in = 0 ; in < N ; in++){
            int outCnt = 3;
            boolean[] 루 = new boolean[4];

            while (outCnt > 0){
                int cur = data[in][sel[idx]];
                if(cur == 1){
                    for(int i = 3; i >= 1; i--){
                        if(루[i]){
                           if(i == 3){
                               score++;
                               루[i] = false;
                           }else{
                               루[i+1] = true;
                               루[i] = false;
                           }
                       }
                   }
                   루[cur] = true;
               }else if (cur == 2){
                   for(int i = 3; i >= 1; i--){
                       if(루[i]){
                           if(i >= 2){
                               score++;
                               루[i] = false;
                           }else{
                               루[i+2] = true;
                               루[i] = false;
                           }
                       }
                   }
                   루[cur] = true;
               }else if(cur == 3){
                   for(int i = 3; i >= 1; i--){
                       if(루[i]){
                           score++;
                           루[i] = false;
                       }
                   }
                   루[cur] = true;
               }else if (cur == 4){
                    int cnt = 1;
                   for(int i = 3; i >= 1; i--){
                       if(루[i]){
                           루[i] =false;
                           cnt++;
                       }
                   }
                   score += cnt;
               }else{
                    outCnt--;
               }
                idx++;
                if(idx >= 10) idx =1;
           }
        }
        ans = Math.max(ans, score);
    }
}
