package silver4;

import java.util.LinkedList;
import java.util.Scanner;

public class 요세푸스문제_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= n ; i++) {
			list.add(i);
		}
		
		int front = 0;
		sb.append("<");
		while(list.size() > 1) {
			front = (front+(k-1)) % list.size();
			
			sb.append(list.remove(front)+", ");
			
		}
		sb.append(list.remove()).append(">");
		
		System.out.println(sb);
	}
}
