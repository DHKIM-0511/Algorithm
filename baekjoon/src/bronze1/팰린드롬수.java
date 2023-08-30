package bronze1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0"))
				break;
			
			int[] arr = new int[str.length()];
			
			for(int i = 0 ; i < str.length() ; i++) {
				arr[i] = str.charAt(i)-'0';
			}
			
			boolean check = true;
			for(int i = 0 ; i < str.length()/2 ; i++) {
				if(arr[i] != arr[str.length()-1-i])
					check = false;
			}
			if(check) {
				System.out.println("yes");
			}else
				System.out.println("no");
			
		}
		
	}
}
