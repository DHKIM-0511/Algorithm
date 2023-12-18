package solutions_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//야매 이중 연결리스트 -> 시간초과
public class 에디터2_1406 {
    static final int MX = 1000005;
    static char[] data = new char[MX];
    static int[] pre = new int[MX];
    static int[] next = new int[MX];
    static int idx = 1;
    static void insert(int add, char dat){
        data[idx] = dat;
        pre[idx] = add;
        next[idx] = next[add];
        if(next[add] != -1) pre[next[add]] = idx;
        next[add] = idx;
        idx++;
    }

    static void erase(int add){
        next[pre[add]] = next[add];
        if(next[add] != -1) pre[next[add]] = pre[add];
    }

    static void traversal(){
        int cur = next[0];
        while (cur != -1){
            System.out.print(data[cur]);
            cur = next[cur];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine(); // 소문자 , 10만 미만 길이
        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        Arrays.fill(pre, -1);
        Arrays.fill(next, -1);
        int cursor = 0;

        for(char c : inputString.toCharArray()){
            insert(cursor,c);
            cursor++;
        }

        for(int tc = 0 ; tc < M ; tc++){
            String cur = br.readLine();
            char c = cur.charAt(0);

            if(c == 'L'){
                if(pre[cursor] != -1) cursor = pre[cursor];
            } else if (c == 'D') {
                if (next[cursor] != -1) cursor = next[cursor];
            } else if (c == 'B') {
                if (pre[cursor] != -1) {
                    erase(cursor);
                    cursor = pre[cursor];
                }
            }else{
                char add = cur.charAt(2);
                insert(cursor, add);
                cursor = next[cursor];
            }
        }
        traversal();
    }
}
