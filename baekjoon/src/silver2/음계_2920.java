package silver2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계_2920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = {1,2,3,4,5,6,7,8};
		int[] Input = new int[8];
		int flag = 0;
		
		for(int i = 0 ; i < 8 ; i++) {
			Input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(flag==0) { // 오름차순인지 검사
			for(int i = 0 ; i < 8 ; i++ ) {
				if(Input[i] != num[i]) {
					flag = 1;
					break;
				}
			}
		}
		
		if(flag==1) { //내림차순인지 검사
			for(int i = 0, idx = 7 ; i < 8 ; i++) {
				if(Input[i] != num[idx--]){
					flag = 2;
					break;
				}
			}
		}
		
		if(flag==0)
			System.out.println("ascending");
		else if (flag == 1)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
