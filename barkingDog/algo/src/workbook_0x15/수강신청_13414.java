package workbook_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class 수강신청_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < l ; i++){
            String cur = br.readLine();
            map.put(cur,i);
        }
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        if(list.size() < k){
            for(int i = 0 ; i < list.size() ; i ++) sb.append(list.get(i)).append("\n");
        }else{
            for(int i = 0 ; i < k ; i ++) sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
