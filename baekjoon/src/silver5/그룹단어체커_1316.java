package silver5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커_1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		a:for(int i = 0 ; i < n ; i ++) {
			boolean[] abc = new boolean[26]; // 알파벳 배열
			String tmp = br.readLine();
			abc[tmp.charAt(0)-'0'-49]=true; // 첫번째 알파벳은 방문처리
			
			for(int j = 1 ; j < tmp.length() ; j++) {
				if(abc[tmp.charAt(j)-'0'-49] == false) { // 방문처리
					abc[tmp.charAt(j)-'0'-49]=true;
				}
				else if(tmp.charAt(j-1) == tmp.charAt(j)) { // 연속된 수면 넘어감
					
				}else // 방문도 이미 했고 , 연속된 수 도 아니면 증감연산자 스킵
					continue a;
			}
			ans++;
		}
		System.out.println(ans);
	}
}