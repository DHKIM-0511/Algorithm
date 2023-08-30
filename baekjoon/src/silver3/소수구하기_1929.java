package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
	static boolean[] prime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		prime = new boolean[N+1];
		getPrime();
		StringBuilder sb = new StringBuilder();
		
		for(int i = M ; i <= N ; i++) {
			
			if(!prime[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	//루트 N이하의 자연수 중 나누어떨어진다면 소수이다
	//루트 N까지의 자연수 중 자연수 k를 제외한 모든 k의 배수는 소수가 아님
	private static void getPrime() {
		//flase = 소수
		prime[0] = prime[1] = true;
		
		for(int i = 2 ; i <= Math.sqrt(prime.length) ; i++) {
			if(prime[i]) continue;
			for(int j = i*i ; j < prime.length ; j+= i) {
				prime[j] = true;
			}
		}
	}
}
