package workbook_0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        out: for(int tc = 0 ; tc < T; tc++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] arr = str.substring(1, str.length()-1).split(",");

            Deque<Integer> list = new LinkedList<>();

            for(String s : arr){
                if (!s.isEmpty()) { // 빈 문자열이 아닌 경우에만 숫자로 변환
                    list.add(Integer.parseInt(s));
                }
            }

            boolean isReverse = false;

            for(int i = 0 ; i < p.length() ; i++){
                if(p.charAt(i) =='R'){
                    isReverse = !isReverse;
                }else{
                    if(list.size() > 0){
                        if(isReverse){
                            list.removeLast();
                        }else{
                            list.removeFirst();
                        }
                    }else{
                        System.out.println("error");
                        continue out;
                    }
                }
            }
            StringBuilder output = new StringBuilder();
            output.append("[");
            while(!list.isEmpty()){
                output.append(isReverse ? list.removeLast() : list.removeFirst());
                if(!list.isEmpty()){
                    output.append(",");
                }
            }
            output.append("]");
            System.out.println(output);
        }
    }
}
