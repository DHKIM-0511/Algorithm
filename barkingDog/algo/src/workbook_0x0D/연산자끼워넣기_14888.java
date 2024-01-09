package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] cntInput;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        cntInput = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++){
            cntInput[i] = Integer.parseInt(st.nextToken());
        }

        fnc(0, new int[N-1]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void fnc(int cnt, int[] sel) {
        if(cnt == N-1){
            calculate(sel);
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            if(cntInput[i] >= 1){
                sel[cnt] = i;
                cntInput[i]--;
                fnc(cnt+1, sel);
                cntInput[i]++;
            }
        }
    }

    private static void calculate(int[] sel) {
        int tmp = input[0];
        for(int i = 1 ; i < N ; i++){
            if(sel[i-1] == 0){
                tmp += input[i];
            }else if(sel[i-1] == 1){
                tmp -= input[i];
            }else if(sel[i-1] == 2){
                tmp *= input[i];
            }else{
                if(tmp < 0 ){
                    tmp *= -1;
                    tmp /= input[i];
                    tmp *= -1;
                }else{
                    tmp /= input[i];
                }
            }
        }

        max = Math.max(tmp, max);
        min = Math.min(tmp, min);
    }
}
