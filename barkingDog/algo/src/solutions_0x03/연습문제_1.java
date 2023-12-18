package solutions_0x03;

public class 연습문제_1 {
    static int[] input ={1,23,53,77,60};
    public static void main(String[] args) {
        int[] arr = new int[101]; // 등장 여부 저장

        for(int i = 0 ; i < input.length ; i++){
            if(arr[100 - input[i]] == 1){ // input의 원소 를 돌며 합이 100이되는 수가 나왔는지 여부 확인
                System.out.println(1);
                return;
            }
            arr[input[i]] = 1;

        }

        System.out.println(0);
    }
}
