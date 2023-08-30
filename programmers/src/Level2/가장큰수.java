package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장큰수 {
	public String solution(int[] numbers) {
        String answer = ""; 

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }//입력
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as)); 
        });//리스트의 두 원소를 비교하는데 스트링형으로 붙인 결과를 비교하하여 더 큰값을 앞으로
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString(); // 스트링빌더 - > 스트링
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}




//

//String answer = Integer.toString(numbers[0]);
//
//for(int i = 1 ; i < numbers.length ; i++) {
//	String tmp = Integer.toString(numbers[i]);
//	
//	if(answer.charAt(0) < tmp.charAt(0)) {
//		answer = tmp+answer;
//	}else if (answer.charAt(0) > tmp.charAt(0)) {
//		answer = answer+tmp;
//	}else {
//		
//	}
//}
