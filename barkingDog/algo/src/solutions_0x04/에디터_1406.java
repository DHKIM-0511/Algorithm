package solutions_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine(); // 소문자 , 10만 미만 길이
        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        List<Character> list =new LinkedList<>();

        for(char c : inputString.toCharArray()){
            list.add(c);
        }
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }
        for(int tc = 0 ; tc < M ; tc++){
            String cur = br.readLine();
            char c = cur.charAt(0);

            if(c == 'L'){
                if(iter.hasPrevious()) iter.previous();
            } else if (c == 'D') {
                if(iter.hasNext()) iter.next();
            } else if (c == 'B') {
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else{
                char next = cur.charAt(2);
                iter.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
//static class Node{
//    String data;
//    int preAdd;
//    int nextAdd;
//    public Node(String data, int preAdd, int nextAdd) {
//        this.data = data;
//        this.preAdd = preAdd;
//        this.nextAdd = nextAdd;
//    }
//    public static Node updateAdd(Node n, int preAdd, int nextAdd){
//        n.preAdd = preAdd;
//        n.nextAdd = nextAdd;
//        return n;
//    }
//    public static Node updateNxtAdd(Node n, int nextAdd){
//        n.nextAdd = nextAdd;
//        return n;
//    }
//    public static Node updatePreAdd(Node n, int preAdd){
//        n.preAdd = preAdd;
//        return n;
//    }
//}