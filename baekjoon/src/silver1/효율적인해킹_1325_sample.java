package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 효율적인해킹_1325_sample {
    
    public static StringTokenizer st;
    public static int N,M,cnt,res;
    public static List<Integer>[] list;
    public static int[] cntArr,inDegree;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N+1];
        cntArr = new int[N+1];
        
        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
    
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            //B를 해킹하면 A도 해킹 가능
            list[B].add(A);
        }
        res = 0;
        
        for(int i=1; i<N+1; i++) {
        	visited = new boolean[N+1];
        	cnt=0;
    		hacking(i);	
    		cntArr[i] = cnt;
        	res = Math.max(res, cnt);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<N+1; i++) {
            if(cntArr[i] == res) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
     }

    public static void hacking(int i) {
    	
    	Stack<Integer> stack = new Stack<>();
    	stack.push(i);
        
    	while(!stack.isEmpty()) {
    		int cur = stack.pop();
    		for(int next : list[cur]) {
    			if(!visited[next]) {
    				stack.push(next);
    				visited[next] = true;
    				cnt++;
    			}
    		}
    	}
    }
}