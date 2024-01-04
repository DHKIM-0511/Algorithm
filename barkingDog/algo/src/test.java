import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
    String[] ans = solution(
        new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});

        Arrays.stream(ans).forEach(System.out::println);
    }
    static public String[] solution(String[] files) {
        PriorityQueue<FileName> pq = new PriorityQueue<>((o1,o2) ->{
            if(!o1.HEAD.toUpperCase().equals(o2.HEAD.toUpperCase())){
                System.out.println("o1.HEAD: "+ o1.HEAD);
                System.out.println("o2.HEAD: "+ o2.HEAD);
                return o1.HEAD.compareTo(o2.HEAD);
            }
            System.out.println("o1.NUMBER: "+ o1.NUMBER);
            System.out.println("o2.NUMBER: "+ o2.NUMBER);
            return o1.NUMBER.compareTo(o2.NUMBER);
        } );
        for(String cur : files){
            int startIdx = 0;
            int endIdx = 0;
            for(int i = 0 ; i < cur.length() ; i++){
                int tmp = cur.charAt(i)-'0';

                if(startIdx == 0 && tmp >=0 && tmp <= 9){
                    startIdx = i;
                    continue;
                }
                if(tmp >=0 && tmp <= 9){
                    endIdx = i;
                }
            }
            if(endIdx == 0) endIdx = startIdx;
             System.out.println("S:"+startIdx);
             System.out.println("e:"+endIdx);
            String HEAD = cur.substring(0, startIdx);
            String NUMBER = cur.substring(startIdx, endIdx);
            String TAIL = endIdx == cur.length() ? "" : cur.substring(endIdx, cur.length());
            System.out.println(cur);
            System.out.println(HEAD);
            System.out.println(NUMBER);
            pq.add(new FileName(HEAD,NUMBER,TAIL));
        }

        String[] answer = new String[pq.size()];
        int idx = 0 ;
        while(!pq.isEmpty()){
            FileName cur = pq.poll();
            answer[idx++] = cur.HEAD+cur.NUMBER+cur.TAIL;
        }
        return answer;
    }
    static class FileName{
        String HEAD,NUMBER,TAIL;

        public FileName(String HEAD, String NUMBER, String TAIL){
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
        }
    }
}
