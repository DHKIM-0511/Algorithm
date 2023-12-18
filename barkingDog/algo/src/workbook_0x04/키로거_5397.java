package workbook_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 키로거_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < tc ; t ++){
            String input = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int i = 0 ; i < input.length() ; i++) {
                char cur = input.charAt(i);

                if (cur == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (cur == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (cur == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }else{
                    iter.add(cur);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c: list){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
