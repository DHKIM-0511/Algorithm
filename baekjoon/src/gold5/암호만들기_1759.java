package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
	public static int L, C;
    public static char[] arr;
    public static char[] pw;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        pw = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        make(0,0);
        System.out.println(sb);
    }
    public static void make(int idx,int sidx) {
    	
        if (sidx == L) {
        	int aCnt = 0;
            int bCnt = 0;
            for (char c : pw) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                	aCnt++;
                } else {
                	bCnt++;
                }
            }
            if (aCnt >= 1 && bCnt >= 2) {
            	sb.append(pw).append("\n");
            }
            return;
        }

        //조합 만들기
        for (int i = idx; i < C; i++) {
            pw[sidx] = arr[i];
            make(i+1, sidx + 1);
        }
    }
}
