package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스문제0_11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//링크드 리스트에 1 ~ n 까지 삽입
		LinkedList<Integer> ys = new LinkedList<>();
		for(int i = 1 ; i <= n ; i++)
			ys.add(i);
		//삭제할 인덱스
		int front = 0;
		
		sb.append("<");
		while( n >1 ) {
			front = (front+(k-1)) % n;
			sb.append(ys.remove(front)).append(", ");
			n--;
		}
		sb.append(ys.remove()).append(">");
		
		System.out.println(sb);
	}
}
